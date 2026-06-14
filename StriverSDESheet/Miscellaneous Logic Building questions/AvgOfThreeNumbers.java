import java.util.Scanner;

public class AvgOfThreeNumbers {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input the first number : ");
        double x = sc.nextDouble();
        System.out.print("Input the second number : ");
        double y = sc.nextDouble();
        System.out.print("Input the third number : ");
        double z = sc.nextDouble();

        System.out.print("The average value is " + AvgOfThreeNum(x,y,z)+ "\n");
                
        sc.close();

    }

    
    public static double AvgOfThreeNum(double x, double y , double z)
    {
         return(x+y+z)/3;
    }
}
