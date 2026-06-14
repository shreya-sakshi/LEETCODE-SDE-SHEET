package BinarySearch;

public class SearchInRotatedSortedArray {

    // TC ~= O(log N)
    // Method to search for a target in a rotated sorted array
    public int searchInSortedArray(int[] arr, int n, int target) {
        int low = 0, high = n - 1;
        
        while (low <= high) {
            // Find the middle index to divide the array
            int mid = low + (high - low) / 2; // Safer way to avoid integer overflow

            // Check if the middle element is the target
            if (arr[mid] == target) return mid;

            // Check if the left half [low...mid] is sorted
            if (arr[low] <= arr[mid]) {
                // If target lies within the left sorted half
                if (arr[low] <= target && target <= arr[mid]) {
                    high = mid - 1; // Narrow down search to left half
                } else {
                    low = mid + 1;  // Else, search in the right half
                }
            }
            // Otherwise, the right half [mid...high] must be sorted
            else {
                // If target lies within the right sorted half
                if (arr[mid] <= target && target <= arr[high]) {
                    low = mid + 1;  // Search in the right half
                } else {
                    high = mid - 1; // Else, search in the left half
                }
            }
        }
        
        // If the target is not found
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2}; // Example rotated sorted array
        int n = arr.length;
        int x = 0; // Target element to search

        SearchInRotatedSortedArray sisa = new SearchInRotatedSortedArray();
        int index = sisa.searchInSortedArray(arr, n, x);

        // Print the result
        if (index != -1) {
            System.out.println("The target is found at index: " + index);
        } else {
            System.out.println("Target not found in the array.");
        }
    }
}
