package code;

import java.util.*;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 前序、中序、后序 遍历。
 */

public class preorderTraversal_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        pre(result,root);
        return result;
    }

    //先序遍历
    public void pre(List<Integer> list,TreeNode node)
    {
        if(node==null) return;
        list.add(node.val);
        pre(list,node.left);
        pre(list,node.right);
    }
    //迭代的先序遍历
    public void prediedai(List<Integer> list,TreeNode node)
    {
        LinkedList<TreeNode> stack=new LinkedList<>();
        if(node==null) return ;
        else stack.add(node);
        while(!stack.isEmpty())
        {
            TreeNode treeNode = stack.removeLast();
            list.add(treeNode.val);
            if(treeNode.right!=null) stack.add(treeNode.right);
            if(treeNode.left!=null) stack.add(treeNode.left);
        }
    }
    //迭代的中序遍历   左>中->右
    public void ordiedai(List<Integer> list,TreeNode node)
    {
        LinkedList<TreeNode> stack=new LinkedList<>();
        if(node==null) return ;
        while(node!=null||!stack.isEmpty())
        {
            if(node!=null)
            {
                stack.add(node);
                node=node.left;
            }
            else
            {
                TreeNode last = stack.removeLast();
                list.add(last.val);
                node=last.right;
            }
        }
    }

    //迭代的后序遍历   左>右->中
    public void postdiedai(List<Integer> list,TreeNode node)
    {
        LinkedList<TreeNode> stack=new LinkedList<>();
        if(node==null) return ;
        stack.add(node);
        while(!stack.isEmpty())
        {
            TreeNode treeNode = stack.removeLast();
            list.add(treeNode.val);
            if(treeNode.left!=null) stack.add(treeNode.left);
            if(treeNode.right!=null) stack.add(treeNode.right);
        }
        Collections.reverse(list);
    }

}
