package PrefixSumPattern;

import java.util.HashMap;
import java.util.Scanner;

public class LargestsubaaraysumequalsK {
    public static int largestsubarraysumequalsK(int[] nums, int k) 
    {
        //TC->(O(Nlogn))N for traveral and logn for hashmap that we are using , SC->O(N)
        HashMap<Integer,Integer> mpp = new HashMap<>();
        int maxi=0;
        int prefixsum=0;

        for(int i=0;i<nums.length;i++)
        {
            prefixsum+=nums[i];

            if(prefixsum == 0)
            {
                maxi=i+1;
            }
            else{
                if(mpp.get(prefixsum)!=null)
                {
                    maxi=Math.max(maxi,i-mpp.get(prefixsum));
                }
                else{
                    mpp.put(prefixsum,i);
                }
            }
        }

        return maxi;
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
            System.out.println("Enter "+i+" index value: ");
            nums[i]=sc.nextInt();
        }
        for(int i = 0 ; i<nums.length ; i++)
        {
            System.out.print(nums[i]+",");
        }
        System.out.println();
        System.out.println(largestsubarraysumequalsK(nums,k));
                
        sc.close();
    }
}
