package October_2022;

public class fib_offer10_1 {
    final int mod=1000000007;
    public int fib(int n) {
        int []result=new int[n+1];
        result[0]=0;
        result[1]=1;
        for (int i=2;i<=n;i++)
        {
            result[i]=(result[i-1]+result[i-2])%mod;
        }
        return result[n];
    }
}
