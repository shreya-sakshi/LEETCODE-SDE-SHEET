package String;


import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        // If the lengths of the strings are different, they cannot be isomorphic
        if (s.length() != t.length()) {
            return false;
        }

        // Create two hash maps:
        // 1. mapST -> Maps characters from 's' to 't'
        // 2. mapTS -> Maps characters from 't' to 's'
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        // Iterate through each character of the strings
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i); // Character from string 's'
            char c2 = t.charAt(i); // Corresponding character from string 't'

            // Check if there's a mismatch in existing mappings
            if ((mapST.containsKey(c1) && mapST.get(c1) != c2) || // 'c1' is mapped but not to 'c2'
                (mapTS.containsKey(c2) && mapTS.get(c2) != c1)) { // 'c2' is mapped but not to 'c1'
                return false; // Not isomorphic if the mapping is inconsistent
            }

            // Add new mappings
            mapST.put(c1, c2); // Map 'c1' to 'c2'
            mapTS.put(c2, c1); // Map 'c2' to 'c1' (ensures uniqueness)
        }

        // If no mismatches were found, the strings are isomorphic
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        String s1 = "egg";
        String t1 = "add";
        System.out.println(solution.isIsomorphic(s1, t1)); // Output: true

        // Test case 2
        String s2 = "foo";
        String t2 = "bar";
        System.out.println(solution.isIsomorphic(s2, t2)); // Output: false

        // Test case 3
        String s3 = "paper";
        String t3 = "title";
        System.out.println(solution.isIsomorphic(s3, t3)); // Output: true
    }
}
