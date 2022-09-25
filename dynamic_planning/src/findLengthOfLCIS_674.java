public class findLengthOfLCIS_674 {//42
    public int findLengthOfLCIS(int[] nums) {
        int result[]=new int[nums.length];
        result[0]=1;
        int max=1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>nums[i-1])
            {
                result[i]=result[i-1]+1;
                max=Math.max(max,result[i]);
            }
            else  result[i]=1;

        }
        return max;
    }
}
