package October_2022;

public class isSymmetric_offer28 {
    public boolean isSymmetric(TreeNode root) {
        return isSim(root,root);
    }
    public boolean isSim(TreeNode root1,TreeNode root2) {
        if (root1==null&&root2==null) return true;
        if (root1==null) return false;
        if (root2==null) return false;
        if (root1.val!=root2.val) return false;
        return isSim(root1.left,root2.right)&&isSim(root1.right,root2.left);
    }
}
