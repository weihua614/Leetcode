//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 数组 回溯 矩阵 
// 👍 694 👎 0


package leetcode.editor.cn;



//Java：矩阵中的路径
//2022-10-29 21:02:33
//剑指 Offer 12
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i=0;i<board.length;i++)
        {
            for (int j=0;j<board[0].length;j++)
            {
                if (recall(board,word,i,j,0,new boolean[board.length][board[0].length]))
                    return true;
            }
        }
        return false;
    }
    public boolean recall(char[][] board, String word,int left,int right,int index,boolean [][]flag)
    {
        if (index>=word.length()) return true;
        if (left>=board.length||left<0||right>=board[0].length||right<0||flag[left][right]) return false;
        if (word.charAt(index)!=board[left][right]) return false;
        flag[left][right]=true;
        boolean result1 = recall(board, word, left + 1, right, index + 1, flag);
        boolean result2 = recall(board, word, left - 1, right, index + 1, flag);
        boolean result3 = recall(board, word, left , right+1, index + 1, flag);
        boolean result4 = recall(board, word, left , right-1, index + 1, flag);
        if (result1||result2||result3||result4)
        {
            return true;
        }
        flag[left][right]=false;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
