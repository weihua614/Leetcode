import java.util.HashMap;

public class subarraySum_560 {
    public int subarraySum1(int[] nums, int k) {
        int sum=0;
        int result=0;
        for (int i=0;i<nums.length;i++)
        {
            sum=0;
            for (int j=i;j<nums.length;j++)
            {
                sum+=nums[j];
                if (sum==k) result++;
            }
        }
        return result;
    }

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int length = nums.length;
        int sum=0;
        int result=0;
        for (int i=0;i<length;i++)
        {
            sum+=nums[i];
            if(sum==k) result++;
            result+=map.getOrDefault(sum-k,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return result;
    }
}
