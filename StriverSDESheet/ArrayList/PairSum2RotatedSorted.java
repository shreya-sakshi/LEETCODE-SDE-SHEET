package Arraylist;

import java.util.ArrayList;

public class PairSum2RotatedSorted {
        public static boolean pairsum2ModularAritmeticTwoPointer(ArrayList<Integer> list,int target)
    {
        //Two pointer Modular Arithmetic approach TC-> O(n) d+n-d even if they are rotated as rotation will stop at lp=rp
        int bp=-1;
        int n=list.size();
        //Find pivot that is breaking point
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i) > list.get(i+1))
            {
                bp=i;
                break;
            }
        }
        
        //assign right pointer to i that is bp(largest value) assign lp to bp+1(smallest value)
        int lp = bp+1;
        int rp=bp;

        while(lp!=rp)
        {
            //case 1
            if(list.get(lp)+list.get(rp) == target)
            {
                return true;
            }

            //case 2 Modular arithmetic
            if(list.get(lp)+list.get(rp) < target)
            {
                lp=(lp+1)%n;
            }
            else
            {
                //case 3
                rp=(n+rp-1)%n;
            }

        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list =new ArrayList<>();

        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target =16;

        System.out.println(pairsum2ModularAritmeticTwoPointer(list,target));

    }
    
}
