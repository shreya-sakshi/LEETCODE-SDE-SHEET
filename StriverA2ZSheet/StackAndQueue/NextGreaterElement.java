package StackAndQueue;

import java.util.*;

public  class NextGreaterElement {
    public static int[] nextGreaterElements(int[] nums) {
        //TC-> O(4N) SC -> O(2N)
        int n= nums.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=2*n-1 ; i>=0 ; i--)
        {
            while(!st.empty() && st.peek() <= nums[i % n])
            {
                st.pop();
            }
            if(i<n)
            {
                if(st.empty())
                {
                  nge[i] = -1 ;
                }
                else
                {
                    nge[i]=st.peek();
                }
            }
            st.push(nums[i % n]);
       }
       return nge;
    }
    public static void main(String[] args) {
        NextGreaterElement nge = new NextGreaterElement();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }
        int[] ng = nextGreaterElements(arr);
        for(int i = 0; i < n; i++)
        {
            System.out.print(ng[i] + " ");
        }
    }
}
    

