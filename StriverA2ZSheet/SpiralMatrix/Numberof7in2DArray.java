package SpiralMatrix;

public class Numberof7in2DArray {

    public static int countnoof7In2dArray(int matrix[][])
    {
        int countof7=0;
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]==7)
                {
                    countof7++;
                }
            }
        }
 
        return countof7;
    }
    public static void main(String[] args)
    {
        int matrix[][]={{4,7,8},{8,8,7}};

        System.out.println("Count of 7 in 2D array is ("+countnoof7In2dArray(matrix)+").");
    }
    
}
