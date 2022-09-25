import java.util.Arrays;

public class maxLengthBetweenEqualCharacters_1642 {
    public int maxLengthBetweenEqualCharacters(String s) {
        int result[]=new int[26];
        Arrays.fill(result,-1);
        int maxIndex=-1;
        char[] chars = s.toCharArray();
        for(int i=0;i<s.length();i++)
        {

            int temp=chars[i]-'a';
            if(result[temp]==-1)
            {
                result[temp]=i;
            }
            else
            {
                maxIndex=Math.max(maxIndex,i-result[temp]-1);
            }
        }
        return maxIndex;
    }
}
