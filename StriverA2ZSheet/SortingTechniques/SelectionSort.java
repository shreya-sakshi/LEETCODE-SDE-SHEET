package SortingTechniques;

import java.util.Scanner;

public class SelectionSort {

    public static void selectionsort(int numbers[])
    {

        // select minimum and swap with ith index
        //Best worst and avg time complexity is O(Nsqaure)
             for(int i=0; i<=(numbers.length)-2;i++)  // go till n-2 as only till n-2 the data is sorted
             {
                int mini=i;
                 for(int j=i;j<=(numbers.length)-1;j++)
                 {
                    if(numbers[j] < numbers[mini]) // find minimum value
                    {
                         mini =j;
                    }
                 }
                 
                 //perform swapping
                 int temp = numbers[mini];
                 numbers[mini]=numbers[i];
                 numbers[i]=temp;

             }


                // for(int i=0; i<(numbers.length)-1;i++)
                // {
                //    int miniPos=i;
                //     for(int j=i+1;j<(numbers.length)-1;j++)
                //     {
                //        if(numbers[j] < numbers[miniPos])
                //        {
                //         miniPos =j;
                //        }
                //     }
   
                //     int temp = numbers[miniPos];
                //     numbers[miniPos]=numbers[i];
                //     numbers[i]=temp;
   
                // }

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

        selectionsort(numbers);
        
        System.out.print("The swapped numbers are : ");
        for(int i=0;i<numbers.length;i++)
        {
            System.out.print(numbers[i]+" ");
        }

                
        sc.close();
    }
}



