package SlidingWindowAndTwoPointers;

public class MaximumPointsFromCards {
    public int maximumPointsFromCards(int[] nums, int k) {
        int lsum = 0, rsum = 0, maxsum = 0;
        int n = nums.length;

        // Step 1: Compute the initial left sum (sum of the first k elements)
        for (int i = 0; i < k; i++) {
            lsum += nums[i];
        }
        maxsum = lsum; // Store the initial sum as the maximum sum initially

        // Step 2: Use a sliding window approach to explore other combinations
        int rindex = n - 1; // Start picking elements from the rightmost side

        // Step 3: Shift the window by removing elements from the left and adding from the right
        for (int i = k - 1; i >= 0; i--) {
            lsum -= nums[i];  // Remove the last element from the left window
            rsum += nums[rindex]; // Add one element from the right end
            rindex--; // Move the right index leftward

            // Update maxsum to store the maximum possible sum obtained
            maxsum = Math.max(maxsum, lsum + rsum);
        }

        // Return the maximum sum we found
        return maxsum;
    }

    public static void main(String[] args) {
        int[] nums = {6, 2, 3, 4, 7, 2, 1, 7, 1}; // Example array
        int k = 4; // Number of cards that can be picked
        MaximumPointsFromCards cards = new MaximumPointsFromCards();
        System.out.println(cards.maximumPointsFromCards(nums, k));  // Expected output: 18
    }
}
