package SlidingWindowAndTwoPointers;

class ContainerwithMostwater {
    public int maxArea(int[] height) {
        int n = height.length;
        int lp = 0 , rp = n-1;
        int ans = 0 , maxwater = 0;

        while(lp<rp)
        {
            int width = rp-lp;
            int ht = Math.min(height[lp],height[rp]);
            int currwt = width*ht;

            maxwater = Math.max(maxwater,currwt);

            if(height[lp] < height[rp])
            { 
                lp++;
            }
            else
            {
                rp--;
            } 

        }

        return maxwater;
    }
}