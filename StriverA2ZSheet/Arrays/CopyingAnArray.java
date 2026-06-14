package Arrays;


public class CopyingAnArray
{
    public static void main(String args[])
    {
         int Array1[] = {8,6,10,9,2,15,7,13,14,11};
         int Array2[] = new int[10];

         for (int i=0;i<Array1.length;i++)
         {
               Array2[i]=Array1[i];
         }

         for (int x : Array2) 
         {
            System.out.print(x+ ",");
            System.out.print(" ");
         }
    }
}