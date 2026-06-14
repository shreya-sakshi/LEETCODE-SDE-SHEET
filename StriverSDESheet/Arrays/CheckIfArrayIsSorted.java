package Arrays;

public class CheckIfArrayIsSorted {

   public static boolean checkifarrayisorted(int[] arr , int n )
   {
        for(int i=1;i<n;i++)
        {
            if(arr[i] >= arr[i-1])
            {

            }
            else
            {
                return false;
            }
        }

        return true;
   }

    public static void main(String[] args) {
        int arr[] ={1,5,2,6,3,4};
        int n = arr.length;

        System.out.println("Array is sorted :" +checkifarrayisorted(arr,n));

    }
    
}
