package October_2022;

public class isSubStructure_offer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B==null) return false;
        return dfs(A,B);
    }
    public boolean recall(TreeNode A, TreeNode B)
    {
        if (B==null) return true;
        if (A==null) return false;
        if (A.val==B.val)
        {
            boolean result1=recall(A.left,B.left);
            boolean result2=recall(A.right,B.right);
            return result1&&result2;
        }
        else return false;
    }
    public boolean dfs(TreeNode A, TreeNode B)
    {
        if (A==null) return false;
        boolean result;
        result=recall(A,B);
        if (result) return true;
        boolean result1=dfs(A.left,B);
        boolean result2=dfs(A.right,B);
        return result||result2;
    }
}
