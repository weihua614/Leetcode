package October_2022;

import org.junit.Test;

import java.math.BigInteger;

public class cuttingRope_offer14_2 {
    public int cuttingRope(int n) {
        BigInteger result[]=new BigInteger[n+1];
        result[0]=new BigInteger("0");
        result[1]=new BigInteger("1");
//        result[2]=new BigInteger("1");
//        result[3]=new BigInteger("2");
//        result[4]=new BigInteger("4");
        for (int i=2;i<=n;i++)
        {
            result[i]=new BigInteger("0");
            for (int j=1;j<i;j++)
            {
                BigInteger bigInteger1 = new BigInteger(j + "");
                BigInteger bigInteger2 = new BigInteger((i-j) + "");
                bigInteger2=bigInteger1.multiply(bigInteger2.max(result[i-j]));
                result[i]=result[i].max(bigInteger2);
            }
            //   System.out.println(result[i]);
        }
        return result[n].mod(new BigInteger("1000000007")).intValue();
    }
    @Test
    public void test()
    {
        BigInteger bigInteger1 = new BigInteger("150");
        BigInteger bigInteger2 = new BigInteger("300");
        System.out.println(bigInteger1.add(bigInteger2));
    }
}
