package BinarySearch;

// Class to find the floor of the square root of a given number
public class FindSquareRootOfANo {

    // Method to find the floor value of the square root of a number n
    public long floorSqrt(int n)
    {
        // Initialize the search range
        long low = 1;
        long high = n;

        // Binary search loop
        while (low <= high)
        {
            // Calculate mid to avoid overflow
            long mid = (low + high) / 2;
            
            // Calculate mid squared
            long val = (mid * mid);

            if (val <= n)
            {
                // If mid^2 is less than or equal to n,
                // we need a bigger value, move to the right half
                low = mid + 1;
            }
            else
            {
                // If mid^2 is greater than n,
                // move to the left half
                high = mid - 1;
            }
        }

        // When loop ends, 'high' will be the floor of sqrt(n)
        return high;
    }

    public static void main(String[] args)
    {
        int n = 28; // Input number

        // Create an instance of the class
        FindSquareRootOfANo solution = new FindSquareRootOfANo();
        
        // Call the floorSqrt method
        long ans = solution.floorSqrt(n);

        // Print the result
        System.out.println("Square root of the number is: " + ans);
    }
}


// ---------------------------------
// public int floorSqrt(int n) {
//     int low = 1, high = n;
//     int ans = 0;  // to store the answer

//     while (low <= high) {
//         int mid = low + (high - low) / 2;
//         long val = (long) mid * mid;  // cast to long to avoid overflow

//         if (val == n) {
//             return mid; // exact square root
//         } else if (val < n) {
//             ans = mid; // store mid as possible answer
//             low = mid + 1;
//         } else {
//             high = mid - 1;
//         }
//     }

//     return ans;
// }

