package October_2022;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class distinctSubseqII_940 {
    /*
    abc   a
          b ab
          c ac bc abc
    abcc  a
          b ab
          c ac bc abc
          cc acc bcc abcc
    abcd  a 1
          b ab 2
          c ac bc abc 4
          d ad bd cd abd acd bcd abcd 8
    abcb
       a   a
       ab   b ab
       abc   c ac bc abc       13 - 7  6
       abcb 8 2 1   cb bb abb acb bcb abcb

    aaa   a
          aa
          aaa 4 2 1
    zzc   z
          zz
          c zc zzc  4
    zzcc
          z
          zz
          c zc zzc  8
          cc zcc zzcc
    zzcac
          z
          zz
          c zc zzc
          a za ca zza zca zzca
          ac cc zcc cac zzcc zzac
     */
    public int distinctSubseqII(String s) {
        char[] chars = s.toCharArray();
        int mod=1000000007;
        int length = s.length();
        int result[]=new int[chars.length];
        int index[]=new int[26];
        Arrays.fill(index,-1);
        Arrays.fill(result,1);
        result[0]=1;
        index[chars[0]-'a']=0;
        for (int i=1;i<length;i++)
        {
            for (int j=0;j<i;j++)
            {
                if (index[chars[j]-'a']==j)
                {
                    result[i]=(result[j]+result[i])&mod;
                }
            }
            index[chars[i]-'a']=i;
        }
        int sum=0;
        for (int i=0;i<length;i++)
        {
            if (index[chars[i]-'a']==i)
            {
                sum=(sum+result[i])&mod;
            }
        }
        return sum;
    }


    public int distinctSubseqII3(String s) {
        final int MOD = 1000000007;
        int[] last = new int[26];
        Arrays.fill(last, -1);
        int n = s.length();
        int[] f = new int[n];
        Arrays.fill(f, 1);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < 26; ++j) {
                if (last[j] != -1) {
                    f[i] = (f[i] + f[last[j]]) % MOD;
                }
            }
            last[s.charAt(i) - 'a'] = i;
        }
        int ans = 0;
        for (int i = 0; i < 26; ++i) {
            if (last[i] != -1) {
                ans = (ans + f[last[i]]) % MOD;
            }
        }
        return ans;
    }

    @Test
    public void test()
    {
        distinctSubseqII("abc");
       // System.out.println("aaa".substring(0,0).equals(""));
    }
}
