package Arrays;
import java.util.*;

public class ArrayOfStrings 
{
    public static void main(String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("Input the size of array : ");
        int size = sc.nextInt();

        String array[] = new String[size];

        int totalLength=0;

        for(int i=0; i<size; i++)
        {
            System.out.println("Input"+ " "+ i +"th"+ " " + "String Element");
            array[i] = sc.next();
            totalLength += array[i].length();
        }
        System.out.println(totalLength);
    }
    
}
