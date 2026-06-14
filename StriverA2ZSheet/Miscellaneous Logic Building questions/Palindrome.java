import java.util.*;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number :");
        int number = sc.nextInt();

        if(isPalindrome(number))
        {
            System.out.println("The number " +number + " is Palindrome");
        }
        else
        {
            System.out.println("The number " +number + " is not a Palindrome");

        }

                
        sc.close();
    }

    public static boolean isPalindrome(int number)
    {
        int palindrome = number;
        int reverse =0;

        while(palindrome != 0)
        {
            int remainder = palindrome % 10 ;
            reverse = reverse * 10 + remainder;
            palindrome = palindrome /10;

        }

        if(number == reverse)
        {
            return true;
        }

        return false;

    }
    
}
