/**
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 *
 * 返回 你可以获得的最大乘积 。
 */
public class integerBreak_343 {
    public int integerBreak(int n) {
        int result[]=new int[n+1];
        result[1]=1;
        for(int i=2;i<=n;i++)
        {
            for(int j=1;j<i;j++)
            {
                result[i]=Math.max(Math.max(result[i],j*result[i-j]),j*(i-j));
            }
        }
        return result[n];
    }

}
