package October_2022;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class pathSum_offer34 {
    List<List<Integer>> result=new ArrayList<>();
    LinkedList<Integer> list=new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root==null) return result;
        recall(root,target);
        return result;
    }
    public void recall(TreeNode root, int target)
    {
        if (root.left==null&&root.right==null)
        {
            list.add(root.val);
            if (target-root.val==0)
            {
                result.add(new ArrayList<>(list));
            }
            list.removeLast();
            return;
        }
        list.add(root.val);
        // System.out.println(root.val);
        if (root.left!=null)
            recall(root.left,target-root.val);
        if (root.right!=null)
            recall(root.right,target-root.val);
        list.removeLast();
    }
}
