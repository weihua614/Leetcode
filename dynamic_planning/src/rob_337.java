import java.util.HashMap;

public class rob_337 {
    public int rob(TreeNode root) {
        HashMap<TreeNode,Integer> map=new HashMap<>();
        return recall(root,map);
    }
    public int  recall(TreeNode node, HashMap<TreeNode,Integer> map)
    {
        if(node==null) return 0;
        if(map.containsKey(node)) return map.get(node);
        int left1=0;
        int right1=0;
        if(node.left!=null)
        {
            left1=recall(node.left.left,map)+recall(node.left.right,map);
        }
        if (node.right!=null)
        {
            right1=recall(node.right.left,map)+recall(node.right.right,map);
        }
        int left2=recall(node.left,map);
        int right2=recall(node.right,map);
        int result=Math.max(node.val+left1+right1,left2+right2);
        map.put(node,result);
        return result;
    }
}
