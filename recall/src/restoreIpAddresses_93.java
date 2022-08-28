import java.util.ArrayList;
import java.util.List;

/**
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class restoreIpAddresses_93 {
    List<String> result=new ArrayList<>();
    StringBuilder ip=new StringBuilder();
    public List<String> restoreIpAddresses(String s) {
        recall(s,0,0);
        return result;
    }
    public void recall(String s,int start,int index)
    {
        if(index==3)
        {
            if(isVa(s,start,s.length()-1))
            {
                String temp=s.substring(start,s.length());
                StringBuffer stringBuffer = new StringBuffer(ip);
                stringBuffer.append(temp);
                result.add(stringBuffer.toString());
            }
        }
        for(int i=start;i<start+3&&i<s.length();i++)
        {
            if(isVa(s,start,i))
            {
                String temp=s.substring(start,i+1);
                ip.append(temp).append('.');
                recall(s,i+1,index+1);
                ip.delete(ip.length()-temp.length(),ip.length());
            }
        }
    }
    public boolean isVa(String s,int start,int end)
    {
        if(start>end) return false;
        if(end-start>0&&s.charAt(start)=='0') return false;
        if(end-start<3)
        {
            if(Integer.valueOf(s.substring(start,end+1))<=255)
            {
                return true;
            }
            else
                return false;
        }
        else return false;
    }

    public static void main(String[] args) {
        restoreIpAddresses_93 a=new restoreIpAddresses_93();
        System.out.println(a.isVa("11111", 0, 4));
        StringBuilder b=new StringBuilder("abcded");
        b.append("qq.");
        b.delete(b.length()-2-1,b.length());
        System.out.println(b);
    }


}
