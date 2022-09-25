public class maxProfit_714 {//39
    public int maxProfit(int[] prices, int fee) {
        //0 不持有股票 1持有股票
        int result[][]=new int[prices.length][2];
        result[0][1]=-prices[0];
        for(int i=1;i<prices.length;i++)
        {
            result[i][0]=Math.max(result[i-1][0],result[i-1][1]+prices[i]-fee);
            result[i][1]=Math.max(result[i-1][1],result[i-1][0]-prices[i]);
        }
        return Math.max(result[prices.length-1][0],result[prices.length-1][1]);
    }
}
