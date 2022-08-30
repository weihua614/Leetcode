import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class permute_46 {


    ArrayList<List<Integer>> list=new ArrayList<List<Integer>>();
    LinkedList<Integer> node=new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        recall(nums,new boolean[nums.length]);
        return list;

    }
    public void recall(int []nums,boolean []flag)
    {
        if(node.size()==nums.length)
        {
            list.add(new LinkedList<>(node));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(!flag[i])
            {
                flag[i]=true;
                node.add(nums[i]);
                recall(nums,flag);
                node.removeLast();
                flag[i]=false;
            }
        }
    }

    @Test
    public void test()
    {
        permute(new int[]{1,2,3});
        System.out.println(list);
    }
}
