package Arrays;

import java.util.*;
public class TwoSum {
    public int[] gettwoSum(int[] nums, int target) {
        //TC-> O (N)  SC -> O(N)
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i =0 ; i<nums.length ; i++)
        {
            int complement = target - nums[i];
            if(map.containsKey(complement))
            {
                return new int[] { map.get(complement),i};
            }
            map.put(nums[i],i);
        }

        return new int[] {};
    }
    public static void main(String[] args) {
        int nums[] = {2,7,11,15};
        int target = 9 ;
        TwoSum to = new TwoSum();
        int[] result = to.gettwoSum(nums,target);

        System.out.println(result[0]+ " " + result[1]);

    }
}
