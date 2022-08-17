package code;

/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点
 */

public class invertTree_226 {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    public void invert (TreeNode root)
    {
        if(root == null) return;
        invert(root.left);
        invert(root.right);
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
    }
}
