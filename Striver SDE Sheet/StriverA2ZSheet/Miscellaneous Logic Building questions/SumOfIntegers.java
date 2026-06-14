import java.util.*;

public class SumOfIntegers 
{

    public static int SumOfInteger(int digits)
    {
        int sumofdigits =0;

        while(digits !=0)
        { 
            int lastDigit = digits % 10 ;
            sumofdigits += lastDigit;
            digits /= 10;
        }

        return sumofdigits;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the integer to find sum of all digits : ");
        int digits = sc.nextInt();
        System.out.println("Sum of all the integers in "+digits+ " is = " + SumOfInteger(digits) );  
                
        sc.close();
    }
    
}
