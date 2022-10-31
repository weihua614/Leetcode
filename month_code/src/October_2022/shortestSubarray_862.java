package October_2022;

import org.junit.Test;

public class shortestSubarray_862 {
    public int shortestSubarray(int[] nums, int k) {
        int left=0;
        int result=Integer.MAX_VALUE;
        int sum=0;
        while (left<nums.length)
        {
            sum=0;
            for (int i=left;i<nums.length;i++)
            {
                sum+=nums[i];
                if (sum>=k) result=Math.min(result,i-left+1);
            }
            left++;
        }
        return result==Integer.MAX_VALUE?-1:result;
    }
    @Test
    public void test()
    {
        shortestSubarray(new int[]{-28,81,-20,28,-29},89);
    }
}
