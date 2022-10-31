package October_2022;

import org.junit.Test;

public class atMostNGivenDigitSet_902 {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String s=n+"";
        int sum=0;
        int x=1;
        while (x<s.length())
        {
            sum+=Math.pow(digits.length,x);
            x++;
        }
        sum+=recall(digits,0,s);
        return sum;
    }
    public int recall(String[] digits,int index,String s)
    {
        int nums=s.charAt(index)-'0';
        int result=0;
        for (int i=0;i<digits.length;i++)
        {
            if (Integer.valueOf(digits[i])<nums)
            {
                result+=(int) Math.pow(digits.length,s.length()-index-1);
            }
            else if (Integer.valueOf(digits[i])==nums)
            {
                if (index<s.length()-1)
                result+=recall(digits,index+1,s);
                else result++;
            }
            else break;
        }
        return result;
    }
    @Test
    public void test()
    {
        String s = "a" + "b" + "c" + "d";
        System.out.println(s == "abcd");
//        short s1 = 9999;
//        System.out.println(s1);
        //System.out.println(atMostNGivenDigitSet(new String[]{"1", "2", "3", "4", "5", "6", "7", "9"}, 1578));
    }


}
