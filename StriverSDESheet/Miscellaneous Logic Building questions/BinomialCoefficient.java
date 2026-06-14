import java.util.*;

class BinomialCoefficient
{

    public static int BinomialCoeff(int n,int r)
    {
          int n_fact = FindFactorial(n);
          int r_fact = FindFactorial(r);
          int n_rfact = FindFactorial(n-r);

          int binomCoeff = n_fact / (r_fact * n_rfact);

          return binomCoeff;
    }

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
        System.out.println("Enter the number to find factorial and BinomialCoefficient : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int factorial = FindFactorial(n);
        int factorialr = FindFactorial(r);
        int factorialnminusr = FindFactorial(n-r);
        int BinomCoeff = BinomialCoeff(n,r);
        System.out.println("Factorial of " + n +" is" + " = " + factorial);
        System.out.println("Factorial of " + r +" is" + " = " + factorialr);
        System.out.println("Factorial of " + n + "-" + r +" is" + " = " + factorialnminusr);
        System.out.println("Binomial Coefficient of " + n +"C"+ r +" is" + " = " + BinomCoeff);
           
        sc.close();
    }
}
