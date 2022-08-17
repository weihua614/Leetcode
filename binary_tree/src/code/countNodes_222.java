package code;

import java.util.LinkedList;

/**
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 *
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/count-complete-tree-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class countNodes_222 {

    //层次遍历查询结点个数
    public int countNodes(TreeNode root) {
        int result=0;
        if(root==null) return result;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty())
        {
            int temp=stack.size();
            result=temp+result;
            for(int i=0;i<temp;i++)
            {
                TreeNode node=stack.removeLast();
                if(node.left!=null) stack.add(node.left);
                if(node.right!=null) stack.add(node.right);
            }
        }
        return result;
    }

    //递归遍历查询结点个数
    public int countNodes1(TreeNode root) {
        if(root==null) return 0;
        int left=countNodes1(root.left);
        int right=countNodes1(root.right);
        return left+right+1;
    }
}
