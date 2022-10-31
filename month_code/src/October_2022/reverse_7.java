package October_2022;

import org.junit.Test;

public class reverse_7 {
    public int reverse(int x) {
        if (x==0||x==Math.pow(-2,31))return 0;
        boolean flag=false;
        if (x<0)
        {
            x=0-x;
            flag=true;
        }
        while (x%10==0)
        {
           x=x/10;
        }
        char[] s = String.valueOf(x).toCharArray();
        int i1 = s.length / 2;
        int i2 = s.length ;
        for (int i=0;i<i1;i++)
        {
            char temp=s[i];
            s[i]=s[i2-1-i];
            s[i2-1-i]=temp;
        }
        Double aDouble = Double.valueOf(new String(s));
        if (aDouble>Math.pow(2,31)-1) return 0;
        if (!flag)
        return Integer.valueOf(new String(s));
        else return -Integer.valueOf(new String(s));
    }
    @Test
    public void test()
    {
        System.out.println(Math.pow(-2,31));
       // reverse(-2147483648);
    }
}
