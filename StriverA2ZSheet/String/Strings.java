package String;

public class Strings 
{
    public static void main(String[] args) 
    {
        // Scanner sc =new Scanner(System.in);
        // String name=sc.nextLine();

        // System.out.println("Your name is : " +name);

        //concatenation
        String firtName="Tony";
        String lastName="Stark";
        String fullName=firtName +" " +lastName;

        System.out.println(fullName);

        //length of string

        System.out.println(fullName.length());

        //charAt
        for(int i=0; i<fullName.length(); i++)
        {
            System.out.println(fullName.charAt(i));
        }


    }
    
}
