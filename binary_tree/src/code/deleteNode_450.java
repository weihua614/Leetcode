package code;

public class deleteNode_450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val==key)
        {
            if(root.left==null&&root.right==null)
            {
                return null;
            }
            else if (root.left==null)
            {
                return root.right;
            }
            else if(root.right==null)
            {
                return root.left;
            }
            else
            {
                TreeNode node=root.right;
                while(node.left!=null)
                {
                    node=node.left;
                }
                node.left=root.right;
                return root.right;
            }
        }

            root.left=deleteNode(root.left,key);


            root.right=deleteNode(root.right,key);

        return root;
    }
}
