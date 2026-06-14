package BinarySearch;

public class SearchInRotatedSortedArrayPart2 {

    // Time Complexity: Approximately O(n/2) in the worst case due to duplicates

    // Method to search for a target in a rotated sorted array that may contain duplicates
    public boolean searchInSortedArray(int[] arr, int n, int target) {
        int low = 0, high = n - 1;
        
        while (low <= high) {
            // Find the middle index to divide the array
            int mid = low + (high - low) / 2; // Safer way to avoid integer overflow

            // Check if the middle element is the target
            if (arr[mid] == target) return true;

            // Handle duplicates: when arr[low], arr[mid], and arr[high] are all equal
            // We cannot determine which half is sorted, so shrink the search space
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low++;
                high--;
                continue; // Skip the current iteration and recheck
            }

            // Check if the left half [low...mid] is sorted
            if (arr[low] <= arr[mid]) {
                // If target lies within the left sorted half
                if (arr[low] <= target && target <= arr[mid]) {
                    high = mid - 1; // Narrow down search to left half
                } else {
                    low = mid + 1;  // Otherwise, search in the right half
                }
            }
            // Otherwise, the right half [mid...high] must be sorted
            else {
                // If target lies within the right sorted half
                if (arr[mid] <= target && target <= arr[high]) {
                    low = mid + 1;  // Search in the right half
                } else {
                    high = mid - 1; // Otherwise, search in the left half
                }
            }
        }
        
        // If the target is not found in the array
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2}; // Example rotated sorted array (no duplicates here)
        int n = arr.length;
        int x = 0; // Target element to search

        SearchInRotatedSortedArrayPart2 sirst2 = new SearchInRotatedSortedArrayPart2();
        boolean found = sirst2.searchInSortedArray(arr, n, x);

        System.out.println("The target is found: " + found);
    }
}
