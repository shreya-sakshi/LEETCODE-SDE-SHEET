package BinarySearch;

public class BinarySearch {

    // Recursive Binary Search function TC-> O(log n)
    public static int bs(int[] nums, int low, int high, int target) {
        // Base case: If the search space is invalid
        if (low > high) {
            return -1; // Target not found
        }

        // Calculate the middle index
        int mid = (low + high) / 2;

        // If the middle element is the target, return its index
        if (nums[mid] == target) {
            return mid;
        }
        // If the target is greater, search in the right half
        else if (target > nums[mid]) {
            return bs(nums, mid + 1, high, target);
        }
        // If the target is smaller, search in the left half
        else {
            return bs(nums, low, mid - 1, target);
        }
    }

    // Helper method to initiate binary search
    public static int search(int[] nums, int target) {
        return bs(nums, 0, nums.length - 1, target); // Search from index 0 to end
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 10, 13, 18}; // Sorted array
        int target = 10; // Element to be searched

        int result = search(nums, target); // Perform binary search

        // Output result
        if (result != -1) {
            System.out.println("Target found at Index : " + result);
        } else {
            System.out.println("Target not found");
        }
    }
}
