import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class coinChange_322 {
    public int coinChange(int[] coins, int amount) {
        int result[]=new int[amount+1];
        int max=Integer.MAX_VALUE;
        for (int j = 0; j < result.length; j++) {
            result[j] = max;
        }
        result[0]=0;
        for(int i=0;i<coins.length;i++)
        {
            for(int j=coins[i];j<=amount;j++)
            {
                result[j]=Math.min(result[j],result[j-coins[i]]+1);
            }
        }
        return result[amount]==Integer.MAX_VALUE/2?-1:result[amount];
    }
}
