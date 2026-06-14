public static int getWinnerTotalGoals(string competition, int year)
{
    using (var client = new HttpClient())
    {
        // STEP 1: Get Winner
        string compUrl = $"https://jsonmock.hackerrank.com/api/football_competitions?name={competition}&year={year}";
        
        var compResponse = client.GetStringAsync(compUrl).Result;

        dynamic compData = Newtonsoft.Json.JsonConvert.DeserializeObject(compResponse);

        string winner = compData.data[0].winner;

        int totalGoals = 0;

        // STEP 2: Winner as team1
        totalGoals += GetGoals(client, competition, year, winner, "team1");

        // STEP 3: Winner as team2
        totalGoals += GetGoals(client, competition, year, winner, "team2");

        return totalGoals;
    }
}

private static int GetGoals(HttpClient client, string competition, int year, string team, string teamType)
{
    int goals = 0;
    int page = 1;
    int totalPages = 1;

    do
    {
        string url = $"https://jsonmock.hackerrank.com/api/football_matches?competition={competition}&year={year}&{teamType}={team}&page={page}";
        var response = client.GetStringAsync(url).Result;

        dynamic data = Newtonsoft.Json.JsonConvert.DeserializeObject(response);

        totalPages = data.total_pages;

        foreach (var match in data.data)
        {
            if (teamType == "team1")
                goals += int.Parse((string)match.team1goals);
            else
                goals += int.Parse((string)match.team2goals);
        }

        page++;

    } while (page <= totalPages);

    return goals;
}