package BinarySearch;

import java.util.Arrays;

public class FloorCeil {
    // Method to find the floor and ceil for a target value in a sorted array
    private int[] getFloorAndCeil(int[] arr, int x) 
    {
        // Initialize floor and ceil as -1, which means not found initially
        Arrays.sort(arr); 
        int n = arr.length;
        int floor = -1, ceil = -1;
        
        // Set low and high for binary search
        int low = 0, high = n - 1;

        // Binary Search to find floor and ceil
        while(low<=high)
        {
            int mid = (low+high)/2;
            if (arr[mid] == x) {
                // If exact match found, both floor and ceil are the number itself
                floor = arr[mid];
                ceil = arr[mid];
                break;
            } else if (arr[mid] < x) {
                // arr[mid] is a candidate for floor
                floor = arr[mid];
                low = mid + 1;
            } else {
                // arr[mid] is a candidate for ceil
                ceil = arr[mid];
                high = mid - 1;
            }
        }
        // Prepare answer array: ans[0] = floor, ans[1] = ceil
        int[] ans = new int[2];
        ans[0] = floor;
        ans[1] = ceil;

        return ans;
    }

    // Main method to test the function
    public static void main(String[] args) {
        // Sample array (sorted) and target value
        FloorCeil obj = new FloorCeil();

        // Input array (must be sorted)
        int[] arr = {10, 20, 30, 40, 50};
        
        // Target value to find floor and ceil
        int x = 25;

        // Call the method and get the result
        int[] ans = obj.getFloorAndCeil(arr,x);

        // Print the floor and ceil values
        System.out.println("Floor: " + ans[0]);
        System.out.println("Ceil: " + ans[1]);
    }
}
