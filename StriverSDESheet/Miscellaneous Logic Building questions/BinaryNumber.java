


public class BinaryNumber 
{

    public static void binToDec(int binUm)
    {
        int mynum = binUm;
        int decNum =0;
        int pow=0;

        while(binUm > 0)
        {
            int lastDigit=binUm %10;
            decNum = decNum + (lastDigit * (int)Math.pow(2,pow));

            pow++;
            binUm = binUm/10;
        }

        System.out.println("decimal of " + mynum + " = " + decNum);

    }

    public static void main(String[] args) {
      binToDec(1010);
    }
    
}
