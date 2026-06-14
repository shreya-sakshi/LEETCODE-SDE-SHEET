// import java.util.*;

// public class ReverseCopyingAnArray
// {
//     public static void main(String args[])
//     {
//          int Array1[] = {8,6,10,9,2,15,7,13,14,11};
//          int Array2[] = new int[10];

//         Array2[0]= Array1[Array1.length-1];

//          for (int i=1;i<Array1.length;i++)
//          {
//                Array2[i]=Array1[Array1.length-1-i];
//          }

//          for (int x : Array2) 
//          {
//             System.out.print(x+ ",");
//             System.out.print(" ");
//          }
//     }
// }

package Arrays;


public class ReverseCopyingAnArray
{
    public static void main(String args[])
    {
         int Array1[] = {8,6,10,9,2,15,7,13,14,11};
         int Array2[] = new int[10];

         for(int i=Array1.length-1,j=0;i>=0;i--,j++)
         {
               Array2[j]=Array1[i];
         }

         for (int x : Array2) 
         {
            System.out.print(x+ ",");
            System.out.print(" ");
         }
    }
}