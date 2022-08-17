package code;

/**
 * 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
 *
 * 创建一个根节点，其值为 nums 中的最大值。
 * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
 * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
 * 返回 nums 构建的 最大二叉树
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class constructMaximumBinaryTree_654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buid(nums,0,nums.length-1);

    }
    public TreeNode buid(int[]nums,int start,int end)
    {
        if(start>end) return null;
        int maxNum=MaxNum(nums,start,end);
        TreeNode treeNode = new TreeNode(nums[maxNum]);
        treeNode.left=buid(nums,start,maxNum-1);
        treeNode.right=buid(nums,maxNum+1,end);
        return treeNode;
    }
    public int MaxNum(int[]nums,int start,int end)
    {
        int max=Integer.MIN_VALUE;
        int index=0;
        for(int i=start;i<=end;i++)
        {
            if(nums[i]>max)
            {
                max=nums[i];
                index=i;
            }
        }
        return index;
    }
}
