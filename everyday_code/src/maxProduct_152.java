import org.junit.Test;

public class maxProduct_152 {
    public int maxProduct(int[] nums) {
        int[][]result=new int[nums.length][2];
        result[0][0]=nums[0];
        result[0][1]=nums[0];
        int max=result[0][0];
        for (int i=1;i<nums.length;i++)
        {
            result[i][0]=Math.max(Math.max(result[i-1][0]*nums[i],result[i-1][1]*nums[i]),nums[i]);
            result[i][1]=Math.min(Math.min(result[i-1][0]*nums[i],result[i-1][1]*nums[i]),nums[i]);
            max=Math.max(max,result[i][0]);
        }

        return max;
    }
    @Test
    public void test()
    {
        maxProduct(new int[]{2,-5,-2,-4,3});
    }
}
