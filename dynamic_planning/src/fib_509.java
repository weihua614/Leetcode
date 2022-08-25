/**
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。
 * 该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是
 */
public class fib_509 {
    public int fib(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        return fib(n-1)+fib(n-2);
    }

    public int fib1(int n) {
        if(n<2) return n;
        int result[]=new int[n+1];
        result[0]=0;
        result[1]=1;
        for(int i=2;i<=n;i++)
        {
            result[i]=result[i-1]+result[i-2];
        }
        return result[n];
    }
}
