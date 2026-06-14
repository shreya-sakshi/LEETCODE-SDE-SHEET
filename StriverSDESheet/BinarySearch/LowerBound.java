package BinarySearch;

public class LowerBound {
    // Function to find the lower bound of target in a sorted array
    public int lowerBound(int[] arr, int target) {
        int ans = arr.length; // Default answer is the array length (if target is greater than all elements)
        int low = 0, high = arr.length - 1;
        
        // Standard binary search
        while (low <= high) {
            int mid = (low + high) / 2; // Find the middle index
            
            if (arr[mid] >= target) {
                ans = mid;
            // If mid element is greater than or equal to target, move to the left half agar target chota hai array of mid sai
                high = mid - 1;
            } else {
                // Else, move to the right half agar target bara hai array of mid sai
                low = mid + 1;
            }
        }
        
        // Return the final answer (index of lower bound)
        return ans;
    }

    
public static void main(String[] args) 
{
        LowerBound solution = new LowerBound();
        
        int[] arr = {1, 3, 5, 7, 9};
        int target = 6;
        
        int index = solution.lowerBound(arr, target);
        System.out.println("Lower bound index of " + target + " is: " + index);
}

}
