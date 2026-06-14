package BinarySearch;

public class SearchInsertPosition {
    int searchInsertPosition(int[] arr, int target) {
        int ans = arr.length; // Default answer is the array length (if target is greater than all elements)
        int low = 0, high = arr.length - 1;
        
        // Standard binary search
        while (low <= high) {
            int mid = (low + high) / 2; // Find the middle index
            
            if (arr[mid] >= target) {
                // If mid element is greater than or equal to target, move to the left half
                ans = mid;
                high = mid - 1;
            } else {
                // Else, move to the right half
                low = mid + 1;
            }
        }
        
        // Return the final answer (index of lower bound)
        return ans;
    }

    
public static void main(String[] args) 
{
        SearchInsertPosition solution = new SearchInsertPosition();
        
        int[] arr = {1, 3, 5, 7, 9};
        int target = 6;
        
        int index = solution.searchInsertPosition(arr, target);
        System.out.println("Lower bound index of " + target + " is: " + index);
}
    
}
