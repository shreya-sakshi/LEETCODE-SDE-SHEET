package BinarySearch;
import java.util.*;

public class CapacityToShipPackagesWithinDDays {

    // Helper function: Find how many days are needed if the ship's capacity is 'cap'
    public static int findDays(int[] weights, int cap) {
        int days = 1; // Start with 1 day
        int load = 0; // Current load on the ship

        for (int i = 0; i < weights.length; i++) {
            // If adding the current package exceeds capacity, we need a new day
            if (weights[i] + load > cap) {
                days += 1;       // Increment days needed
                load = weights[i]; // Start new load with the current package
            } else {
                load += weights[i]; // Add the current package to today's load
            }
        }

        return days; // Return the total number of days needed
    }

    // Main function: Find the minimum capacity needed to ship packages within 'd' days
    public static int leastWeightCapacity(int[] weights, int d) {
        // The minimum capacity must be at least the heaviest package
        int low = Arrays.stream(weights).max().getAsInt();

        // The maximum capacity could be the total sum of all package weights
        int high = Arrays.stream(weights).sum();

        int result = high; // Initialize result with the highest possible capacity

        // Binary Search to find the minimum capacity
        while (low <= high) {
            int mid = low + (high - low) / 2; // Find the middle capacity
            int numberOfDays = findDays(weights, mid); // Check how many days needed with this capacity

            if (numberOfDays <= d) {
                // If we can ship in 'd' or fewer days, try a smaller capacity
                result = mid;
                high = mid - 1;
            } else {
                // If we need more than 'd' days, increase capacity
                low = mid + 1;
            }
        }

        return result; // Return the minimum capacity found
    }

    // Main method to test the code
    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // Example weights of packages
        int days = 5; // Number of days to ship

        System.out.println("Minimum Capacity Required: " + leastWeightCapacity(weights, days));
    }
}
