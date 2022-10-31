//给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。 
//
// 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "a1b2"
//输出：["a1b2", "a1B2", "A1b2", "A1B2"]
// 
//
// 示例 2: 
//
// 
//输入: s = "3z4"
//输出: ["3z4","3Z4"]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 12 
// s 由小写英文字母、大写英文字母和数字组成 
// 
// Related Topics 位运算 字符串 回溯 
// 👍 429 👎 0

package leetcode.editor.cn;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//Java：字母大小写全排列
//2022-10-30 08:44:01
//784
    
    
class LetterCasePermutation{
   //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    ArrayList<String> result=new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
         s = s.toLowerCase();
         recall(s.toCharArray(),0);
         return result;
    }
    public void recall(char[] s,int index)
    {
        if (index==s.length)
        {
            result.add(new String(s));
            return ;
        }
        else
        {
            //A 65 Z90 a97 z122
            if (s[index]<='z'&&s[index]>='a')
            {
                recall(s,index+1);
                s[index]=(char)(s[index]-32);
                recall(s,index+1);
                s[index]=(char)(s[index]+32);
            }
            else recall(s,index+1);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        String s="Aaa451";
        s=s.toLowerCase();
        System.out.println(s);
    }


    
    
}
