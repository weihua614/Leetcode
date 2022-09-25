/**
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class jump_45 {
    public int jump(int[] nums) {
        if(nums.length==1) return 0;
        if(nums[0]>=nums.length-1) return 1;
        int maxLength=nums[0];
        int max=nums[0];
        int result=1;
        for(int i=1;i<nums.length;i++)
        {
            if(i<maxLength)
            {
                max=Math.max(nums[i]+i,max);
                continue;
            }
            if(i==maxLength)
            {
                max=Math.max(nums[i]+i,max);
                maxLength=max;
                result++;
                if(maxLength>=nums.length-1)
                {
                    return result;
                }
            }
        }
        return -1;
    }
}
