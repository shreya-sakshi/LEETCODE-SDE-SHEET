package BinarySearch;

public class MinimumDayToMakeMBouquets {

    // Function to check if it's possible to make m bouquets with k adjacent flowers on or before 'day'
    static boolean possible(int[] arr, int day, int m, int k) {
        int cnt = 0;      // Count of consecutive flowers that can be used
        int noOfB = 0;    // Number of bouquets formed

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= day) {
                cnt++;   // Flower can be picked
            } else {
                noOfB += (cnt / k);  // Add bouquets from previous segment
                cnt = 0;            // Reset counter
            }
        }

        // Handle the last segment
        noOfB += (cnt / k);

        return noOfB >= m;  // Check if we can make at least m bouquets
    }

    // Main function to find minimum day to make m bouquets of k flowers
    static int roseGarden(int[] arr, int m, int k) {
        long val = (long) m * k;  // Total flowers needed

        if (val > arr.length) return -1;  // Not enough flowers

        // Find min and max days in the array
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for (int num : arr) {
            mini = Math.min(mini, num);
            maxi = Math.max(maxi, num);
        }

        int low = mini, high = maxi;
        int ans = -1;

        // Binary search for minimum day
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (possible(arr, mid, m, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 10, 3, 10, 2};
        int m = 3;
        int k = 1;

        int result = roseGarden(arr, m, k);
        System.out.println("Minimum day to make " + m + " bouquets: " + result);
    }
}
