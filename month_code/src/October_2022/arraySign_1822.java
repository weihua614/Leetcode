package October_2022;

import java.util.ArrayDeque;

public class arraySign_1822 {
    public int arraySign(int[] nums) {
        int result=1;
        for (int i:nums)
        {
            if (i==0)
            {
                result=0;
                break;
            }
            result=i>0?result:-result;
        }
        return result;
    }
}
