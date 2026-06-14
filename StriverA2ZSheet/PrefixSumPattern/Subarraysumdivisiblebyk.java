package PrefixSumPattern;

import java.util.Scanner;

public class Subarraysumdivisiblebyk {
    
     public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of array");
        int n = sc.nextInt();

        System.out.println("Enter value of K :");
        // int k =sc.nextInt();

        int nums[ ]=new int[n];

        for(int i = 0 ; i<nums.length ; i++)
        {
            System.out.println("Enter "+i+" index value: ");
            nums[i]=sc.nextInt();
        }
        for(int i = 0 ; i<nums.length ; i++)
        {
            System.out.print(nums[i]+",");
        }
        System.out.println();
        
        sc.close();
        // System.out.println(subarraysumdivisiblebyK(nums,k));
    }
    
}
