package BinarySearch;

public class KokoEatingBananas {

    // Function to find the maximum number in the array (maximum bananas in a pile)
    int findMax(int[] v) {
        int maxi = Integer.MIN_VALUE; // Initialize maximum with the smallest possible integer
        int n = v.length;

        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, v[i]); // Update maxi if the current element is greater
        }

        return maxi; // Return the largest pile size
    }

    // Function to calculate total hours needed to eat all bananas at a given eating rate (hourly)
    int calculateTotalHours(int[] v, int hourly) {
        int totalH = 0; // Initialize total hours
        int n = v.length;

        for (int i = 0; i < n; i++) {
            // For each pile, calculate hours required at the current hourly rate (use ceil to round up)
            totalH += Math.ceil((double) v[i] / (double) hourly);
        }

        return totalH; // Return total hours needed
    }

    // Function to find the minimum eating speed (bananas per hour) so Koko can eat all bananas in h hours
    int minimumRateToeatBananas(int[] v, int h) {
        int low = 1, high = findMax(v); // Initialize binary search range

        // Perform binary search
        while (low <= high) {
            int mid = (low + high) / 2; // Midpoint: current candidate eating rate

            int totalhours = calculateTotalHours(v, mid); // Calculate hours needed at current rate

            if (totalhours <= h) {
                // If Koko can finish in less or equal hours, try a slower speed (reduce high)
                high = mid - 1;
            } else {
                // If it takes too many hours, increase the speed (increase low)
                low = mid + 1;
            }
        }

        // When the loop exits, 'low' is the minimum eating speed that allows Koko to finish in h hours
        return low;
    }

    public static void main(String[] args) {
        int arr[] = {3, 6, 7, 11}; // Array of banana piles
        int h = 8; // Total hours available

        KokoEatingBananas solution = new KokoEatingBananas();

        System.out.println("Minimum no. of bananas the monkey can eat in " + h + " hours: " + solution.minimumRateToeatBananas(arr, h));
    }
}
