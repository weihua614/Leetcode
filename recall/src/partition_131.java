import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 */
public class partition_131 {
    ArrayList<List<String>> list=new ArrayList<List<String>>();
    LinkedList<String> node=new LinkedList<>();
    public List<List<String>> partition(String s) {
        recall(s.toCharArray(),0,s.length());
        return list;
    }
    public void recall(char[] s,int start,int end) {
        if(start>=end)
        {
            list.add(new LinkedList<>(node));
            return;
        }
        for(int i=start;i<end;i++)
        {
            if(isHui(s,start,i))
            {
                node.add(new String(s,start,i-start+1));
                recall(s,i+1,end);
                node.removeLast();
            }
        }
    }
    public boolean isHui(char[] chars,int start,int end)
    {

        for(int i=start;i<=start+(end-start)/2;i++)
        {
            if(chars[i] !=chars[end+start-i])
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        partition_131 partition_131 = new partition_131();
        partition_131.isHui("aab".toCharArray(), 0, 2);
        System.out.println();
    }
}
