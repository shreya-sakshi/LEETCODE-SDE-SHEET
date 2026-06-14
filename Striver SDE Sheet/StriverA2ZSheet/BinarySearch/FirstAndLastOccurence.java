package BinarySearch;

public class FirstAndLastOccurence {

    /**
     * Finds the index of the first element which is not less than the target (i.e., lower bound).
     * If target exists, this gives the first occurrence.
     */
    public int lowerBound(int[] arr, int n, int target) {
        int ans = n; // Default to n if target is greater than all elements
        int low = 0, high = n - 1;

        // Binary search for lower bound
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= target) {
                ans = mid;         // Update answer to mid
                high = mid - 1;    // Move to left half to find first occurrence
            } else {
                low = mid + 1;     // Move to right half
            }
        }

        return ans; // This returns the index of the first element >= target
    }

    /**
     * Finds the index of the first element greater than the target (i.e., upper bound).
     * If target exists, this returns the index just after the last occurrence.
     */
    public int upperBound(int[] arr, int n, int target) {
        int ans = n; // Default to n if all elements are <= target
        int low = 0, high = n - 1;

        // Binary search for upper bound
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] > target) {
                ans = mid;        // Update answer to mid
                high = mid - 1;   // Move to left half
            } else {
                low = mid + 1;    // Move to right half
            }
        }

        return ans; // This returns the index of the first element > target
    }

    /**
     * Returns the first and last occurrence index of target element 'k'.
     * If not found, returns {-1, -1}.
     */
    public int[] firstlastoccurence(int[] arr, int n, int k) {
        int lb = lowerBound(arr, n, k); // First index where element >= k

        // If lb is out of bounds or not equal to k, then k doesn't exist
        if (lb == n || arr[lb] != k) return new int[]{-1, -1};

        int ub = upperBound(arr, n, k); // Index after last occurrence of k

        // Return first occurrence and last occurrence (ub - 1)
        return new int[]{lb, ub - 1};
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 8, 8, 11, 13};
        int n = arr.length;
        int x = 8;

        FirstAndLastOccurence flo = new FirstAndLastOccurence();

        int[] firstlastoccurence = flo.firstlastoccurence(arr, n, x);

        System.out.println("First Position: " + firstlastoccurence[0]);
        System.out.println("Last Position: " + firstlastoccurence[1]); // fixed typo
    }
}
