package code;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class isValidBST_98 {
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        return pre(list,root);

    }
    public boolean pre(List<Integer> list, TreeNode node)
    {
        if(node==null) return true;
        boolean pre1 =pre(list,node.left);
        if(!pre1) return false;
        list.add(node.val);
        if(list.size()>1&&list.get(list.size()-1)<=list.get(list.size()-2))
        {
            return false;
        }
        boolean pre2 = pre(list, node.right);
        return pre2;
    }
}
