package BinarySearch;
import java.util.*;

public class AggressiveCows {

    // This function checks whether it's possible to place 'cows' cows in 'stalls'
    // such that the minimum distance between any two cows is at least 'dist'
    public static boolean canWePlace(List<Integer> stalls, int dist, int cows) {
        int cntCows = 1; // Always place the first cow at the first stall
        int last = stalls.get(0); // Track position of the last cow placed

        // Start from the second stall and try to place remaining cows
        for (int i = 1; i < stalls.size(); i++) {
            // If the current stall is at least 'dist' units away from last placed cow
            if (stalls.get(i) - last >= dist) {
                cntCows++; // Place the cow
                last = stalls.get(i); // Update last placed cow's position
            }
        }

        // Return true if at least 'cows' cows are placed
        return cntCows >= cows;
    }

    // This function performs binary search to find the maximum possible minimum distance
    public static int aggressiveCows(List<Integer> stalls, int k) {
        Collections.sort(stalls); // Sort the stall positions in increasing order
        int n = stalls.size();

        int low = 1; // Minimum possible distance between cows
        int high = stalls.get(n - 1) - stalls.get(0); // Maximum possible distance
        int result = 0; // Store the answer (maximum minimum distance)

        // Binary search for the largest minimum distance
        while (low <= high) {
            int mid = (low + high) / 2; // Try placing cows with this distance

            // If we can place all cows with at least 'mid' distance
            if (canWePlace(stalls, mid, k)) {
                result = mid; // It's a valid answer, try to find a better (larger) one
                low = mid + 1;
            } else {
                high = mid - 1; // Too tight, try smaller distance
            }
        }

        return result; // Return the largest minimum distance found
    }

    public static void main(String[] args) {
        // Example input
        List<Integer> stalls = Arrays.asList(1, 2, 8, 4, 9); // Stall positions
        int k = 3; // Number of cows to place

        // Call the main logic function
        int maxMinDistance = aggressiveCows(stalls, k);

        // Output the result
        System.out.println("Maximum minimum distance: " + maxMinDistance);
    }
}

