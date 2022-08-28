import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class widthOfBinaryTree_662 {
    public int widthOfBinaryTree1(TreeNode root) {
        if(root==null) return 0;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        int length=DepthTree(root);
//        int result[]=new int[length];
//        result[0]=1;
        int max=1;
        while (length>0)
        {
            int num=stack.size();
            int left=0,right=0;
            boolean flag=true;
            for(int i=0;i<num;i++)
            {
                TreeNode node=stack.removeFirst();
                if(node.val==101)
                {
                    stack.add(new TreeNode(101));
                    stack.add(new TreeNode(101));
                }
                else {
                    if (flag)
                    {
                        left = i;
                        flag=false;
                    }
                    else right = i;
                    if (node.left != null) stack.add(node.left);
                    else stack.add(new TreeNode(101));
                    if (node.right != null) stack.add(node.right);
                    else stack.add(new TreeNode(101));
                }
            }
            length--;
            max=Math.max(right-left+1,max);
            System.out.println(length);
            System.out.println(max);

        }
        return max;

    }

    public int widthOfBinaryTree(TreeNode root) {
        LinkedList<Pair<TreeNode,Integer>> stack=new LinkedList<>();
        if(root==null) return 0;
        stack.add(new Pair<TreeNode,Integer>(root,1));
        int result=0;
        while(!stack.isEmpty())
        {
            int min=Integer.MAX_VALUE;
            int max=Integer.MIN_VALUE;
            int num=stack.size();
            for(int i=0;i<num;i++)
            {
                Pair<TreeNode, Integer> pair = stack.removeFirst();
//                min=Math.min(min,pair.getValue());
//                max=Math.max(max,pair.getValue());
                if(i==0) min=pair.getValue();
                if(i==num-1) max=pair.getValue();
                if(pair.getKey().left!=null) stack.add(new Pair<>(pair.getKey().left,2*pair.getValue()));
                if(pair.getKey().right!=null) stack.add(new Pair<>(pair.getKey().right,2*pair.getValue()+1));
            }
            result=Math.max(result,max-min+1);
        }
        return result;
    }

    int DepthTree(TreeNode node)
    {
        if(node==null) return 0;
        int left=DepthTree(node.left);
        int right=DepthTree(node.right);
        return Math.max(left,right)+1;
    }
    class Solution {
        Map<Integer, Integer> levelMin = new HashMap<Integer, Integer>();

        public int widthOfBinaryTree(TreeNode root) {
            return dfs(root, 1, 1);
        }

        public int dfs(TreeNode node, int depth, int index) {
            if (node == null) {
                return 0;
            }
            levelMin.putIfAbsent(depth, index); // 每一层最先访问到的节点会是最左边的节点，即每一层编号的最小值
            return Math.max(index - levelMin.get(depth) + 1, Math.max(dfs(node.left, depth + 1, index * 2), dfs(node.right, depth + 1, index * 2 + 1)));
        }
    }
}
