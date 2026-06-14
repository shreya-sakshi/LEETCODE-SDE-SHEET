package String;

public class MaxDepthParenthesis {
    
    // Method to find the maximum depth of nested parentheses in a given string
    public int maxDepth(String s) {
        int res = 0; // Variable to store the maximum depth encountered
        int cur = 0; // Variable to track the current depth of nested parentheses

        // Iterate over each character in the string
        for (char c : s.toCharArray()) {
            // If an opening parenthesis is found, increase the current depth
            if (c == '(') {
                cur += 1;
            } 
            // If a closing parenthesis is found, decrease the current depth
            else if (c == ')') {
                cur -= 1;
            }

            // Update the maximum depth encountered so far
            res = Math.max(res, cur);
        }

        // Return the maximum depth of nested parentheses
        return res;
    }

    public static void main(String[] args) {
        // Test case: given string with nested parentheses
        String s = "(1+(2*3)+((8)/4))+1";

        // Create an instance of MaxDepthParenthesis
        MaxDepthParenthesis solution = new MaxDepthParenthesis();

        // Print the result of maxDepth function
        System.out.println(solution.maxDepth(s)); // Output: 3
    }
}
