import java.util.*;

public class EvenNumber 
{

    public static boolean isEven(int num)
    {
        if(num% 2 == 0)
        {
            return true; 
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num;
        
        System.out.println("Enter the Number : ");
        num = sc.nextInt();

        if(isEven(num)) 
        { 
            System.out.println("Number is even");
        }
        else
        {
            System.out.println("Number is odd");
        }

                
        sc.close();

    }


    
}
