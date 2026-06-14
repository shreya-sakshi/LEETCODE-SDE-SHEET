package SlidingWindowAndTwoPointers;

import java.util.*;

public class FruitsIntoBasket {

    // Function to find the length of the longest subarray with at most 'k' distinct elements
    public  int fruitsIntoBasket(int arr[], int k) {
        int left = 0, right = 0;
        int maxlen = 0;

        // HashMap to store the count of each element in the current window
        Map<Integer, Integer> mpp = new HashMap<>();

        // Sliding window starts
        while (right < arr.length) {

            // Add the rightmost element to the map and update its frequency
            mpp.put(arr[right], mpp.getOrDefault(arr[right], 0) + 1);

            // If there are more than 'k' distinct elements, shrink the window from the left
            while (mpp.size() > k) {
                mpp.put(arr[left], mpp.get(arr[left]) - 1); // Reduce count of leftmost element

                // If its count becomes 0, remove it completely from the map
                if (mpp.get(arr[left]) == 0) {
                    mpp.remove(arr[left]);
                }

                // Move the left boundary of the window forward
                left++;
            }

            // Update max length of the window if it's valid (<= k distinct elements)
            if (mpp.size() <= k) {
                maxlen = Math.max(maxlen, right - left + 1);
            }

            // Expand the window by moving right pointer
            right++;
        }

        return maxlen;
    }

    public static void main(String[] args) {
        int arr[] = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        int k = 2;
        FruitsIntoBasket solution = new FruitsIntoBasket();
        System.out.println(solution.fruitsIntoBasket(arr, k)); // Output: 5
    }
}
