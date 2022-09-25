import java.util.LinkedList;

/**
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 *
 * 在每一天，你可以决定是否购买和/或出售股票。
 * 你在任何时候 最多 只能持有 一股 股票。
 * 你也可以先购买，然后在 同一天 出售。
 *
 * 返回 你能获得的 最大 利润 。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class maxProfit_122 {
    //动态规划
    public int maxProfit1(int[] prices) {
        //0 不持有股票拥有的现金
        //1 持有股票拥有的现金
        int result[][]=new int[prices.length][2];
        result[0][0]=0;
        result[0][1]=prices[0];
        for(int i=1;i<prices.length;i++)
        {
            result[i][0]=Math.max(result[i-1][0],result[i-1][1]+prices[i]);
            result[i][1]=Math.max(result[i-1][1],result[i-1][0]-prices[i]);
        }
        return result[prices.length-1][0];
    }

    //贪心算法
    public int maxProfit(int[] prices) {
        LinkedList<Integer> list=new LinkedList<>();
        int sum=0;
        int i=0;
        while(i<prices.length)
        {
            if(list.size()==0) list.add(prices[i]);
            else if(list.size()==1&&prices[i]<=list.getFirst())
            {
                list.removeFirst();
                list.add(prices[i]);
            }
            else if(list.size()==1&&prices[i]>list.getLast())
            {
                list.add(prices[i]);
            }
            else if(list.size()==2&&prices[i]>=list.getLast())
            {
                list.removeLast();
                list.add(prices[i]);
            }
            else {
                Integer temp1 = list.removeLast();

                Integer temp2 = list.removeFirst();
                System.out.print(temp1+","+temp2+":");
                sum=sum+temp1-temp2;
                list.add(prices[i]);
            }

            System.out.println(list);
            i++;
        }
        if (list.size()==2)
        {
            Integer temp1 = list.removeLast();

            Integer temp2 = list.removeFirst();
            sum=sum+temp1-temp2;
        }
        return sum;
    }


    public int maxProfit2(int[] prices) {
            int result = 0;
            for (int i = 1; i < prices.length; i++) {
                result += Math.max(prices[i] - prices[i - 1], 0);
            }
            return result;
    }

}
