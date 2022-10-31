//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 示例 1： 
//
// 输入：n = 2
//输出：2
// 
//
// 示例 2： 
//
// 输入：n = 7
//输出：21
// 
//
// 示例 3： 
//
// 输入：n = 0
//输出：1 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
//
// 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/ 
//
// 
// Related Topics 记忆化搜索 数学 动态规划 
// 👍 337 👎 0

package October_2022.cn;
import org.junit.Test;

//Java：青蛙跳台阶问题
//2022-10-29 22:28:50
//剑指 Offer 10- II
    
    
class QingWaTiaoTaiJieWenTiLcof{
   //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numWays(int n) {
        final int mod=1000000007;
        int result[]=new int[n+1];
        result[0]=1;
        if (n>=1)
        result[1]=1;
        for (int i=2;i<=n;i++)
        {
            result[i]=(result[i-1]+result[i-2])%mod;
        }
        return result[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void test()
    {
    
    }
    
    
}
