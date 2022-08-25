import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 *
 * 只使用数字1到9
 * 每个数字 最多使用一次 
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class combinationSum3_216 {
    ArrayList<List<Integer>> list=new ArrayList<List<Integer>>();
    LinkedList<Integer> node=new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        combinationSum31(k,n,1);
        return list;
    }
    public void combinationSum31(int k, int n,int index) {
        if(node.size()==k)
        {
            if(n==0)
            {
                list.add(new LinkedList<>(node));
            }
                return ;
        }
        for(int i=index;i<=9-k+node.size()+1;i++)
        {
            node.add(i);
            combinationSum31(k,n-i,i+1);
            node.removeLast();
        }
    }

    public static void main(String[] args) {
        combinationSum3_216 combinationSum3_216 = new combinationSum3_216();
        combinationSum3_216.combinationSum3(3,7);
        System.out.println(combinationSum3_216.list);
    }
}
