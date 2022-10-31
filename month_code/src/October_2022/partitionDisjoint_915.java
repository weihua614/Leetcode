package October_2022;

import org.junit.Test;

public class partitionDisjoint_915 {
    public int partitionDisjoint(int[] nums) {
        int length=nums.length;
        int [][]result=new int[length][2];
        result[length-1][0]=nums[length-1];
        result[0][1]=nums[0];
        for (int i=length-2;i>=0;i--)
        {
            if (nums[i]<result[i+1][0])
            {
                result[i][0]=nums[i];
            }
            else
            {
                result[i][0]=result[i+1][0];
            }
        }
        for (int i=1;i<length;i++)
        {
            if (nums[i]>result[i-1][1])
            {
                result[i][1]=nums[i];
            }
            else
            {
                result[i][1]=result[i-1][1];
            }
        }
        int index=0;
        for (int i=0;i<length;i++)
        {
            System.out.println(result[i][0]+":"+result[i][1]);
            if (i==0&&result[0][0]==result[0][1])
            {
                return 1;
            }
            if (i!=0&&result[i-1][1]<=result[i][0])
            {
                return i;
            }
        }
        return 0;
    }

    public int partitionDisjoint1(int[] nums) {
        int length = nums.length;
        int[][] result = new int[length][2];
        result[length - 1][0] = nums[length - 1];
        result[0][1] = nums[0];
        for (int i = length - 2; i >= 0; i--) {
            if (nums[i] < result[i + 1][0]) {
                result[i][0] = nums[i];
            } else {
                result[i][0] = result[i + 1][0];
            }
        }
        for (int i=0;i<nums.length;i++)
        {
            if (i==0)
            {
                if (nums[0]<=result[0][0])
                {
                    return 1;
                }
                else
                {
                    result[0][1]=nums[0];
                }
            }
            else
            {
                if (result[i-1][1]<=result[i][0])
                {
                    return i;
                }
                else
                {
                    result[i][1]=Math.max(nums[i],result[i-1][1]);
                }
            }
        }
        return 0;
    }
    @Test
    public void test()
    {
        System.out.println(partitionDisjoint(new int[]{1,1,1,0,6,12}));
    }
}
