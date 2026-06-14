

public class FuncOverrloadusingDataType
{
    public static int sum(int a,int b)
    {
        return a+b;
    }

    public static float sum(float a, float b)
    {
        return a+b;
    }


    public static void main(String[] args) 
    {
        System.out.println(sum(4,6));
        System.out.println(sum(4.5f,8.5f));   
    }
    
}
