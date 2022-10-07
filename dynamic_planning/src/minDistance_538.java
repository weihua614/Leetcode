public class minDistance_538 {//49
    public int minDistance(String word1, String word2) {
        /*
                     etco     leetcode
                     e        01111111
                     et       01122222
                     etc      01123333
                     etco     01123444
         */
        char[] charWord1=word1.toCharArray();
        char[] charWord2=word2.toCharArray();
        int result[][]=new int[word1.length()+1][word2.length()+1];
        //result[0][0]=1;
        for (int i=1;i<word1.length()+1;i++)
        {
            for (int j=1;j<word2.length()+1;j++)
            {
                if (charWord1[i-1]==charWord2[j-1])
                {
                    result[i][j]=Math.max(result[i-1][j-1]+1,result[i][j-1]);
                }
                else
                {
                    result[i][j]=Math.max(result[i-1][j],result[i][j-1]);
                }
            }
        }
        return word1.length()+word2.length()-2*result[word1.length()][word2.length()];
    }
}
