package code;

/**
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历，
 * postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class buildTree_106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
    public TreeNode build(int[] inorder,int inBegin,int inEnd,int[] postorder,int poBegin,int poEnd)
    {

        if(inEnd<inBegin||poEnd<poBegin)
        {
            return null;
        }
        TreeNode treeNode = new TreeNode(postorder[poEnd]);
        int inNum=postorder[poEnd];
        for(int i=inBegin;i<=inEnd;i++)
        {
            if(inorder[i]==inNum)
            {
                inNum=i;
                break;
            }
        }
        int leftNum=inNum-inBegin;
        treeNode.left=build(inorder,inBegin,inNum-1,postorder,poBegin,poBegin+leftNum-1);
        treeNode.right=build(inorder,inNum+1,inEnd,postorder,poBegin+leftNum,poEnd-1);
        return treeNode;
    }
}
