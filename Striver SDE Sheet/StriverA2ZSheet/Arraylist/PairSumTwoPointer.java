package Arraylist;

import java.util.ArrayList;

public class PairSumTwoPointer {
    public static boolean pairsumtwopointer(ArrayList<Integer> list,int target)
    {
        //Two pointer approach TC-> O(n) d+n-d
        int lp=0;
        int rp=list.size()-1;
        while(lp!=rp)
        {
            //case 1
            if(list.get(lp)+list.get(rp) == target)
            {
                return true;
            }

            //case 2
            if(list.get(lp)+list.get(rp) < target)
            {
                lp++;
            }
            else
            {
                //case 3
                rp--;
            }

        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list =new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        int target =50;

        System.out.println(pairsumtwopointer(list,target));

    }
    
}
