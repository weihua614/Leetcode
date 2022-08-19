package code;

import java.util.ArrayList;

/**
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 *
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 *
 * 假定 BST 满足如下定义：
 *
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-mode-in-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class findMode_501 {
    ArrayList<Integer> list=new ArrayList<>();
    TreeNode node;
    int num=0;
    int max=0;
    public int[] findMode(TreeNode root){
        digui(root);
        int result[]=new int[list.size()];
        for(int i=0;i<list.size();i++)
        {
            result[i]=list.get(i);
        }
        return result;
    }
    public void digui(TreeNode root){
        if(root==null) return;
        digui(root.left);
        if(node!=null)
        {
            if(node.val==root.val)
            {
                num++;
            }
            else
            {
                node=root;
                num=1;
            }
            if(num==max)
            {
                list.add(root.val);
            }
            if(num>max)
            {
                max=num;
                list.clear();
                list.add(root.val);
            }
        }
        else
        {
            node=root;
            num=1;
            list.add(root.val);
        }
        digui(root.right);
    }
}
