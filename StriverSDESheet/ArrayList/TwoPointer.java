package Arraylist;

import java.util.ArrayList;

public class TwoPointer {

    public static int twopointer(ArrayList<Integer> height)
    {
        //Time Complexity - O(n) d+n-d=n  Space Complexity - O(n)
        int maxWater = 0;
        int lp =0;
        int rp=height.size()-1;

        while(lp<rp)
        {
            //calculate max water
            int ht = Math.min(height.get(lp),height.get(rp));
            int width= rp-lp;
            int currWater = ht* width;
            maxWater = Math.max(maxWater,currWater);
            
            //update two pointer
            if(height.get(lp)<height.get(rp))
            {
                   lp++;
            }
            else{
                    rp--;
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

        System.out.println(twopointer(height));


    }
}
