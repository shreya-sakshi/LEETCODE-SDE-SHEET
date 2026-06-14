package PrefixSumPattern;

public class MaxSubarray {
    public static void maxsubArraySum(int numbers[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        
        int maxStart = -1, maxEnd = -1; // To track indices of max sum subarray
        int minStart = -1, minEnd = -1; // To track indices of min sum subarray

        for (int i = 0; i < numbers.length; i++) {
            int start = i;

            for (int j = i; j < numbers.length; j++) {
                int end = j;
                currSum = 0;

                // Calculate subarray sum
                for (int k = start; k <= end; k++) 
                {
                    currSum = currSum + numbers[k];
                }
                System.out.println("CurrSum for subarray (" + start + "," + end + ") is: " + currSum);

                // Update maxSum and max subarray indices
                if (maxSum < currSum) {
                    maxSum = currSum;
                    maxStart = start;
                    maxEnd = end;
                }

                // Update minSum and min subarray  indices
                if (minSum > currSum) {
                    minSum = currSum;
                    minStart = start;
                    minEnd = end;
                }
            }
        }

        //Print max subarray
        System.out.println("Max Sum = " + maxSum + " for subarray: ");
        
        //Print max subarray
        for (int i = maxStart; i <= maxEnd; i++) 
        {
            System.out.print(numbers[i] + " ");
        }

        System.out.println();
        
        //Print min subarray
        System.out.println("Min Sum = " + minSum + " for subarray: ");


        for (int i = minStart; i <= minEnd; i++) 
        {
            System.out.print(numbers[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int numbers[] = {2, 4, 6, 8, 10};
        maxsubArraySum(numbers);
    }
}
