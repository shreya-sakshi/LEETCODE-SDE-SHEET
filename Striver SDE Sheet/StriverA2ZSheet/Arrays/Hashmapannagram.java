package Arrays;
import java.util.HashMap;
import java.util.Map;

class Hashmapannagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> countS = new HashMap<>();
        Map<Character, Integer> countT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            countS.put(charS, countS.getOrDefault(charS, 0) + 1);
            countT.put(charT, countT.getOrDefault(charT, 0) + 1);
        }

        for (char c : countS.keySet()) {
            if (!countS.get(c).equals(countT.getOrDefault(c, 0))) {
                return false;
            }
        }

        return true;
    }

    // Main method to test the isAnagram function
    public static void main(String[] args) {
        Hashmapannagram hashmapannagram = new Hashmapannagram();

        // Test case
        String s = "anagram";
        String t = "nagaram";

        boolean result = hashmapannagram.isAnagram(s, t);
        System.out.println("Is Anagram: " + result);
    }
}
