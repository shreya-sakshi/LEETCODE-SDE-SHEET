package PrefixSumPattern;
import java.util.Scanner;

public class SubarraySumEqualsk {
    public static int subarraySumEqualsk(int[] nums, int k) 
    {
        //Time complexity O(n^2)
        int totalsubaarray=0;

        for(int i =0; i<nums.length ; i++)
        {
            int start =i;

            for(int j =i;j<nums.length;j++)
            {
                int end=j;
                int currsum=0;

                for(int f=start;f<=end;f++)
                {
                    currsum += nums[f];  
                }
                if(currsum == k)
                {
                    totalsubaarray ++;
                }
            }
        }
        return totalsubaarray;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array");
        int n = sc.nextInt();
        System.out.println("Enter value of K :");
        int k =sc.nextInt();
        int nums[ ]=new int[n];

        for(int i = 0 ; i<nums.length ; i++)
        {
            System.out.println("Enter "+i+"index value: ");
            nums[i]=sc.nextInt();
        }
        for(int i = 0 ; i<nums.length ; i++)
        {
            System.out.print(nums[i]);
        }
        System.out.println();
        System.out.println(subarraySumEqualsk(nums,k));
                
        sc.close();
    }
}
