package October_2022;

public class mirrorTree_offer27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root==null) return null;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        root.left=mirrorTree(root.left);
        root.right=mirrorTree(root.right);
        return root;
    }
}
