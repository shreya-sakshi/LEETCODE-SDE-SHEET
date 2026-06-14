package Arrays;
import java.util.Arrays;

class AnnagramBruteForce {

    // Method to check if two strings are anagrams
    public boolean isAnagram(String s, String t) {
        // Step 1: If the lengths are different, they can't be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Step 2: Convert both strings to character arrays
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        // Step 3: Sort both character arrays
        Arrays.sort(sArray);
        Arrays.sort(tArray);

        // Step 4: Compare the sorted arrays
        return Arrays.equals(sArray, tArray);
    }

    // Main method to test the isAnagram function
    public static void main(String[] args) {
        AnnagramBruteForce solution = new AnnagramBruteForce();

        // Test case
        String s = "listen";
        String t = "silent";

        // Call the isAnagram function and print the result
        boolean result = solution.isAnagram(s, t);
        System.out.println("Are the strings anagrams? " + result);
    }
}
