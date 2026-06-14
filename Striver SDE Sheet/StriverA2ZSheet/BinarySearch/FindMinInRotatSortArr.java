package BinarySearch;

public class FindMinInRotatSortArr {

    // Method to find the minimum element in a rotated sorted array (no duplicates)
    public int findMin(int[] nums) {

        int low = 0, high = nums.length - 1;
        int ans = Integer.MAX_VALUE; // Initialize ans with maximum possible value

        // Binary search approach
        while (low <= high) {
            int mid = (low + high) / 2; // Find the mid index

            // If the subarray [low...high] is already sorted
            if (nums[low] <= nums[high]) {
                // The minimum element is at the low index
                ans = Math.min(ans, nums[low]);
                break; // No need to continue, we found the minimum
            }

            // If the left half [low...mid] is sorted
            if (nums[low] <= nums[mid]) {
                // Update ans with the minimum of current ans and nums[low]
                ans = Math.min(ans, nums[low]);
                // Discard the left half, search in the right half
                low = mid + 1;
            }
            // Otherwise, the right half [mid...high] is sorted
            else {
                // Update ans with the minimum of current ans and nums[mid]
                ans = Math.min(ans, nums[mid]);
                // Discard the right half, search in the left half
                high = mid - 1;
            }
        }

        return ans; // Return the minimum element found
    }

    public static void main(String[] args) {
        // Example test cases
        // int nums[] = {3, 4, 5, 1, 2}; 
        int nums[] = {4, 5, 6, 7, 0, 1, 2};
        // int nums[] = {11, 13, 15, 17};
        // int nums[] = {1};

        FindMinimumInRotatedSortedArray minimum = new FindMinimumInRotatedSortedArray();
        int min = minimum.findMin(nums);

        if (min != -1) {
            System.out.println("The minimum value in sorted array: " + min);
        } else {
            System.out.println("Minimum value not found");
        }
    }
}


// The time complexity of your findMin function is:

// 🕐 Time Complexity: O(log n)
// Reason:

// You are applying binary search — each time you approximately halve the search space (either low = mid + 1 or high = mid - 1).

// Halving the array repeatedly takes log n steps in the worst case.

// Thus, binary search behavior → O(log n).

// 📦 Space Complexity: O(1)
// Reason:

// You are using only a constant number of variables (low, high, mid, ans).

// No extra arrays, lists, or recursion stack.

// Thus, the space complexity is O(1).

