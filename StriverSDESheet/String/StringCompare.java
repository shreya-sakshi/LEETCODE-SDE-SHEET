package String;

public class StringCompare 
{
    public static void main(String[] args) 
    {
        //compare
        String name1="aahello";
        String name2="aabello";


        // if(name1.compareTo(name2) == 0)
        // {
        //    System.out.println("Strings are equal");
        // }
        // else
        // {
        //     System.out.println("Strings are not equal");
        // }

        // if(name1==name2)
        // {
        //    System.out.println("Strings are equal");
        // }
        // else
        // {
        //     System.out.println("Strings are not equal");
        // }

        if(new String("Tony") == new String("Tony"))
        {
           System.out.println("Strings are equal");
        }
        else
        {
            System.out.println("Strings are not equal");
        }
        
    }
    
}
