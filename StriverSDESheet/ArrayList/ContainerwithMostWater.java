package Arraylist;

import java.util.ArrayList;

public class ContainerwithMostWater {

    public static int storewater(ArrayList<Integer> height)
    {
        //Time Complexity - O(n^2)  Space Complexity - O(n)
        int maxWater = 0;
         for(int i=0;i<height.size();i++)
         {
            for(int j=i+1;j<height.size();j++)
            {
                int ht = Math.min(height.get(i),height.get(j));
                int width= j-i;
                int currWater = ht* width;
                maxWater = Math.max(maxWater,currWater);

            }
         }
         return maxWater;
    }
    public static void main(String args[])
    {
        ArrayList<Integer> height = new ArrayList<>();

        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println(storewater(height));


    }
    
}
