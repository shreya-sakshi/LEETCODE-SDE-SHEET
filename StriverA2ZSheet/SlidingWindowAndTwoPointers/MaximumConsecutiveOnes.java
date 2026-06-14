package SlidingWindowAndTwoPointers;

import java.util.ArrayList;
import java.util.List;

public class MaximumConsecutiveOnes {

    // Function to find the maximum length of a subarray with at most 'k' zeros
    public int maxconsecutiveones(List<Integer> nums, int k) {
        int left = 0, right = 0;
        int maxlen = 0;
        int zeros = 0;

        // Traverse the list using a sliding window
        while (right < nums.size()) {
            // If we encounter a 0, increment the zero count
            if (nums.get(right) == 0) {
                zeros++;
            }

            // Shrink the window from the left if zero count exceeds k
            while (zeros > k) {
                if (nums.get(left) == 0) {
                    zeros--;
                }
                left++;
            }
             
            if(zeros <= k)
            {              
                int length = right - left + 1;
                maxlen = Math.max(maxlen, length);
            }

            // Expand the window from the right
            right++;
        }

        return maxlen;
    }

    public static void main(String[] args) {
        MaximumConsecutiveOnes solution = new MaximumConsecutiveOnes();
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(1);
        nums.add(1);
        nums.add(0);
        nums.add(0);
        nums.add(0);
        nums.add(1);
        nums.add(1);
        nums.add(1);
        nums.add(1);
        nums.add(0);

        int k = 2;

        // Output: Longest subarray of 1s after flipping at most 2 zeros
        System.out.println(solution.maxconsecutiveones(nums, k)); // Output: 6
    }
}
