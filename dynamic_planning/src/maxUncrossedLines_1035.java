public class maxUncrossedLines_1035 {//45
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        return longestCommonSubsequence(nums1,nums2);
    }
    public int longestCommonSubsequence(int[] text1, int[] text2)
    {
        int result[][]=new int[text1.length+1][text2.length+1];
        for(int i=1;i<=text1.length;i++)
        {
            for (int j=1;j<text2.length+1;j++)
            {
                if (text1[i-1]==text2[j-1])
                {
                    result[i][j]=Math.max(Math.max(result[i-1][j],result[i][j-1]),result[i-1][j-1]+1);
                }
                else
                {
                    result[i][j]=Math.max(result[i-1][j],result[i][j-1]);
                }
            }
        }
        return result[text1.length][text2.length];
    }
}
