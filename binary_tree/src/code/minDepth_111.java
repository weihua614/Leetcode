package code;

import java.util.LinkedList;

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 */
public class minDepth_111 {
    public int minDepth(TreeNode root) {
        return cengci(root);
    }
    //层次遍历
    public int cengci(TreeNode node)
    {
        int result=0;
        LinkedList<TreeNode> stack = new LinkedList<>();
        if(node==null) return result;
        else stack.add(node);
        while(!stack.isEmpty())
        {
            int temp=stack.size();
            for(int i=0;i<temp;i++)
            {
                TreeNode treeNode = stack.removeFirst();
                if(treeNode.left==null&&treeNode.right==null)
                {
                    return result+1;
                }
                if(treeNode.left!=null) stack.add(treeNode.left);
                if(treeNode.right!=null) stack.add(treeNode.right);
            }
            result++;
        }
        return result;
    }
    /**
     * 递归
     */
    public int recursion(TreeNode node)
    {
        if(node==null) return 0;
        int num1=recursion(node.left);
        int num2=recursion(node.right);
        return Math.min(num1,num2)+1;
    }
}
