package code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */
public class levelOrder_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if(root==null) return result;
        else stack.add(root);
        while(!stack.isEmpty())
        {
            int num=stack.size();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0;i<num;i++)
            {
                TreeNode node = stack.removeFirst();
                list.add(node.val);
                if(node.left!=null) stack.add(node.left);
                if(node.right!=null) stack.add(node.right);
            }
            result.add(list);
        }
        return result;
    }
}
