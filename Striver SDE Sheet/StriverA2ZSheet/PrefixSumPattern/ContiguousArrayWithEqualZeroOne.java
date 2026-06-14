package PrefixSumPattern;

import java.util.*;

class ContiguousArrayWithEqualZeroOne 
{
    public static int findMaxLength(int[] nums) 
        {
            int zero=0,one=0;
            int res = 0;
    
            HashMap<Integer,Integer> diffIndex = new HashMap<>();
    
            for(int i =0; i <nums.length;i++)
            {
                if(nums[i]==0)
                {
                    zero++;
                }
                else
                {
                    one++;
                }
    
                int diff= one - zero;
    
                if(diff == 0)
                {
                    res = i+1;
                }
                else if(diffIndex.containsKey(diff))
                {
                    res=Math.max(res, i-diffIndex.get(diff));
                }
                else
                {
                    diffIndex.put(diff,i);
                }
            }
    
            return res;
            
        }
    
        public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter size of array");
            int n = sc.nextInt();
            int nums[ ]=new int[n];
    
            for(int i = 0 ; i<nums.length ; i++)
            {
                System.out.println("Enter "+i+"index: ");
                nums[i]=sc.nextInt();
            }
            System.out.println(findMaxLength(nums));
                    
        sc.close();
    }

}
