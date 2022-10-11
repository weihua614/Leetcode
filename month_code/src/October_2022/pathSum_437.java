package October_2022;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class pathSum_437 {
    int sum=0;
    HashSet<TreeNode> nodes=new HashSet<>();
    public int pathSum(TreeNode root, int targetSum) {
        if (root==null )return 0;
        if (root.val==targetSum)sum++;
        recall(root.left,targetSum,root.val);
        recall(root.right,targetSum,root.val);
        return sum;
    }
    public void recall(TreeNode root, int targetSum,double IndexSum)
    {
        if (root==null) return;
        IndexSum+=root.val;
        if (IndexSum==targetSum)
        {
            sum++;
        }
        recall(root.left,targetSum,IndexSum);
        recall(root.right,targetSum,IndexSum);
        if (!nodes.contains(root))
        {
            if (root.val==targetSum)
            {
                sum++;
            }
            recall(root.right,targetSum,root.val);
            recall(root.left,targetSum,root.val);
            nodes.add(root);
        }

    }

    int result=0;
    public int pathSum1(TreeNode root, int targetSum) {
        if (root==null) return 0;
        if (root.left==null&&root.right==null)
        {
            if (root.val==targetSum) return 1;
            else return 0;
        }
        HashMap<Long, Integer> map1 = new HashMap<>();
        map1.put(0L,1);
        recall(root,targetSum,0L,map1);
        return result;
    }
    public void recall(TreeNode root, int targetSum,Long sum,HashMap<Long,Integer> map)
    {
        if (root==null) return;
        sum+=root.val;
        result+=map.getOrDefault(sum-targetSum,0);
        map.put(sum,map.getOrDefault(sum,0)+1);
        recall(root.right,targetSum,sum,map);
        recall(root.left,targetSum,sum,map);
        map.put(sum,map.getOrDefault(sum,0)-1);
    }

    public int pathSum2(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<Long, Integer>();
        prefix.put(0L, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    public int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = 0;
        curr += root.val;

        ret = prefix.getOrDefault(curr - targetSum, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        ret += dfs(root.left, prefix, curr, targetSum);
        ret += dfs(root.right, prefix, curr, targetSum);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

        return ret;
    }

}
