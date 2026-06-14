package Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean ContainsDuplicate(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        
        for (int n : nums) {
            if (hashSet.contains(n)) {
                return true;
            }
            hashSet.add(n);
        }
        
        return false;
    }

    // Main method to test the containsDuplicate function
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case
        int[] nums = {1, 2, 3, 4, 1}; // Contains duplicate
        boolean result = solution.ContainsDuplicate(nums);
        
        System.out.println("Contains Duplicate: " + result);
    }
}
