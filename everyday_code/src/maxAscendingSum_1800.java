public class maxAscendingSum_1800 {
    public int maxAscendingSum(int[] nums) {
        int length=nums.length;
        int result[]=new int[length];
        result[0]=nums[0];
        for (int i=1;i<length;i++)
        {
            if (nums[i]>=nums[i-1])
            {
                result[i]=nums[i]+result[i-1];
            }
            else
            {
                result[i]=nums[i];
            }
        }
        int max=0;
        for (int num:result)
        {
            max=Math.max(max,num);
        }
        return max;
    }
}
