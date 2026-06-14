package String;  // Declares the package name
import java.util.*;  // Imports utility classes including Stack

public class RemoveOuterMostParenthesis {  // Defines the class

    // Method to remove outermost parentheses from the given string

    public String removeoutermostparenthesis(String str) 
    {
        Stack<Character> st = new Stack<>();  // Stack to keep track of open parentheses
        StringBuilder sb = new StringBuilder();  // StringBuilder to store the result

        // Loop through each character in the input string
        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);  // Extract the current character

            if (ch == '(') {  // If the character is an opening parenthesis

                if (st.size() > 0) // If the stack is not empty, it's not an outer parenthesis
                {  
                    sb.append(ch);  // Append it to the result
                }

                st.push(ch);  // Push the '(' onto the stack

            } 
            else 
            {  // If the character is a closing parenthesis ')'

                st.pop();  // Pop an opening parenthesis from the stack (pairing it)

                if (st.size() > 0) // If the stack is not empty, it's not an outer parenthesis
                {  
                    sb.append(ch);  // Append it to the result
                }
            }
        }

        return sb.toString();  // Return the modified string without outer parentheses
    }

    public static void main(String[] args) 
    {
        String str = "(()())(())(()(()))"; 

        RemoveOuterMostParenthesis solution = new RemoveOuterMostParenthesis();  // Create an instance of the class
        System.out.print(solution.removeoutermostparenthesis(str));  // Call the method and print the result
    }
}
