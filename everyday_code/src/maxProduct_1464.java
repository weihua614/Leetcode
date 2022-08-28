import java.util.Arrays;

/**
 * 给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。
 *
 * 请你计算并返回该式的最大值。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-product-of-two-elements-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class maxProduct_1464 {
    public int maxProduct1(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length-1]-1)*(nums[nums.length-2]-1);
    }

    public int maxProduct2(int[] nums) {
        int result[][]=new int[2][2];
        result[0][0]=0;
        result[1][0]=1;
        result[0][1]=nums[0];
        result[1][1]=nums[1];
        if(nums.length==2)
            return (nums[0]-1)*(nums[1]-1);
        for(int i=2;i<nums.length;i++)
        {
            if(nums[i]>result[0][1])
            {
                if(result[0][1]>result[1][1])
                {
                    result[1][0]=result[0][0];
                    result[1][1]=result[0][1];
                }
                result[0][0]=i;
                result[0][1]=nums[i];
            }
            else
            {
                if(nums[i]>=result[1][1])
                {
                    result[1][0]=i;
                    result[1][1]=nums[i];
                }
            }
//            else
//            {
//                if(nums[i]>=result[1][1])
//                {
//                    result[1][0]=i;
//                    result[1][1]=nums[i];
//                }
//            }
        }
        return (result[0][1]-1)*(result[1][1]-1);
    }
    public int maxProduct(int[] nums) {
        int num1=nums[0];
        int num2=nums[1];
        if(nums.length==2)
            return (nums[0]-1)*(nums[1]-1);
        for(int i=2;i<nums.length;i++)
        {
            if(nums[i]>num1)
            {
                if(num1>num2)
                {
                    num2=num1;
                }
                num1=nums[i];
            }
            else
            {
                if(nums[i]>=num2)
                {
                    num2=nums[i];
                }
            }
        }
        return (num1-1)*(num1-1);
    }
}
