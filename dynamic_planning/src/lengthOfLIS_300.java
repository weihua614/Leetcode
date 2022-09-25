public class lengthOfLIS_300 {//42
    public int lengthOfLIS(int[] nums) {
        int result[]=new int[nums.length];
        int max=1;
        result[0]=1;
        for(int i=1;i<nums.length;i++)
        {
            result[i]=1;
            for(int j=i-1;j>=0;j--)
            {
                if (nums[i]>nums[j])
                {
                    result[i]=Math.max(result[i],result[j]+1);
                    max=Math.max(max,result[i]);
                }
            }
        }
        return max;
    }
}
