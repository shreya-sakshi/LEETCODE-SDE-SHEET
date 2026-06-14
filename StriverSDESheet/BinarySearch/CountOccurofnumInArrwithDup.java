package BinarySearch;

public class CountOccurenceOfanumberInsortedArraywithDuplicates {
     /**
     * If target exists, this gives the first occurrence.
     */
    public int firstoccurence(int[] arr, int n, int target) {
        int first = -1;
        int low = 0, high = n - 1;

        // Binary search for lower bound
        while (low <= high) {
            int mid = (low + high) / 2;

            if(arr[mid] == target)
            {
                first = mid;
                high = mid -1;
            }
            else if (arr[mid] < target) {       
                low = mid + 1;    // Move to left half to find first occurrence
            } else {
                high = mid - 1;     // Move to right half
            }
        }

        return first; // This returns the index of the first occurence
    }

    /**
     * If target exists, this returns the index of last occurrence.
     */
    public int lastoccurence(int[] arr, int n, int target) {
        int last = -1;
        int low = 0, high = n - 1;

        // Binary search 
        while (low <= high) {
            int mid = (low + high) / 2;

            if(arr[mid] == target)
            {
                last = mid;
                low = mid + 1;
            }
            else if (arr[mid] < target) {       
                low = mid + 1;    // Move to left half to find last occurrence
            } else {
                high = mid - 1;     // Move to right half
            }
        }

        return last; // This returns the index of the last occurence
    }

    /**
     * Returns the first and last occurrence index of target element 'k'.
     * If not found, returns {-1, -1}.
     */
    public int[] firstlastoccurenceoptimised(int[] arr, int n, int k) {
        int first = firstoccurence(arr, n, k); // First index where element >= k

        // If lb is out of bounds or not equal to k, then k doesn't exist
        if (first == -1) return new int[]{-1, -1};

        int last = lastoccurence(arr, n, k); // Index after last occurrence of k

        // Return first occurrence and last occurrence (ub - 1)
        return new int[]{first , last};
    }

    public int count(int[] arr, int n, int k) {
        int[] ans = firstlastoccurenceoptimised(arr, n, k); // First index where element >= k

        if (ans[0] == -1) return  0;

        return ans[1] - ans[0] + 1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 8, 8, 8, 8, 8, 11, 13};
        int n = arr.length;
        int x = 8;

        CountOccurenceOfanumberInsortedArraywithDuplicates flo = new CountOccurenceOfanumberInsortedArraywithDuplicates();

        int countOccurenceOfanumberInsortedArraywithDuplicates = flo.count(arr, n, x);

        System.out.println("count Of Occurence Of a number In sorted Array with Duplicates is: " +countOccurenceOfanumberInsortedArraywithDuplicates);
    }
}
