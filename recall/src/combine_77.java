import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 */
public class combine_77 {
    List<List<Integer>> result=new ArrayList<>();
    LinkedList<Integer> node=new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        combine1(n,k,1);
        return result;
    }
    public void combine1(int n, int k,int index) {
        if(node.size()==k)
        {
            result.add(new LinkedList<>(node));
            return;
        }
            for(int i=index;i<=n-k+node.size()+1;i++)
            {
                node.add(i);
                combine1(n,k,i+1);
                node.removeLast();
            }
        //return result;
    }

    public static void main(String[] args) {
        combine_77 combine_77 = new combine_77();
        List<List<Integer>> combine = combine_77.combine(4, 2);
        System.out.println(combine);
    }
}
