package code;

/**
 * 给定二叉搜索树（BST）的根节点 root 和要插入树中的值 value ，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/insert-into-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class insertIntoBST_701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        byte a1 = 2, a2 = 8, a3;
        short s = 16;

        if(root==null)
        {
            return new TreeNode(val);
        }
        TreeNode node=root;
        insertIntoBST1(node,val);
        return root;
    }
    public void  insertIntoBST1(TreeNode root, int val) {
        if(val>root.val)
        {
            if(root.right!=null)
            {
                insertIntoBST1(root.right,val);
            }
            else
            {
                TreeNode node = new TreeNode(val);
                root.right=node;
            }
        }
        else
        {
            if(root.left!=null)
            {
                insertIntoBST1(root.left,val);
            }
            else
            {
                TreeNode node = new TreeNode(val);
                root.left=node;
            }
        }
    }
}
