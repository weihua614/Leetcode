import java.util.ArrayList;
import java.util.Arrays;

public class missingTwo_1719M {
    public int[] missingTwo1(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> list=new ArrayList<>();
        int num=1;
        for (int i=0;i<nums.length;i++)
        {
            if (nums[i]!=num)
            {
                list.add(num);
                num++;
                if (nums[i+1]!=num+1)
                {
                    list.add(num+1);
                    break;
                }
            }
            num++;
        }
        if (list.size()==2) return new int[]{list.get(0),list.get(1)};
        if (list.size()==1)
        {
                return new int[]{list.get(0),nums[nums.length-1]+1};
        }
        else return new int[]{nums.length+1,nums.length+2};
    }

    public int[] missingTwo(int[] nums) {
        int[]result=new int[nums.length+3];
        for (int i=0;i<nums.length;i++)
        {
            result[nums[i]]=300001;
        }
        ArrayList<Integer> list=new ArrayList<>();
        for (int i=1;i<nums.length+3;i++)
        {
            if (result[i]!=300001)
            list.add(i);
        }
        return new int[]{list.get(0),list.get(1)};
    }
}
