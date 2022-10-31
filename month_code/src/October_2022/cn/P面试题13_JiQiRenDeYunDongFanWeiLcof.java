//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// Related Topics 深度优先搜索 广度优先搜索 动态规划 
// 👍 578 👎 0

package October_2022.cn;
import org.junit.Test;

//Java：机器人的运动范围
//2022-10-30 18:59:45
//面试题13
    
    
class JiQiRenDeYunDongFanWeiLcof{
   //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int result=0;
    public int movingCount(int m, int n, int k) {
        recall(m,n,k,0,0,new boolean[m][n]);
        return result;
    }
    public void recall(int m,int n,int k,int left,int right,boolean[][]flag)
    {
        if (left>=m||left<0||right>=n||right<0||flag[left][right]) return;
        if (isValid(left,right,k))
        {
            result++;
            flag[left][right]=true;
            recall(m,n,k,left+1,right,flag);
            recall(m,n,k,left-1,right,flag);
            recall(m,n,k,left,right+1,flag);
            recall(m,n,k,left,right-1,flag);
        }

    }
    public boolean isValid(int left,int right,int k)
    {
        int sum=0;
        while (left!=0)
        {
            sum+=left%10;
            left=left/10;
        }
        while (right!=0)
        {
            sum+=right%10;
            right=right/10;
        }
        if (sum>k) return false;
        else return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void test()
    {
    
    }
    
    
}
