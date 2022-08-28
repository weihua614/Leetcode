import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class subsetsWithDup_90 {
    ArrayList<List<Integer>> list=new ArrayList<List<Integer>>();
    LinkedList<Integer> node=new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        list.add(new LinkedList<>());
        Arrays.sort(nums);
        recall(nums,0);
        return list;
    }
    public void recall(int[] nums,int start)
    {
        if(start>=nums.length)
            return;
        for(int i=start;i<nums.length;i++)
        {
            if(i!=start)
            {
                if(nums[i]==nums[i-1]) continue;
            }
            node.add(nums[i]);
            list.add(new LinkedList<>(node));
            recall(nums,i+1);
            node.removeLast();
        }
    }
}
