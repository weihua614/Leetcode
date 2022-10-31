package October_2022;

public class buildTree_offer07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return  build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    public TreeNode build(int[] preorder,int preLeft,int preRight, int[] inorder,int inLeft,int inRight) {
        if (preLeft>preRight||inLeft>inRight)
        {
            return null;
        }
        int index=inLeft;
        for (int i=inLeft;i<=inRight;i++)
        {
            if (inorder[i]==preorder[preLeft])
            {
                index=i;
                break;
            }
        }
        int lengthLeft=index-inLeft;
        TreeNode node=new TreeNode(preorder[preLeft]);
        node.left=build(preorder,preLeft+1,preLeft+lengthLeft,inorder,inLeft,index-1);
        node.right=build(preorder,preLeft+lengthLeft+1,preRight,inorder,index+1,inRight);
        return node;
    }
}
