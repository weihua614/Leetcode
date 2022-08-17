package code;

import java.util.LinkedList;

/**
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 *
 * 假设二叉树中至少有一个节点。
 *
 *
 */
public class findBottomLeftValue_513 {
    public int findBottomLeftValue(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        if(root==null) return 0;
        else stack.add(root);
        int result=0;
        while(!stack.isEmpty())
        {
            int size=stack.size();
            result=stack.getFirst().val;
            for(int i=0;i<size;i++)
            {
                TreeNode node=stack.removeFirst();
                if(node.left!=null) stack.add(node.left);
                if(node.right!=null) stack.add(node.right);
            }
        }
        return result;
    }

    int maxLength=0;
    int result;
    public void digui(TreeNode root,int index)
    {
        if(root.left==null&&root.right==null)
        {
            if(index>maxLength)
            {
                result=root.val;
                maxLength=Math.max(maxLength,index);
            }
        }
        if(root.left!=null)
        {
            digui(root.left,index+1);
        }
        if(root.right!=null)
        {
            digui(root.right,index+1);
        }
    }
}
