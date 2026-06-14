package Arrays;
import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        //TC-> Sorting take O(nlogn) Two pointer O(N) - O(N^2) SC->(1)
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);

        for(int i=0;i<n;i++)
        {
            if(i>0 && nums[i] == nums[i-1]) continue;

            int j = i+1;
            int k = n-1;

            while(j<k)
            {
                int sum = nums[i] + nums[j] + nums[k];

                if(sum <0)
                {
                    j++;
                }
                else if(sum >0 )
                {
                    k--;
                }
                else
                {
                    ans.add(Arrays.asList(nums[i] , nums[j] , nums[k]));

                    j++;
                    k--;

                    while(j<k && nums[j] == nums[j-1]) j++;
                    while(j<k && nums[k] == nums[k+1]) k--;
                }
            }
        }
        return ans;
    }
}
