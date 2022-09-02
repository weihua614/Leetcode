import org.junit.Test;

import java.util.LinkedList;

public class finalPrices_1475 {
    public int[] finalPrices1(int[] prices) {
        int result[]=new int[prices.length];
        for(int i=0;i<prices.length;i++)
        {
            for(int j=i+1;j<prices.length;j++)
            {
                if(prices[j]<=prices[i])
                {
                    result[i]=prices[i]-prices[j];
                    break;
                }
                result[i]=prices[i];
            }
        }
        result[prices.length-1]=prices[prices.length-1];
        return result;
    }
    public int[] finalPrices(int[] prices) {
        int result[]=new int[prices.length];
        LinkedList<Integer> stack=new LinkedList<>();
        for(int i=result.length-1;i>=0;i--)
        {
            while(!stack.isEmpty()&&stack.getLast()>prices[i])
            {
                stack.removeLast();
            }
            if(stack.isEmpty())
            {
                result[i]=prices[i];
            }
            else
            {
                result[i]=prices[i]-stack.getLast();
            }
            stack.add(prices[i]);
        }
        return result;
    }
    @Test
    public void test(){
        finalPrices(new int[]{8,7,4,2,8,1,7,7,10,1});
    }
}
