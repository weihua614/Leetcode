import java.rmi.MarshalledObject;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class letterCombinations_17 {
    LinkedList<String> result=new LinkedList<>();
    StringBuilder node=new StringBuilder("");
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")) return result;
        HashMap<Character, String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        recall(digits,map,0);
        return result;
    }
    public void recall(String digits,HashMap<Character,String> map,int index)
    {
        if(digits.length()==node.length())
        {
            result.add(node.toString());
            return;
        }
        char[]temp=map.get(digits.charAt(index)).toCharArray();
        for(int i=0;i<temp.length;i++)
        {
            node.append(temp[i]);
            recall(digits,map,index+1);
            node.deleteCharAt(node.length()-1);
        }
    }
}
