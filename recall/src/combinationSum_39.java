import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class combinationSum_39 {
    ArrayList<List<Integer>> list=new ArrayList<List<Integer>>();
    LinkedList<Integer> node=new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        recall(candidates,target,0);
        return list;
    }
    public void recall(int[] candidates, int target,int index)
    {
        if(target==0)
        {
            list.add(new LinkedList<>(node));
            return;
        }
        if(target<0) return;
        for(int i=index;i<candidates.length;i++)
        {
            if(target-candidates[i]<0)break;
            node.add(candidates[i]);

            recall(candidates,target-candidates[i],i);
            node.removeLast();
        }
    }
}
