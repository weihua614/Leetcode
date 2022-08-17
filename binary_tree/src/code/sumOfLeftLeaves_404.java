package code;

/**
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 *
 *
 */
public class sumOfLeftLeaves_404 {
    int sum=0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return sum;
        else
            sumOfLeftLeaves1(root);
        return sum;
    }
    public void sumOfLeftLeaves1(TreeNode root) {
        if(root.left!=null)
        {
            if(root.left.left==null&&root.left.right==null)
            sum+=root.left.val;
            sumOfLeftLeaves1(root.left);
        }
        if (root.right!=null)
        {
            sumOfLeftLeaves1(root.right);
        }
    }
}
