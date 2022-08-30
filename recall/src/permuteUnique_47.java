import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class permuteUnique_47 {
    ArrayList<List<Integer>> list=new ArrayList<List<Integer>>();
    LinkedList<Integer> node=new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        //Arrays.sort(nums);
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
        boolean numsFlag[]=new boolean[21];
        for(int i=0;i<nums.length;i++)
        {
            if(numsFlag[nums[i]+10]) continue;
            if(!flag[i])
            {
                numsFlag[nums[i]+10]=true;
                flag[i]=true;
                node.add(nums[i]);
                recall(nums,flag);
                node.removeLast();
                flag[i]=false;
            }
//            if(i==nums.length-1) {
//                for (int j = 0; j < nums.length; j++)
//                {
//                    System.out.print(flag[j]);
//                    System.out.println();
//                }
//            }
        }
    }
}
