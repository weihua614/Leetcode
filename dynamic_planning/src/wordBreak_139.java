import java.util.List;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 *
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class wordBreak_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean result[]=new boolean[s.length()+1];
        result[0]=true;
        char str[]=s.toCharArray();
        for(int i=0;i<s.length();i++)
        {
            for(int j=0;j<wordDict.size();j++)
            {
                if(wordDict.get(j).length()>i+1)
                    continue;
                String temp1=new String(str,i-wordDict.get(j).length()+1,wordDict.get(j).length());
                if(temp1.equals(wordDict.get(j)))
                {
                    result[i+1]=result[i+2-wordDict.get(j).length()];
                    if(result[i+1]) break;
                }
            }
            System.out.println(i+":"+result[i+1]);
        }
        return result[s.length()];
    }
}
