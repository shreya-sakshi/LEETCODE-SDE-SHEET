package BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class CountOccurenceOfanumberInsortedArraywithDuplicatesArrayList {

    /**
     * Finds the first occurrence of the target element in a sorted array.
     * @param arr Sorted array
     * @param n Size of array
     * @param target Target value to find
     * @return Index of the first occurrence or -1 if not found
     */
    public int firstOccurrence(int[] arr, int n, int target) {
        int first = -1;
        int low = 0, high = n - 1;

        // Binary search loop
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                first = mid;         // Save current mid as a potential first occurrence
                high = mid - 1;       // Search towards left (lower indexes)
            } else if (arr[mid] < target) {
                low = mid + 1;         // Target is in right half
            } else {
                high = mid - 1;        // Target is in left half
            }
        }
        return first;
    }

    /**
     * Finds the last occurrence of the target element in a sorted array.
     * @param arr Sorted array
     * @param n Size of array
     * @param target Target value to find
     * @return Index of the last occurrence or -1 if not found
     */
    public int lastOccurrence(int[] arr, int n, int target) {
        int last = -1;
        int low = 0, high = n - 1;

        // Binary search loop
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                last = mid;           // Save current mid as a potential last occurrence
                low = mid + 1;         // Search towards right (higher indexes)
            } else if (arr[mid] < target) {
                low = mid + 1;         // Target is in right half
            } else {
                high = mid - 1;        // Target is in left half
            }
        }
        return last;
    }

    /**
     * Returns a list containing first and last occurrence indexes.
     * @param arr Sorted array
     * @param n Size of array
     * @param k Target value
     * @return List of two integers {first occurrence, last occurrence}, or {-1, -1} if not found
     */
    public List<Integer> firstLastOccurrenceOptimised(int[] arr, int n, int k) {
        int first = firstOccurrence(arr, n, k);

        // If element not found
        if (first == -1) {
            List<Integer> result = new ArrayList<>();
            result.add(-1);
            result.add(-1);
            return result;
        }

        int last = lastOccurrence(arr, n, k);

        // Create list to store first and last indexes
        List<Integer> result = new ArrayList<>();
        result.add(first);
        result.add(last);

        return result;
    }

    /**
     * Counts the total number of times the target element appears in the array.
     * @param arr Sorted array
     * @param n Size of array
     * @param k Target value
     * @return Number of occurrences
     */
    public int count(int[] arr, int n, int k) {
        List<Integer> ans = firstLastOccurrenceOptimised(arr, n, k);

        // If element not found
        if (ans.get(0) == -1) {
            return 0;
        }

        // Total occurrences = (last index - first index) + 1
        return ans.get(1) - ans.get(0) + 1;
    }

    public static void main(String[] args) {
        // Sample sorted array with duplicates
        int[] arr = {2, 8, 8, 8, 8, 8, 11, 13};
        int n = arr.length;
        int x = 8; // Element to find

        // Create object of class
        CountOccurenceOfanumberInsortedArraywithDuplicates obj = new CountOccurenceOfanumberInsortedArraywithDuplicates();

        // Call count method
        int count = obj.count(arr, n, x);

        // Print result
        System.out.println("Count of occurrence of number in sorted array with duplicates is: " + count);
    }
}
