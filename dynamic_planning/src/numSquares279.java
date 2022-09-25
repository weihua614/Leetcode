import java.util.Arrays;

/**
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/perfect-squares
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class numSquares279 {
    public int numSquares(int n) {
        int result[]=new int[n+1];
        Arrays.fill(result,Integer.MAX_VALUE/2);
        result[0]=0;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=Math.pow(i,0.5);j++)
            {
                result[i]=Math.min(result[i],result[i-j*j]+1);
            }
        }
        return result[n];
    }

    public static void main(String[] args) {
        System.out.println((int) Math.pow(3,0.5));
    }
}
