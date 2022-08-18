package code;

import java.util.LinkedList;

/**
 * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
 *
 * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/search-in-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class searchBST_700 {
    public TreeNode searchBST(TreeNode root, int val) {
        return levelSearch(root,val);

    }
    /**
     * 层次遍历
     */
    public TreeNode levelSearch(TreeNode root, int val)
    {
        if(root==null) return null;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while(!stack.isEmpty())
        {
            int temp=stack.size();
            for(int i=0;i<temp;i++)
            {
                TreeNode node = stack.removeFirst();
                if(node.val==val) return node;
                if(node.left!=null) stack.add(node.left);
                if(node.right!=null) stack.add(node.right);
            }
        }
        return null;
    }
    /**
     * 递归遍历
     */
    public TreeNode diguiSearch(TreeNode root, int val)
    {
        if(root==null) return null;
        if(root.val==val) return root;
        TreeNode node1 = diguiSearch(root.left, val);
        TreeNode node2 = diguiSearch(root.right, val);
        if(node1==null&&node2==null) return null;
        else
            return node1==null?node2:node1;
    }
}
