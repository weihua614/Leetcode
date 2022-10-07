package code;

public class buildTree_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree1(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    public TreeNode buildTree1(int[] preorder,int pleft,int pright, int[] inorder,int ileft,int iright) {
        if (pright<pleft||iright<ileft)
        {
            return null;
        }
        int nums=preorder[pleft];
        int index=-1;
        for (int i=ileft;i<=iright;i++)
        {
            if (inorder[i]==nums)
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
