/**
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 *
 * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
 *
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/ones-and-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class findMaxForm_474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int result[][]=new int[m+1][n+1];
        for(int i=0;i<strs.length;i++)
        {
            int []zero=countZeroAndOne(strs[i]);
            System.out.println(zero[0]);
            System.out.println(zero[1]);
            for(int j=m;j>=zero[0];j--)
            {
                for(int k=n;k>=zero[1];k--)
                {
                    result[j][k]=Math.max(result[j][k],result[j-zero[0]][k-zero[1]]+1);
                    System.out.println(result[j][k]);
                }
                System.out.println();
            }
        }
        return result[m][n];
    }
    public int[] countZeroAndOne(String str)
    {
        int count[]=new int[1];
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)==0) count[0]++;
            else
                 count[1]++;
        }
        return count;
    }
}
