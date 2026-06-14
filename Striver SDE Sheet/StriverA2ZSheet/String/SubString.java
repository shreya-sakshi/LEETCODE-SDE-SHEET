package String;



public class SubString 
{
    public static void main(String[] args) 
    {
        //compare
        String sentence="My name is Tony";
        String sentence1="TonyStark";

        String name = sentence.substring(11,sentence.length());
        String name1 = sentence1.substring(4);
        System.out.println(name);
        System.out.println(name1);

        //Strings are immutable

        //ParseInt Method of Integer class
        
        String str = "123";
        int number = Integer.parseInt(str);
        System.out.println(number);

        //ToString Method of String class

        int number2 = 123;
        String str2 = Integer.toString(number2);
        System.out.println(str2.length());


        
    }
    
}
