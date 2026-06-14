package BinarySearch;

// Class to find a peak element in an array
class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        // Check if the first element is a peak
        if (nums[0] > nums[1]) return 0;

        // Check if the last element is a peak
        if (nums[n - 1] > nums[n - 2]) return n - 1;

        // Initialize binary search boundaries
        int low = 1, high = n - 2;

        while (low <= high) {
            int mid = (low + high) / 2;

            // If mid is greater than both neighbors, it's a peak
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            // If mid is greater than left neighbor, move right
            else if (nums[mid] > nums[mid - 1]) {
                low = mid + 1;
            }
            // If mid is greater than right neighbor, move left
            else if (nums[mid] > nums[mid + 1]) {
                high = mid - 1;
            }
            // Otherwise, move right
            else {
                low = mid + 1;
            }
        }

        // If no peak is found (theoretically shouldn't happen as per problem guarantee)
        return -1;
    }

    public static void main(String[] args) {
        FindPeakElement solution = new FindPeakElement();
        
        int[] arr = {1, 2, 1, 3, 5, 6, 4}; // Example array
        
        int index = solution.findPeakElement(arr);
        System.out.println("Peak element is at index: " + index);
    }
}
