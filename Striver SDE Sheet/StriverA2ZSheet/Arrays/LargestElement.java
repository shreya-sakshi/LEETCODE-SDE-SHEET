package Arrays;

class LargestElement {
     
    public static int largest(int[] arr) {
        // code here
        int largestElement = Integer.MIN_VALUE;
        
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i]>largestElement)
            {
                largestElement=arr[i];
            }
        }
        
        return largestElement;
        
        
    }
    
    public static void main (String args[])
    {
        int arr[]={1, 8, 7, 56, 90};
        
        System.out.println(" Largest Element is = "+largest(arr));
    }
}

