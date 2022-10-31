//请实现两个函数，分别用来序列化和反序列化二叉树。 
//
// 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字
//符串反序列化为原始的树结构。 
//
// 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方
//法解决这个问题。 
//
// 
//
// 示例： 
//
// 
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
// 
//
// 
//
// 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-b
//inary-tree/ 
// Related Topics 树 深度优先搜索 广度优先搜索 设计 字符串 二叉树 
// 👍 356 👎 0

package October_2022.cn;
import org.junit.Test;

import java.util.LinkedList;

//Java：序列化二叉树
//2022-10-30 19:25:28
//剑指 Offer 37
    
    
class XuLieHuaErChaShuLcof{
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
public class Codec {
    public int recall(TreeNode root)
    {
        if (root==null) return 0;
        return Math.max(recall(root.left),recall(root.right))+1;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null) return "";
        int maxLenth = recall(root);
        LinkedList<TreeNode> stack=new LinkedList<>();
        stack.addLast(root);
        StringBuffer s=new StringBuffer();
        int depth=0;
        while (!stack.isEmpty())
        {
            int size=stack.size();
            depth++;
            //System.out.println(s);
            for (int i=0;i<size;i++)
            {
                TreeNode last = stack.removeFirst();
                if (last.val==Integer.MAX_VALUE)
                {
                    s.append(",null");
                    if (depth<maxLenth)
                    {
                        stack.addLast(new TreeNode(Integer.MAX_VALUE));
                        stack.addLast(new TreeNode(Integer.MAX_VALUE));

                    }
                }
                else
                {
                    if (s.length()==0) s.append(last.val);
                    else
                    s.append(","+last.val);
                    if (last.left!=null)
                    {
                        stack.addLast(last.left);
                    }
                    else {
                        stack.addLast(new TreeNode(Integer.MAX_VALUE));
                    }
                    if (last.right!=null)
                    {
                        stack.addLast(last.right);
                    }
                    else {
                        stack.addLast(new TreeNode(Integer.MAX_VALUE));
                    }
                }
            }
        }
        System.out.println(s);
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        if (data==null||data.equals(""))return null;
        String[] split = data.split(",");
        if (split[0].equals("null")) return null;
        return buildTree(split,0);
    }
    public TreeNode buildTree(String[] split,int index)
    {
        if (index>=split.length) return null;
       // if (split[index].equals("null")||split[index].equals("")) return null;
        if (split[index].equals("null"))
        {
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(split[index]));
        root.left=buildTree(split,index*2+1);
        root.right=buildTree(split,index*2+2);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void test()
    {
    
    }

    public class Codec1 {
    StringBuffer s=new StringBuffer();

    public void recall1(TreeNode root)
    {
        if (root==null) return;
        if (s.length()==0) s.append(root.val);
        else s.append(","+root.val);
        recall1(root.left);
        recall1(root.right);
    }
        public void recall2(TreeNode root)
        {
            if (root==null) return;

            recall2(root.left);
            if (s.charAt(s.length()-1)==' ') s.append(root.val);
            else s.append(","+root.val);
            recall2(root.right);
        }

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
           recall1(root);
           s.append("  ");
           recall2(root);
           return s.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            System.out.println(data);
            String[] s = data.split("  ");
            String preorder[]=s[0].split(",");
            String inorder[]=s[1].split(",");
            return buildTree1(preorder,0,preorder.length-1,inorder,0, inorder.length-1);
        }

        public TreeNode buildTree1(String[] preorder,int pleft,int pright, String[] inorder,int ileft,int iright) {
            if (pright<pleft||iright<ileft)
            {
                return null;
            }
            int nums=Integer.parseInt(preorder[pleft]);
            int index=-1;
            for (int i=ileft;i<=iright;i++)
            {
                if (Integer.parseInt(inorder[i])==nums)
                {
                    index=i;
                    break;
                }
            }
            int left=index-ileft;
            int right=iright-index;
            TreeNode node = new TreeNode(nums);
            node.left=buildTree1(preorder,pleft+1,pleft+left,inorder,ileft,ileft+left-1);
            node.right=buildTree1(preorder,pright-right+1,pright,inorder,iright-right+1,iright);
            return node;
        }
    }
    
    
}
