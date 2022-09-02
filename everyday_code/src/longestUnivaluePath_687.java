/**
 * 给定一个二叉树的 root ，返回 最长的路径的长度 ，这个路径中的 每个节点具有相同值 。 这条路径可以经过也可以不经过根节点。
 *
 * 两个节点之间的路径长度 由它们之间的边数表示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-univalue-path
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class longestUnivaluePath_687 {
    int max=0;
    public int longestUnivaluePath(TreeNode root) {
        qianxu(root);
        return max;
    }
    public void qianxu(TreeNode root)
    {
        if(root==null) return ;
        int left=digui(root.left,root.val);
        int right=digui(root.right,root.val);
        max=Math.max(left+right,max);
        qianxu(root.left);
        qianxu(root.right);
    }
    public int digui(TreeNode root,int val)
    {
        if(root==null) return 0;

        if(root.val==val)
        {
            int left=digui(root.left,val);
            int right=digui(root.right,val);
            return Math.max(left,right)+1;
        }
        else return 0;
    }
}
