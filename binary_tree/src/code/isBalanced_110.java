package code;

import org.junit.Test;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1
 */

public class isBalanced_110 {
    public boolean isBalanced(TreeNode root) {
        return isBalanced1(root)!=-1;
    }

    int isBalanced1(TreeNode root) {
        if(root==null) return 0;
        int left=isBalanced1(root.left);
        if(left==-1) return -1;
        int right=isBalanced1(root.right);
        if(right==-1) return -1;
        if(Math.abs(left-right)>2) return -1;
        else
        return Math.max(left,right)+1;
    }

    @Test
    public void test(){
        isBalanced1(null);
    }
}
