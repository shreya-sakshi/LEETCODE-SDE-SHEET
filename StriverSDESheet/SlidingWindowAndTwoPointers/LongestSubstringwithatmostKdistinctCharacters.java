package SlidingWindowAndTwoPointers;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithatmostKdistinctCharacters {

    // Function to find the longest substring with at most 'k' distinct characters
    public  int longestSubstringwithatmostKdistinctChar(char[] s, int k) {
        int left = 0, right = 0;
        int maxlen = 0;

        // HashMap to store character frequency in the current window
        Map<Character, Integer> mpp = new HashMap<>();

        // Sliding window starts
        while (right < s.length) {

            // Add rightmost character to the map (or update its count)
            mpp.put(s[right], mpp.getOrDefault(s[right], 0) + 1);

            // Shrink the window until we have at most 'k' distinct characters
            while (mpp.size() > k) {
                mpp.put(s[left], mpp.get(s[left]) - 1);

                // If the frequency becomes 0, remove the character from the map
                if (mpp.get(s[left]) == 0) {
                    mpp.remove(s[left]);
                }

                // Move left boundary forward
                left++;
            }

            // Update the max length of the valid window
            if (mpp.size() <= k) {
                maxlen = Math.max(maxlen, right - left + 1);
            }

            // Move right boundary forward
            right++;
        }

        return maxlen;
    }

    public static void main(String[] args) {
        char[] s = {'a', 'a', 'a', 'b', 'b', 'c', 'c', 'd'};
        int k = 2;
        LongestSubstringwithatmostKdistinctCharacters solution = new LongestSubstringwithatmostKdistinctCharacters();
        System.out.println(solution.longestSubstringwithatmostKdistinctChar(s, k)); // Output: 5
    }
}
