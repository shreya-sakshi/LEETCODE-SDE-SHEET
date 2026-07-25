import java.util.List;

class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {

        // DP array
        boolean[] dp = new boolean[s.length() + 1];

        // Base case: empty string is always valid
        dp[s.length()] = true;

        // Traverse from right to left
        for (int i = s.length() - 1; i >= 0; i--) {

            // Check every word in dictionary
            for (String w : wordDict) {

                // Check if word fits and matches
                if ((i + w.length()) <= s.length()
                        && s.substring(i, i + w.length()).equals(w)) {

                    dp[i] = dp[i + w.length()];
                }

                // If valid segmentation found, stop checking
                if (dp[i]) {
                    break;
                }
            }
        }

        return dp[0];
    }
}
