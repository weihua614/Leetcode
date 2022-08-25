import org.junit.Test;

/**
 * 你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 *
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 *
 * 请你计算并返回达到楼梯顶部的最低花费。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/min-cost-climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class minCostClimbingStairs_746 {
    public int minCostClimbingStairs(int[] cost) {
        int[] result = new int[cost.length+1];
        if(cost.length<2) return 0;
        result[0]=0;
        result[1]=0;
        for(int i=2;i<=cost.length;i++)
        {
            result[i]=Math.min(result[i-1]+cost[i-1],result[i-2]+cost[i-2]);
        }
        return result[cost.length];

    }
    @Test
    public void test(){
        int []re=new int[]{1,100};
        int i = minCostClimbingStairs(re);
        System.out.println(i);
    }
}

