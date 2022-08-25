import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class combinationSum2_40 {
    ArrayList<List<Integer>> list=new ArrayList<List<Integer>>();
    LinkedList<Integer> node=new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        recall(candidates,target,0);
        return list;
    }
    public void recall(int[] candidates, int target,int index) {
        if(target==0)
        {
            list.add(new LinkedList<>(node));
            return;
        }
        if(target<0) return;
        for(int i=index;i<candidates.length;i++)
        {
            if(i>index)
            {
                if(candidates[i]==candidates[i-1]) continue;
            }
            if(target-candidates[i]<0) break;
            node.add(candidates[i]);
            recall(candidates,target-candidates[i],i+1);
            node.removeLast();
        }

    }
}
