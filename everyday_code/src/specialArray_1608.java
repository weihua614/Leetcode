import org.junit.Test;

import java.util.Arrays;

public class specialArray_1608 {
    public int specialArray1(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<=nums[nums.length-1];i++)
        {
            int j=0;
            while (j<nums.length)
            {
                if(nums[j]<i)
                {
                    j++;
                }
                else {
                    if(nums.length-j==i) return i;
                    break;
                }
            }

            if(nums.length-j+1==i) return i;
        }
        return -1;
    }

    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int leng=nums.length;
        for(int i=0;i<=nums[nums.length-1];i++)
        {
            if(leng-i<nums.length&&leng-i>=0&&nums[leng-i]>=i&&(leng-i==0||nums[leng-i-1]<i))
            {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void test()
    {
        specialArray(new int[]{3,6,7,7,0});
    }
}
