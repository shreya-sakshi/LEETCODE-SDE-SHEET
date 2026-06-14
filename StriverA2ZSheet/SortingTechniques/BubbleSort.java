package SortingTechniques;

import java.util.Scanner;

public class BubbleSort {

    public static void bubblesort(int numbers[])
    {
        //Best time complexity O(N) if array is sorted i will breakout making the time complexity O(n)
             for(int i=(numbers.length)-1; i>=0; i--)
            {
                int didswap=0;
                 for(int j=0;j<=i-1;j++)
                 {
                    if(numbers[j] > numbers[j+1])
                    {    
                        int temp = numbers[j];
                        numbers[j]=numbers[j+1];
                        numbers[j+1]=temp;
                        didswap=1;
                    }
                 } 
                 if(didswap==0)
                 {
                    break;
                 } 
                 System.out.println("Runs");  

             }

            //  for(int turn=0; turn < (numbers.length)-1; turn++)
            //  {
            //      int didswap=0;
            //       for(int j=0;j<(numbers.length)-1-turn;j++)
            //       {
            //          if(numbers[j] > numbers[j+1])
            //          {    
            //              int temp = numbers[j];
            //              numbers[j]=numbers[j+1];
            //              numbers[j+1]=temp;
            //              didswap=1;
            //          }
            //       } 
            //       if(didswap==0)
            //       {
            //          break;
            //       } 
            //       System.out.println("Runs");  
 
            //   }
             
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

        bubblesort(numbers);
        
        System.out.print("The swapped numbers are : ");
        for(int i=0;i<numbers.length;i++)
        {
            System.out.print(numbers[i]+" ");
        }

                
        sc.close();
    }
}




