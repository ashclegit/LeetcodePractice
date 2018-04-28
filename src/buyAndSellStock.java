public class buyAndSellStock {


    public int findMaxProfit(int[] prices)
    {
        int maxSoFar = 0;
        int maxCur  = 0;

        for(int i=1;i<prices.length;i++)
        {
            maxCur = Math.max(0,maxCur+prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur,maxSoFar);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {

        buyAndSellStock bs = new buyAndSellStock();
        int[] stocks = {7,1,5,3,6,4};
        System.out.println(bs.findMaxProfit(stocks));

    }

}
