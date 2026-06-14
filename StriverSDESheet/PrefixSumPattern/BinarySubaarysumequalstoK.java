package PrefixSumPattern;
import java.util.*;

public class BinarySubaarysumequalstoK {

    public int numsubaaraysumequalk(List<Integer> nums , int goal)
    {
        return atmost(nums,goal)-atmost(nums,goal-1);
    }

    private int atmost(List<Integer> nums , int goal)
    {
          if(goal < 0 ) return 0;

          int left =0,right =0 , count =0 , sum =0;

          while(right < nums.size())
          {
                 sum += nums.get(right);

                 while(sum > goal)
                 {
                    sum -= nums.get(left);
                    left++;
                 }

                 count += (right-left+1);
                 right++;

          }
          return count;
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println(("Enter size of array :"));
            int n = sc.nextInt();

            List<Integer> nums = new ArrayList<>();

            System.out.println("Enter " + n + " binary elements (0 or 1):");
            for(int i=0;i<n;i++)
            {
                nums.add(sc.nextInt());
            }

            System.out.println("Enter the goal sum :");
            int goal = sc.nextInt();

            BinarySubaarysumequalstoK sol = new BinarySubaarysumequalstoK();
            int result = sol.numsubaaraysumequalk(nums,goal);

            System.out.println("Number of subarrays with sum " + goal + " is: " + result);
        }

    }
    
}
