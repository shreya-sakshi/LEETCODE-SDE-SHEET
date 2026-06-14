package String;



public class IsPalindrome {

// Function to check if a given string is a palindrome (ignoring non-alphanumeric characters)
public boolean isPalindrome(String s) {
    int l = 0, r = s.length() - 1; // Two pointers: one from the left, one from the right

    while (l < r) {
        // Move left pointer forward if it's not an alphanumeric character
        while (l < r && !alphaNum(s.charAt(l))) {
            l += 1;
        }
        // Move right pointer backward if it's not an alphanumeric character
        while (r > l && !alphaNum(s.charAt(r))) {
            r -= 1;
        }
        // Compare characters (ignoring case)
        if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
            return false; // If mismatch found, it's not a palindrome
        }
        l += 1;
        r -= 1;
    }
    return true; // If all characters matched, it's a palindrome
}

// Helper function to check if a character is alphanumeric (letter or digit)
private boolean alphaNum(char c) {
    return (c >= 'A' && c <= 'Z') ||  // Uppercase letters
           (c >= 'a' && c <= 'z') ||  // Lowercase letters
           (c >= '0' && c <= '9');    // Digits
}

// Main function to test the isPalindrome method
public static void main(String[] args) {
    IsPalindrome solution = new IsPalindrome();
    System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama")); // true
    System.out.println(solution.isPalindrome("race a car")); // false
    System.out.println(solution.isPalindrome(" ")); // true (empty or only spaces is a palindrome)
}
    
}
