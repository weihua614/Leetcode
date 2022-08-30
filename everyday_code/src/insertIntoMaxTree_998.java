/**
 *
 */
public class insertIntoMaxTree_998 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        if(root.val<val)
        {
            TreeNode treeNode = new TreeNode(val);
            treeNode.left=root;
            return treeNode;
        }
        root.right=insertIntoMaxTree(root.right,val);
        return root;
    }
}
