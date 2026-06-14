package BinarySearch;

/**
 * This class finds the first and last occurrence of a number in a sorted array using Binary Search.
 */
public class FirstAndLastOccurenceOptimised {

    /**
     * Finds the first occurrence index of the target element in a sorted array.
     *
     * @param arr    The sorted input array
     * @param n      The number of elements in the array
     * @param target The target element to search for
     * @return The index of the first occurrence; -1 if not found
     */
    public int firstoccurence(int[] arr, int n, int target) {
        int first = -1;
        int low = 0, high = n - 1;

        // Binary search to find the first occurrence
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                first = mid;        // Potential answer found
                high = mid - 1;     // Search on the left side to find earlier occurrence
            } else if (arr[mid] < target) {
                low = mid + 1;      // Move to right half if mid element is smaller
            } else {
                high = mid - 1;     // Move to left half if mid element is greater
            }
        }

        return first; // Returns index of the first occurrence (or -1 if not found)
    }

    /**
     * Finds the last occurrence index of the target element in a sorted array.
     *
     * @param arr    The sorted input array
     * @param n      The number of elements in the array
     * @param target The target element to search for
     * @return The index of the last occurrence; -1 if not found
     */
    public int lastoccurence(int[] arr, int n, int target) {
        int last = -1;
        int low = 0, high = n - 1;

        // Binary search to find the last occurrence
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                last = mid;         // Potential answer found
                low = mid + 1;      // Search on the right side to find later occurrence
            } else if (arr[mid] < target) {
                low = mid + 1;      // Move to right half
            } else {
                high = mid - 1;     // Move to left half
            }
        }

        return last; // Returns index of the last occurrence (or -1 if not found)
    }

    /**
     * Finds both the first and last occurrence indexes of the target element in a sorted array.
     *
     * @param arr The sorted input array
     * @param n   The number of elements in the array
     * @param k   The target element to search for
     * @return An integer array where index 0 is first occurrence and index 1 is last occurrence;
     *         if not found, returns {-1, -1}
     */
    public int[] firstlastoccurenceoptimised(int[] arr, int n, int k) {
        int first = firstoccurence(arr, n, k); // Get the first occurrence index

        // If the first occurrence is not found, return [-1, -1]
        if (first == -1) return new int[]{-1, -1};

        int last = lastoccurence(arr, n, k);   // Get the last occurrence index

        // Return array with both first and last positions
        return new int[]{first, last};
    }

    public static void main(String[] args) {
        int[] arr = {2, 8, 8, 8, 8, 8, 11, 13};
        int n = arr.length;
        int x = 8;

        // Create object of the class
        FirstAndLastOccurenceOptimised flo = new FirstAndLastOccurenceOptimised();

        // Call the method to find first and last occurrence
        int[] firstlastoccurenceoptimised = flo.firstlastoccurenceoptimised(arr, n, x);

        // Print the first and last positions
        System.out.println("First Position: " + firstlastoccurenceoptimised[0]);
        System.out.println("Last Position: " + firstlastoccurenceoptimised[1]);
    }
}
