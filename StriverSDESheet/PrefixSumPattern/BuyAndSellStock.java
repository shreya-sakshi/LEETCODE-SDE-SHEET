package PrefixSumPattern;

public class BuyAndSellStock {
    
    public static int buyandsellstock(int prices[])
    {
        int buyprice = Integer.MAX_VALUE;
        int maxprofit=0;

        for(int i=0 ; i<prices.length ; i++)
        {
            if(buyprice < prices[i])  //profit
            {
                int profit = prices[i] - buyprice; //today's (profit = sellingprice - buyprice)
                maxprofit = Math.max(maxprofit,profit); //max profit
            }
            else{
                buyprice=prices[i];
            }
        }
          
        return maxprofit;

    }

    public static void main(String[] args) { // O(n) time complexity
        int prices[] = {7,1,5,3,6,4};

        System.out.println(buyandsellstock(prices));

    }
    
}
