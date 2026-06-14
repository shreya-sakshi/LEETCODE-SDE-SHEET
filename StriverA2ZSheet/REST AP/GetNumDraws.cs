public static int getNumDraws(int year)
{
    int totalDraws = 0;

    using (HttpClient client = new HttpClient())
    {
        for (int goals = 0; goals <= 10; goals++)
        {
            string url = $"https://jsonmock.hackerrank.com/api/football_matches?year={year}&team1goals={goals}&team2goals={goals}";

            var response = client.GetStringAsync(url).Result;

            var jsonDoc = JsonDocument.Parse(response);
            int total = jsonDoc.RootElement.GetProperty("total").GetInt32();

            totalDraws += total;
        }
    }

    return totalDraws;
}