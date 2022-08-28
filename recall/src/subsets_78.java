import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class subsets_78 {
    ArrayList<List<Integer>> list=new ArrayList<List<Integer>>();
    LinkedList<Integer> node=new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        list.add(new LinkedList<>());
        recall(nums,0);
        return list;
    }
    public void recall(int[] nums,int start)
    {
        if(start>=nums.length) return;
        for(int i=start;i<nums.length;i++)
        {
            node.add(nums[i]);
            list.add(new LinkedList<>(node));
            recall(nums,i+1);
            node.removeLast();
        }
    }
}
