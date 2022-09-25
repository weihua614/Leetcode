import org.junit.Test;

public class rotatedDigits_788 {
    public int rotatedDigits(int n) {
        int result=0;
        for (int i=2;i<=n;i++)
        {
            boolean goodNum = isGoodNum(i);
            if (goodNum)
            {
               // System.out.print(i+":");
                result++;
            }
        }
        return result;
    }
    public boolean isGoodNum(int n)
    {
        char[]nums=String.valueOf(n).toCharArray();
        for(int i=0;i<nums.length;i++)
        {
            switch (nums[i]){
                case '0': break;
                case '1': break;
                case '2': nums[i]='5';
                    break;
                case '5': nums[i]='2';
                            break;
                case '6': nums[i]='9';
                    break;
                case '8': break;
                case '9': nums[i]='6';
                    break;
                default: return false;
            }
        }
        int nu=Integer.valueOf(new String(nums));
        if (nu==n) return false;
        else
        {
            System.out.println(n+":"+nu);
            return true;
        }
    }
    @Test
    public void test()
    {
        System.out.println(rotatedDigits(30));
    }
}
