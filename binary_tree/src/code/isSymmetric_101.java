package code;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class isSymmetric_101 {
    public boolean isSymmetric(TreeNode root) {
        return isSym(root,root);
    }
    public boolean isSym(TreeNode left,TreeNode right)
    {
        if(left==null&&right!=null) return false;
        if(left!=null&&right==null) return false;
        if(left==null&&right==null) return true;
        if(left.val!=right.val) return false;

        return isSym(left.left,right.right)&&isSym(left.right,right.left);
    }
}
