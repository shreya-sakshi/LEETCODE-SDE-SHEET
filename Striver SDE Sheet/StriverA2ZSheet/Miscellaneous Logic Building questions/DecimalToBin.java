

public class DecimalToBin 
{

    public static void DecTobin(int deciNum)
    {
        int mynum = deciNum;
        int binUm =0;
        int pow=0;

        while(deciNum > 0)
        {
            int rem=deciNum % 2;
            binUm = binUm + (rem * (int)Math.pow(10,pow));
            pow++;
            deciNum = deciNum/2;
        }

        System.out.println("Binary of " + mynum + " = " + binUm);

    }

    public static void main(String[] args) {
        DecTobin(15);
        DecTobin(11);
    }
    
}
