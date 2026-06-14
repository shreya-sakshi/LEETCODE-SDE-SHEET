package SortingTechniques;

import java.util.Scanner;

public class InsertionSort {


    public static void insertionsort(int numbers[])
    {
        //  for(int i=0; i<=numbers.length-1;i++)
        //  {
        //      int curr=numbers[i];

        //      int prev =i-1;
             
        //      //correct position to insert // worst cae O(Nsquare)
        //      while(prev >=0 && numbers[prev] > curr)
        //      {
        //          numbers[prev+1]=numbers[prev];
        //          prev --;
        //      }

        //      //insertion
        //      numbers[prev+1]=curr;
        //  }


        for(int i=0; i<=numbers.length-1;i++)
        {
            int j=i;
            
            //correct position to insert
            while(j>0 && numbers[j-1] > numbers[j])
            {
                int temp= numbers[j-1];
                numbers[j-1]=numbers[j];
                numbers[j]=temp;
                j --;
            }
   
        }
    }

    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter size of array : ");
        int n = sc.nextInt();

        int numbers[]=new int[n];

        for(int i=0;i<numbers.length;i++)
        {    
            System.out.print("Enter the "+i+" index number: ");
            numbers[i]= sc.nextInt();
        }

        insertionsort(numbers);
        
        System.out.print("The swapped numbers are : ");
        for(int i=0;i<numbers.length;i++)
        {
            System.out.print(numbers[i]+" ");
        }

                
        sc.close();
    }
}


