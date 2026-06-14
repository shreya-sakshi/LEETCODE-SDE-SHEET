package String;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        // Step 1: Handle edge cases
        if (strs == null || strs.length == 0) {
            return ""; // If the input array is null or empty, return an empty string
        }

        // Step 2: Initialize a StringBuilder to store the common prefix
        StringBuilder res = new StringBuilder();

        // Step 3: Iterate over each character in the first string
        for (int i = 0; i < strs[0].length(); i++) {
            // Store the current character from the first string
            char currentChar = strs[0].charAt(i);

            // Step 4: Compare this character with the corresponding character in all other strings
            for (String s : strs) {
                // If the current index exceeds the length of any string OR characters don't match
                if (i == s.length() || s.charAt(i) != currentChar) {
                    return res.toString(); // Return the prefix found so far
                }
            }

            // Step 5: If the character is common across all strings, add it to the result
            res.append(currentChar);
        }

        // Step 6: Return the final common prefix
        return res.toString();
    }

    public static void main(String[] args) {
        LongestCommonPrefix solution = new LongestCommonPrefix();
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(solution.longestCommonPrefix(strs)); // Output: "fl"
    }
    
}
