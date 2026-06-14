package SpiralMatrix;

public class SumOfNumbersIn2ndRow {

    public static int sumOfNumbersIn2ndRow(int matrix[][])
    {
        int sum=0;
            for(int j=0;j<matrix[0].length;j++)
            {
                sum+=matrix[1][j];
            }
 
        return sum;
    }
    public static void main(String[] args)
    {
        int matrix[][]={ {1,4,9},{11,4,3},{2,2,3} };

        System.out.println("Sum of numbers in second row ("+sumOfNumbersIn2ndRow(matrix)+").");
    }
    
}

