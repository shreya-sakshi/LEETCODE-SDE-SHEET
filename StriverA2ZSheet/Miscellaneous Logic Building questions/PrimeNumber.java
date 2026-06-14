

public class PrimeNumber 
{

    // public static boolean isPrime(int n)
    // {
    //     boolean isPrime = true;
    //     for(int i=2;i<=n-1;i++)
    //     {
    //         if(n%i==0)
    //         {
    //             isPrime = false;
    //             break;
    //         }
    //     }

    //     return isPrime;
    // }


    // public static boolean isPrime(int n)
    // {
    //     //corner case
    //     //2
    //     if(n==2)
    //     {
    //         return true;
    //     }
        
    //     for(int i=2;i<=n-1;i++)
    //     {
    //         if(n%i==0)
    //         {
    //             return false;
    //         }
    //     }

    //     return true;
    // }


    //optimized solution
    public static boolean isPrime(int n)
    {
        //corner case
        //2
        if(n==2)
        {
            return true;
        }
        
        for(int i=2;i<=Math.sqrt(n);i++)
        {
            if(n%i==0)
            {
                return false;
            }
        }

        return true;
    }

    public static void PrimesInRange(int n)
    {  
        for(int i=2 ;i<=n; i++)
        {
               if(isPrime(i))
               {
                   System.out.print(i + " ");
               }
        }
        System.out.println();
    }  

    public static void main(String[] args) 
    {
        PrimesInRange(20); //2 to 20
        
    }
    
}
