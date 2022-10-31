package October_2022;

public class findRepeatNumber_offer3 {
    public int findRepeatNumber(int[] nums) {
        boolean []flag=new boolean[nums.length];
        for (int i=0;i<flag.length;i++)
        {
            if (!flag[nums[i]])
            {
                flag[nums[i]]=true;
            }
            else return i;
        }
        return -1;
    }
}
