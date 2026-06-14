package PrefixSumPattern;

public class MaxSubArrayPrefixSum {
    public static void maxsubArrayPrefixSum(int numbers[])
    {
            int currSum =0;
            int maxSum = Integer.MIN_VALUE;
            int prefix[] = new int[numbers.length];

            //calcultae prefix sum
             
            prefix[0] = numbers[0];

            for(int i=1; i<prefix.length; i++)
            {
                prefix[i] = prefix[i-1] + numbers[i];
            }

            for(int i =0 ; i<prefix.length; i++) 
            {
                int start =i;
                 
                for(int j=i;j<prefix.length;j++)
                {
                    int end = j;
                    currSum = start ==0 ? prefix[end] : prefix[end]-prefix[start-1];
                    System.out.println(currSum);
                    if(maxSum < currSum)
                    {
                        maxSum = currSum;
                    }
            
                }
            }

            System.out.println("Max Sum = "+ maxSum);
    }

    public static void main(String[] args) 
    {
        int numbers[] ={2,4,6,8,10};
        maxsubArrayPrefixSum(numbers);
    }
    
}




