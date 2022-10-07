public class maxSubArray_53 {
    public int maxSubArray(int[] nums) {
        int result[]=new int[nums.length];
        result[0]=nums[0];
        int max=result[0];
        for(int i=1;i<nums.length;i++)
        {
            result[i]=Math.max(nums[i],result[i-1]+nums[i]);
            max=Math.max(max,result[i]);
        }
        return max;
    }
}
