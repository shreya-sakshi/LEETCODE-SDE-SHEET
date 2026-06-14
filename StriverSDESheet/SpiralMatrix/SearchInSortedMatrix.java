package SpiralMatrix;

public class SearchInSortedMatrix {
    public static boolean staircaseSearch(int matrix[][],int key) //O(n+m) Time Complexity
    {
        //Can be solved in both ways 
        // int row=0,col=matrix[0].length-1;

        //key<cell value LEFT  OR key>cell value BOTTOM
        //i= 0 to n-1, j=m-1 to 0

        // while(row < matrix.length && col>= 0)
        // {    
        //     if(matrix[row][col] == key)
        //     {
        //        System.out.println("Found key at ("+ row + "," + col +")");
        //        return true;
        //     }
        //     else if(key< matrix[row][col] )
        //     {
        //         col--;
        //     }
        //     else
        //     {
        //         row++;
        //     }
        // }
        
        int row=matrix.length-1,col=0;
        //key<cell value TOP  OR key>cell value RIGHT
        //i=n-1 to 0, j= 0 to m-1
        while(col < matrix[0].length && row>= 0)
        {    
            if(matrix[row][col] == key)
            {
               System.out.println("Found key at ("+ row + "," + col +")");
               return true;
            }
            else if(key< matrix[row][col] )
            {
                row--; //Top 
            }
            else
            {
                col++; //right
            }
        }
        System.out.println("Key not found!");
        return false;
        
    }
    public static void main(String args[])
    {
        int key=33;
        int matrix[] [] ={{10,20,30,40},
                            {15,25,35,45},
                            {27,29,37,48},
                            {32,33,39,50}};

        System.out.println(staircaseSearch(matrix,key));
    }
}
