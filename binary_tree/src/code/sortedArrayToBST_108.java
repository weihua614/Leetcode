package code;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 *
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class sortedArrayToBST_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums,0,nums.length-1);
    }
    public TreeNode sortedArrayToBST(int[] nums,int start,int end) {
        if(end>start) return null;
        int mid=start+(end-start)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left=sortedArrayToBST(nums,start,mid-1);
        node.right=sortedArrayToBST(nums,mid+1,end);
        return node;
    }
}
