package Arrays;

public class SecondLarget {

    //Brute-NlogN +N
    //Better O(2N)
    //Optimal O(N)

    public static int secondlargest(int[] arr , int n)
    {
        int largest=arr[0] , secondlargest=Integer.MIN_VALUE;

       for(int i=1;i<n;i++)
       {
           if(arr[i] > largest)
           {
              secondlargest = largest;
              largest = arr[i];
           }
           else if(arr[i]< largest && arr[i] > secondlargest)
           {
                secondlargest= arr[i];
           }
       }

       return secondlargest == Integer.MIN_VALUE ? -1 : secondlargest;
    }

    public static int secondsmallest(int[] arr, int n)
    {
        int smallest=arr[0] , secondsmallest=Integer.MAX_VALUE;

       for(int i=1;i<n;i++)
       {
           if(arr[i] < smallest )
           {
              secondsmallest = smallest;
              smallest = arr[i];
           }
           else if(arr[i] != smallest && arr[i] < secondsmallest)
           {
               secondsmallest= arr[i];
           }
       }

       return secondsmallest == Integer.MAX_VALUE ? -1 : secondsmallest;
    }

    public static int[] getsecondsmallestandsecondlargest(int n , int[] arr)
    {
         int secondlargest = secondlargest(arr , n);
         int secondsmallest = secondsmallest(arr, n);

         return new int[]{secondlargest,secondsmallest};
    }
    public static void main(String[] args) {
        int arr[]={1,2,4,7,7,5};
        int n = arr.length;
        
        int result[] = getsecondsmallestandsecondlargest(n,arr);
        System.out.println("Second Largest:"+ result[0]);
        System.out.println("Second Smallest:"+ result[1]);
    }
    
}
