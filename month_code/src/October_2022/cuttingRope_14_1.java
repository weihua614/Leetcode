package October_2022;

import java.math.BigInteger;

public class cuttingRope_14_1 {
    public int cuttingRope(int n) {
        int result[]=new int[n+1];
        result[0]=0;
        result[1]=1;
        for (int i=2;i<=n;i++)
        {
            for (int j=1;j<i;j++)
            {
                result[i]=Math.max(result[i],j*Math.max(result[i-j],i-j));
            }
            //   System.out.println(result[i]);
        }
        return result[n];
    }
}
