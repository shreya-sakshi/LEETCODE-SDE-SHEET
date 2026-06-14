package PrefixSumPattern;

public class MaxSubarrayKadanes {
    public static void kadanes(int numbers[])
    {
            int currSum =0;
            int maxSum = Integer.MIN_VALUE;
            for(int i=0 ; i<numbers.length; i++) 
            {
                // currSum = currSum + numbers[i];

                // if(currSum < 0)
                // {
                //     currSum =0;
                // }

                // maxSum = Math.max(currSum,maxSum);

                currSum = currSum + numbers[i];

                // Update maxSum at every step
                maxSum = Math.max(currSum, maxSum);

                // Reset currSum to 0 only if it goes below 0   // Time complexity O(n)
                if (currSum < 0) 
                {
                    currSum = 0;
                }
            }

            System.out.println("Our Max subarray Sum is = "+ maxSum);
    }

    public static void main(String[] args) 
    {
        int numbers[] ={-2,-3,-1,-4};
        kadanes(numbers);
    }
    
}




