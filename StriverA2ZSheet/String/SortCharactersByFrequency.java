package String;

import java.util.*;

public class SortCharactersByFrequency {

    public String sortcharcterbyfreq(String s)
    {       
        // Step 1: Count frequency of each character
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        
        // Step 2: Create a bucket array where index represents frequency
        List<Character>[] buckets = new ArrayList[s.length() + 1];
        for (char key : countMap.keySet()) {
            int freq = countMap.get(key);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }
        
        // Step 3: Build result from highest frequency to lowest
        StringBuilder result = new StringBuilder();
        for (int i = s.length(); i > 0; i--) {
            if (buckets[i] != null) {
                for (char c : buckets[i]) {
                    result.append(String.valueOf(c).repeat(i));
                }
            }
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        SortCharactersByFrequency sol = new SortCharactersByFrequency();
        System.out.println(sol.sortcharcterbyfreq("tree")); // Output: "eert" or "eetr"
        System.out.println(sol.sortcharcterbyfreq("cccaaa")); // Output: "aaaccc" or "cccaaa"
        System.out.println(sol.sortcharcterbyfreq("Aabb")); // Output: "bbAa" or "bbaA"
        
    }
    
}

