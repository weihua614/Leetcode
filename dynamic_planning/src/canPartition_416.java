import org.junit.Test;

/**
 * 给你一个 只包含正整数 的 非空 数组 nums 。
 * 请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class canPartition_416 {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i:nums)
            sum+=i;
        if(sum%2==1) return false;
        sum=sum/2;

        int result[]=new int[sum+1];
        result[0]=0;
        //背包问题
        //从物品循环
        for(int i=0;i<nums.length;i++)
        {
            //背包容量循环
            for(int j=sum;j>=nums[i];j--)
            {
                result[j]=Math.max(result[j],result[j-nums[i]]+nums[i]);
            }
        }
        return sum==result[sum];
    }
    @Test
    public void test(){
        canPartition(new int[]{1,5,11,5});
    }
}
