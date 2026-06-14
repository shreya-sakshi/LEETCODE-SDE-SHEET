package BinarySearch;

public class FindNoOftimesArrayHasBeenRotated {

    // Method to find the index of the minimum element (rotation count) in a rotated sorted array
    public int findnooftimearrayisrotated(int[] nums) {

        int low = 0, high = nums.length - 1;
        int ans = Integer.MAX_VALUE; // Initialize ans with maximum possible value
        int index = -1; // To store the index where the minimum element is found

        // Binary search approach to find the minimum element
        while (low <= high) {
            int mid = (low + high) / 2; // Find the mid index

            // If the current portion [low...high] is already sorted
            if (nums[low] <= nums[high]) {
                // Update ans and index if nums[low] is smaller than current ans
                if (nums[low] < ans) {
                    index = low;
                    ans = nums[low];
                }
                break; // Since subarray is sorted, the minimum is at 'low', we can stop
            }

            // If left half [low...mid] is sorted
            if (nums[low] <= nums[mid]) {
                // Update ans and index if nums[low] is smaller than current ans
                if (nums[low] < ans) {
                    index = low;
                    ans = nums[low];
                }
                // Search in the right half
                low = mid + 1;
            } 
            // Otherwise, right half [mid...high] is sorted
            else {
                // Update ans and index if nums[mid] is smaller than current ans
                if (nums[mid] < ans) {
                    index = mid;
                    ans = nums[mid];
                }
                // Search in the left half
                high = mid - 1;
            }
        }

        return index; // Return the index where minimum value is found (rotation count)
    }

    public static void main(String[] args) {
        // Example test cases
        // int nums[] = {3, 4, 5, 1, 2}; 
        int nums[] = {4, 5, 6, 7, 0, 1, 2};
        // int nums[] = {11, 13, 15, 17};
        // int nums[] = {1};

        // Create an object of the class
        FindNoOftimeArrHasBenRot notais = new FindNoOftimeArrHasBenRot();
        
        // Call the method to find number of times array is rotated
        int nooftimearrayisrotated = notais.findnooftimearrayisrotated(nums);

        // Print the result
        if (nooftimearrayisrotated != -1) {
            System.out.println("The array has been rotated " + nooftimearrayisrotated + " times.");
        } else {
            System.out.println("Minimum value not found");
        }
    }
}
