import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class findSubsequences_491 {
    ArrayList<List<Integer>> list=new ArrayList<List<Integer>>();
    LinkedList<Integer> node=new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        recall(nums,0);
        return list;
    }
    public void recall(int[]nums,int start)
    {
        if(node.size()>1) list.add(new LinkedList<>(node));
        if(start>=nums.length) return;
        int []flag=new int[201];
        for(int i=start;i<nums.length;i++)
        {
            if(!node.isEmpty()&&nums[i]<node.getLast()||flag[nums[i]+100]==1) continue;
            node.add(nums[i]);
            flag[nums[i]+100]=1;
            recall(nums,i+1);
            node.removeLast();
        }
    }

    public static void main(String[] args) {
        int result[]=new int[]{4,4,3,2,1};
        findSubsequences_491 findSubsequences_491 = new findSubsequences_491();
        System.out.println(findSubsequences_491.findSubsequences(result));
    }

}
