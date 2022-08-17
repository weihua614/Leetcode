package code;

import java.util.LinkedList;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 */
public class maxDepth_104 {
    public int maxDepth(TreeNode root) {
        return recursion(root);
    }

    //递归算法
    public int recursion(TreeNode root)
    {
        if(root==null) return 0;
        int num1=recursion(root.left);
        int num2=recursion(root.right);
        return Math.max(num1,num2)+1;
    }
    //层次遍历
    public int ceci(TreeNode root)
    {
        int result=0;
        LinkedList<TreeNode> stack = new LinkedList<>();
        if(root==null) return result;
        else stack.add(root);
        while(!stack.isEmpty())
        {
            int temp=stack.size();
            for(int i=0;i<temp;i++)
            {
                TreeNode treeNode = stack.removeFirst();
                if(treeNode.left!=null) stack.add(treeNode.left);
                if(treeNode.right!=null) stack.add(treeNode.right);
            }
            result++;
        }
        return result;
    }
}
