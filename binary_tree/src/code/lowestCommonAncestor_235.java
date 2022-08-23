package code;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 */

public class lowestCommonAncestor_235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root.val>Math.min(p.val,q.val)&&root.val<Math.max(p.val,q.val))
        {
            return root;
        }
        if(root.val>Math.max(p.val,q.val))
        {
            return lowestCommonAncestor(root.left,p,q);
        }
        else if(root.val<Math.min(p.val,q.val))
        {
            return lowestCommonAncestor(root.right,p,q);
        }
        else return root;
    }
}
