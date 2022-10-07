import java.util.HashSet;

public class findDuplicate_287 {
    public int findDuplicate(int[] nums) {
        boolean index[]=new boolean[nums.length+1];
        for (int i:nums)
        {
            if (index[nums[i]])
            {
                return i;
            }
            else index[nums[i]]=true;
        }
        return 0;
    }
}
