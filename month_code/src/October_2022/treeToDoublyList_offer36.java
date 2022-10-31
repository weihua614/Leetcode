package October_2022;

public class treeToDoublyList_offer36 {
    Node node;
    Node head;
    public Node treeToDoublyList(Node root) {
        if(root==null) return null;
        recall(root);
        node=head;
        while (node.right!=null)
        {
            node.right.left=node;
            node=node.right;
        }
        node.right=head;
        head.left=node;
        return head;
    }
    public void recall(Node root)
    {
        if (root==null) return;
        recall(root.left);
        if (node==null)
        {
            node=root;
            head=root;
        }
        else
        {
            node.right=root;
            node=node.right;
        }
        recall(root.right);
    }
}
