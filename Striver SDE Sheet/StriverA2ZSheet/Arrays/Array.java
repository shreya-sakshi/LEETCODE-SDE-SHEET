package Arrays;
import java.util.*;

public class Array{
    public static void main(String[] args)
    {

        int marks[] = new int[100];

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter firt number :");
        marks[0] = sc.nextInt();
        System.out.println("Enter second number :");
        marks[1] = sc.nextInt();
        System.out.println("Enter third number :");
        marks[2] = sc.nextInt();


        System.out.println("physics : "+ marks[0]);
        System.out.println("chemistry : "+ marks[1]);
        System.out.println("maths1 : "+ marks[2]);

        marks[2]=100;
        System.out.println("maths2 : "+ marks[2]);

                
        sc.close();
        
    }
}

