package BinarySearch;

// Class to find the Nth root of an integer
public class FindNthRootOfanInteger {

    // Helper function to compare mid^n with m
    // Returns:
    // 1 if mid^n == m
    // 0 if mid^n < m
    // 2 if mid^n > m
    public int func(int mid, int n, int m) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= mid;
            // If at any point ans exceeds m, return 2
            if (ans > m) {
                return 2;
            }
        }
        if (ans == m) {
            return 1;
        }
        return 0; // ans < m
    }

    // Function to find the Nth root of m using Binary Search
    public int Nthroot(int n, int m) {
        int low = 1;
        int high = m;

        // Binary search to find the Nth root
        while (low <= high) {
            int mid = (low + high) / 2;

            int midN = func(mid, n, m); // Compare mid^n with m

            if (midN == 1) {
                return mid; // Found the Nth root
            } else if (midN == 0) {
                low = mid + 1; // Move to the right half
            } else {
                high = mid - 1; // Move to the left half
            }
        }

        return -1; // If no integer Nth root exists
    }

    public static void main(String[] args) {
        int n = 3, m = 27; // Input values: find 3rd root of 27

        // Create an instance of the class
        FindNthRootOfanInteger solution = new FindNthRootOfanInteger();
        
        // Call the Nthroot method
        long ans = solution.Nthroot(n, m);

        // Print the result
        System.out.println("Nth root of the number is: " + ans);
    }
}
