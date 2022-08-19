package code;

/**
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * 差值是一个正数，其数值等于两值之差的绝对值。
 */

public class getMinimumDifference_530 {
    int min=Integer.MAX_VALUE;
    TreeNode node;
    public int getMinimumDifference(TreeNode root) {
        if(root.left!=null)
        {
            getMinimumDifference(root.left);
        }
        if(node!=null)
        {
            min=Math.min(min,root.val-node.val);
        }
        node=root;
        if(root.right!=null)
        {
            getMinimumDifference(root.right);
        }
        return min;
    }
}
