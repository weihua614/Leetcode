public class CheckPermutation {
    //https://leetcode.cn/problems/check-permutation-lcci/
    public boolean CheckPermutation(String s1, String s2) {
        char chars1[]=s1.toCharArray();
        char chars2[]=s2.toCharArray();
        int result[]=new int[26];
        if (chars1.length!=chars2.length) return false;
        for (int i=0;i<chars1.length;i++)
        {
            result[chars1[i]-'a']++;
            result[chars2[i]-'a']--;
        }
        for (int i:result)
        {
            if (i!=0) return false;
        }
        return true;
    }
}
