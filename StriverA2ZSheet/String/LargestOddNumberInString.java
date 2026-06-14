package String; // Package declaration

import java.util.Scanner; // Import Scanner class for user input

class LargestOddNumberInString {
    // Method to find the largest odd-numbered substring from the given string
    public String largestOddNumber(String num) 
    {
        int n = num.length(); // Get the length of the input string

        // Loop through the string from the last character to the first
        for (int i = n - 1; i >= 0; i--) 
        {
            // Get the integer value of the character at index i -'0' is typically used when converting a character digit to its integer equivalent
            
            if (Character.getNumericValue(num.charAt(i)-'0') % 2 != 0) // Check if it's an odd number
            { 
                return num.substring(0, i + 1); // Return the substring from the start to the current odd digit
            }
        }
        
        return ""; // Return an empty string if no odd number is found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Create Scanner object for user input
        System.out.print("Enter the String: "); // Prompt user for input
        String num = sc.nextLine(); // Read the input string
        LargestOddNumberInString solution = new LargestOddNumberInString(); // Create an instance of the class
        System.out.print("Largest Odd Number: " + solution.largestOddNumber(num)); // Call the method and print result
        sc.close(); // Close scanner to prevent resource leak
    }
}
