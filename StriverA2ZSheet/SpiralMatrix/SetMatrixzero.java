package SpiralMatrix;
import java.util.*;

class SetMatrixzero {
    public static void setZeroes(int[][] matrix) {
        // int row = matrix.length; //matrix[0][j]
        // int col = matrix[0].length;//matrix[i][0]
        
        //to set 1st row and colm to zero and create col0 to avoid overlapping of first elemen
        int col0 =1;
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                  if(matrix[i][j]==0) 
                  {
                     matrix[i][0]=0; // to set(0,0) row to zero
                     

                     // to set(0,0) column  to zero but by checking additional field col0 to avoid overlapping of columns
                     if(j!=0)
                     {
                        matrix[0][j]=0;
                     }
                     else
                     {
                        col0=0;
                     }
                  } 
            }
        }

//to set everything from 1,1 column to end to 0 if it is not zero without touching oth row 0th column
        for(int i=1;i<matrix.length;i++)
        {
            for(int j=1;j<matrix[0].length;j++)
            {
                  if(matrix[i][j]!=0) 
                  {
                     if(matrix[i][0]==0 || matrix[0][j]==0)
                     {
                        matrix[i][j]=0;
                     }
                  } 
            }
        }

//if matrix[0][0] is 0 set column to zero 
        if(matrix[0][0]==0)
        {
            for(int j=0 ; j<matrix[0].length;j++)
            {
                matrix[0][j]=0;
            }
        }
        //if col is 0 set row to zero 
        if(col0==0)
        {
            for(int i=0;i<matrix.length;i++)
            {
                matrix[i][0]=0;
            }
        }
        
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the row size of matrix :");
        int n = sc.nextInt();
        System.out.println("Enter the column  size of matrix :");
        int m = sc.nextInt();

        int matrix[][] = new int[n][m];
        System.out.println("Row size:"+matrix.length);
        System.out.println("Column size:"+matrix[0].length);

        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                System.out.println("Enter ("+ i +"," + j +") value.");
                 matrix[i][j] = sc.nextInt();
            }
        }
        setZeroes(matrix);

        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                System.out.print(matrix[i][j] + " ") ;
            }
            System.out.println();
        }
                
        sc.close();
    }
}
