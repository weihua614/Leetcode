package code;

/**
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/convert-bst-to-greater-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class convertBST_538 {
    public TreeNode convertBST(TreeNode root) {
        TreeNode node=root;
        convertBST1(node);
        return root;
    }
    TreeNode node;
    public void convertBST1(TreeNode root) {
        if(root==null) return;
        convertBST1(root.right);
        if(node==null)
        {
            node=root;
        }
        else
        {
            root.val+=node.val;
            node=root;
        }
        convertBST1(root.left);
    }
}
