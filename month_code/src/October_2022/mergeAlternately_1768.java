package October_2022;

public class mergeAlternately_1768 {
    public String mergeAlternately(String word1, String word2) {
        StringBuffer result=new StringBuffer(word1.length()+word2.length());
        int index=Math.min(word1.length(),word2.length());
        for (int i=0;i<index;i++)
        {
            result.append(word1.charAt(i));
            result.append(word2.charAt(i));
        }
        int maxIndex=Math.max(word1.length(),word2.length());
        if (maxIndex==word2.length())
        {
            word1=word2;
        }
        for (int i=index;i<maxIndex;i++)
        {
            result.append(word1.charAt(i));
        }
        return result.toString();
    }
}
