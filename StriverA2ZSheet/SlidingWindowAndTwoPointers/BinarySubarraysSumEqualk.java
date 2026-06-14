package SlidingWindowAndTwoPointers;

import java.util.*;
import java.util.List;

public class BinarySubarraysSumEqualk {

    public int numSubarraysWithSum(List<Integer> nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    private int atMost(List<Integer> nums, int goal) {
        if (goal < 0) return 0;

        int left = 0, sum = 0, count = 0;

        for (int right = 0; right < nums.size(); right++) {
            sum += nums.get(right);

            while (sum > goal) {
                sum -= nums.get(left++);
            }

            count += (right - left + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        BinarySubarraysSumEqualk sol = new BinarySubarraysSumEqualk();

        List<Integer> nums = Arrays.asList(1, 0, 1, 0, 1); // Using List<Integer>
        int goal = 2;

        System.out.println(sol.numSubarraysWithSum(nums, goal));  // Output: 4
    }
    
}
