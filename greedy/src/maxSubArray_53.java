public class maxSubArray_53 {
    public int maxSubArray(int[] nums) {
        int result[][]=new int[nums.length][2];
        result[0][0]=nums[0];
        result[0][1]=0;
        int MaxSum=Math.max(result[0][0],result[0][1]);
        for(int i=1;i<result.length;i++)
        {
            result[i][0]=Math.max(result[i-1][0]+nums[i],nums[i]);
            result[i][1]=Math.max(result[i-1][0],result[i-1][1]);
        }
        return Math.max(result[result.length-1][0],result[result.length-1][1]);
    }
}
