//给定一棵二叉搜索树，请找出其中第 k 大的节点的值。 
//
// 
//
// 示例 1: 
//
// 
//输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 
//输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 
// 1 ≤ k ≤ 二叉搜索树元素个数 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 341 👎 0

package October_2022.cn;
import org.junit.Test;

//Java：二叉搜索树的第k大节点
//2022-10-30 12:54:13
//剑指 Offer 54
    
    
class ErChaSouSuoShuDeDiKdaJieDianLcof{
   //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int index=0;
    int result=0;
    public int kthLargest(TreeNode root, int k) {
        recall(root,k);
        return result;
    }
    public void recall(TreeNode root, int k)
    {
        if (root==null) return ;
        if (root.right!=null)
        {
            recall(root.right,k);
        }
        index++;
        if (index==k)
        {
            result=root.val;
            return;
        }
        if (root.left!=null)
        {
            recall(root.left,k);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void test()
    {
    
    }
    
    
}
