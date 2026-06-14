import java.util.*;

class Factorial
{
    public static int FindFactorial( int n)
    {
        int fact=1;

        for(int i=1;i<=n;i++)
        {
            fact=fact*i;
        }

        return fact;
    }
    public static void main(String[] args) 
    {
        System.out.println("Enter the number to find factorial : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int factorial = FindFactorial(n);
        System.out.print("Factorial of " + n +" is" + " = " + factorial);
                
        sc.close();
    }
}