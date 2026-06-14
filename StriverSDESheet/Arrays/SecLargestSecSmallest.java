package Arrays;

class SecLargestSecSmallest {

    public  static int getSecondLargest(int[] arr) 
    {
        // Code Here
        int largest = arr[0];
        int seclargest =-1;
        
        for(int i=1;i<arr.length;i++ )
        {
            if(arr[i]>largest)
            {
                seclargest=largest;
                largest = arr[i];
            }
            else if( arr[i] != largest && arr[i] > seclargest)
            {
                seclargest = arr[i]; 
            }
        }
        System.out.println("Largest = "+largest);
        
        return(seclargest);
    }

    public static int getSecondSmallest(int[] arr) {
        // Code Here
        int smallest = arr[0];
        int secsmallest = Integer.MAX_VALUE;
        
        for(int i=1;i<arr.length;i++ )
        {
            if(arr[i]<smallest)
            {
                secsmallest=smallest;
                smallest = arr[i];
            }
            else if( arr[i] != smallest && arr[i] < secsmallest)
            {
                secsmallest = arr[i]; 
            }
        }

        System.out.println("Smallest = "+smallest);
        
        return(secsmallest);
    }
    public static void main(String[] args) {
        int arr[] = {12,35,1,10,34,1};
        int getSecondLargest = getSecondLargest(arr);
        int getSecondSmallest = getSecondSmallest(arr);

        System.out.println("Second Largest = "+getSecondLargest+" Second Smallest = "+getSecondSmallest);
    }
}