import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一棵二叉树 root，返回所有重复的子树。
 *
 * 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 *
 * 如果两棵树具有相同的结构和相同的结点值，则它们是重复的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-duplicate-subtrees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class findDuplicateSubtrees_652 {
//    LinkedList<TreeNode>  result=new LinkedList<TreeNode>();
//    LinkedList<TreeNode>  xianxu=new LinkedList<TreeNode>();
//    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
//        digui(root);
//        System.out.println(xianxu);
//        boolean flag[]=new boolean[xianxu.size()];
//        for(int i=0;i<xianxu.size();i++)
//        {
//            if(flag[i]) continue;
//            for(int j=i+1;j<xianxu.size();j++)
//            {
//                if(flag[j]) continue;
//                if(isEqual(xianxu.get(i),xianxu.get(j)))
//                {
//
//                    flag[j]=true;
//                    if(!flag[i])
//                    result.add(xianxu.get(i));
//                    flag[i]=true;
//                }
//            }
//            for(int m=0;m<flag.length;m++)
//                System.out.print(m+":"+flag[m]);
//            System.out.println();
//        }
//        return result;
//    }
//    public boolean isEqual(TreeNode node1,TreeNode node2)
//    {
//        if(node1==null&&node2!=null) return false;
//        if(node1!=null&&node2==null) return false;
//        if(node1==null&&node2==null) return true;
//        if(node1.val==node2.val)
//        {
//            return isEqual(node1.left,node2.left)&&isEqual(node1.right,node2.right);
//        }
//        else return false;
//    }
//    public void digui(TreeNode node)
//    {
//        if(node==null) return;
//        xianxu.add(node);
//        digui(node.left);
//        digui(node.right);
//    }

    HashMap<String,TreeNode> map=new HashMap<>();
    LinkedList<TreeNode>  result=new LinkedList<TreeNode>();
    HashSet<TreeNode> set=new HashSet<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        recall(root);
        return result;
    }
    public void serc(TreeNode root,StringBuilder str)
    {
        if(root==null)
        {
            str.append("null");
            return;
        }
        str.append(root.val+"->");
        serc(root.left,str);
        serc(root.right,str);
    }
    public void recall(TreeNode root)
    {
        if(root==null) return;
        StringBuilder stringBuffer = new StringBuilder();

        serc(root,stringBuffer);
        String s = stringBuffer.toString();
        if(map.containsKey(s))
        {
            if(!set.contains(map.get(s)))
            {
                result.add(map.get(s));
                set.add(map.get(s));
            }
        }
        else map.put(s,root);
        recall(root.left);
        recall(root.right);
    }
}
