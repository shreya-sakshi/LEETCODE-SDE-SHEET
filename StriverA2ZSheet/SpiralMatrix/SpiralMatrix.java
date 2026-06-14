package SpiralMatrix;

public class SpiralMatrix {

    public static void printSpiral(int matrix[][])
    {
        int startRow=0;
        int startCol=0;
        int endRow=matrix.length-1;
        int endCol=matrix[0].length-1;

        while(startRow<=endRow && startCol<=endCol)
        {
            //top
            for(int j=startCol;j<=endCol;j++)
            {
                System.out.println(matrix[startRow][j]+" ");
            }

            //Right
            for(int i=startRow+1;i<=endRow;i++)
            {
                System.out.println(matrix[i][endCol]+" ");
            }

            //bottom
            for(int j=endCol-1;j>=startCol;j--)
            {
                //whatever is printed in top will not be printed in bottom
                if(endRow == startRow)
                {
                    break;
                }
                System.out.println(matrix[endRow][j]+" ");
            }

           //left
            for(int i=endRow-1;i>=startRow+1;i--)
            {
                //whatever is printed in left will not be printed in right
                if(startCol == endCol)
                {
                    break;
                }
                System.out.println(matrix[i][startCol]+" ");
            }

            startCol++;
            startRow++;
            endCol--;
            endRow--;
        }

        System.out.println();

    }
    public static void main(String[] args) {
        int matrix[] [] ={{1,2,3,4},
                            {5,6,7,8},
                            {9,10,11,12},
                            {13,14,15,16}};

        printSpiral(matrix); 

        
    }
}
