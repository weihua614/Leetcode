import java.lang.reflect.Array;
import java.util.Arrays;

public class findContentChildren_455 {
    public int findContentChildren1(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gNum = g.length;
        int sNum = s.length;
        int sum = 0;
        for(;gNum>=0&&sNum>=0;gNum--)
        {
            while(sNum>=0&&s[sNum]<g[gNum])
            {
                sNum--;
            }
            if(sNum>=0)
            {
                sum++;
                sNum--;
            }
        }
        return sum;
    }
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gNum = 0;
        int sNum = 0;
        int sum = 0;
        for(;gNum<g.length&&sNum<s.length;gNum++)
        {
            while(sNum<s.length&&g[gNum]>s[sNum])
            {
                sNum++;
            }
            if(sNum<s.length)
            {
                sum++;
                sNum++;
            }
        }
        return sum;
    }
}
