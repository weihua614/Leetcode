import java.math.BigInteger;
import java.util.Scanner;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class climbStairs_70 {
    public int climbStairs(int n) {
        if(n<=2) return n;
        int result[]=new int[n+1];
        result[0]=0;
        result[1]=1;
        result[2]=2;
        for(int i=3;i<n;i++)
        {
            result[i]=result[i-1]+result[i-2];
        }
        return result[n];
    }

}

