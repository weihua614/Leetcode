public class maxProfit_309 {//37
    public int maxProfit(int[] prices) {
        //0 不是今天卖，不持有股票 1是今天卖，不持有股票 2持有股票
        int result[][]=new int[prices.length][3];
        result[0][2]=-prices[0];
        for(int i=1;i<prices.length;i++)
        {
            result[i][0]=Math.max(result[i-1][0],result[i-1][1]);
            result[i][1]=result[i-1][2]+prices[i];
            result[i][2]=Math.max(result[i-1][0]-prices[i],result[i-1][2]);
        }
        return Math.max(result[prices.length-1][0],result[prices.length-1][1]);

    }
}
