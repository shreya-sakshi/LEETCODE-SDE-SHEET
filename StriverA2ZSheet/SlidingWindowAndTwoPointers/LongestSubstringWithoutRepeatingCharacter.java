package SlidingWindowAndTwoPointers;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacter {
    public int LengthOfLongestSubstringwithoutrepaetingchar(String s) {
      HashMap<Character, Integer > mpp = new HashMap<>();

        int l=0;
        int r =0;
        int maxLen = 0;

        while(r < s.length())
        {
            char current = s.charAt(r);

            if(mpp.containsKey(current) && mpp.get(current) >=l)
            {
                l = mpp.get(current) + 1;
            }

            int len = r-l+1;
            maxLen = Math.max(maxLen, len);

           mpp.put(current , r);

            r++;
        }
        return maxLen;
    }

     public static void main(String[] args) {
        String s = "abcdeab";
        LongestSubstringWithoutRepeatingCharacter solution = new LongestSubstringWithoutRepeatingCharacter();
        System.out.println(solution.LengthOfLongestSubstringwithoutrepaetingchar(s)); // Output: 5
    }
}
