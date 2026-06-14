package HashMapandHashSet;
import java.util.*;

public class ContainsDuplicate {


    //Brute force approach Time Complexity O(n^2)
    // public static boolean containsDuplicate(int[] num)
    // {
    //     for(int i=0 ; i<num.length-1; i++)
    //     {
    //         for(int j=i+1 ; j<num.length ; j++)
    //         {
    //                if(num[i]==num[j])
    //                {
    //                   return true;
    //                }
    //         }
    //     }
    //     return false;
    // }

    public static boolean containsDuplicate(int[] num)
    {

        HashSet<Integer> set = new HashSet<>();
        for(int i=0 ; i<num.length; i++)
        {
            if(set.contains(num[i]))
            {
                 return true; 
            }
            else{
                set.add(num[i]);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array : ");
        int n = sc.nextInt();

        int num[] = new int [n];

        for(int i=0;i<num.length;i++)
        {    
            System.out.print("Enter the "+i+" index number: ");
            num[i]= sc.nextInt();
        }

        System.out.println(containsDuplicate(num));         
        sc.close();
    }
    
}
