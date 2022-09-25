import java.util.Arrays;

public class decrypt_1652 {
    public int[] decrypt(int[] code, int k) {
        int result[]=new int[code.length];
        int length=code.length;
        if(k==0)
        {
            Arrays.fill(result,0);
            return result;
        }
        if (k>0)
        {
            int temp=0;
            for(int i=0;i<k;i++)
            {
                int j=i;
                if(j>=length) j=j%length;
                temp+=code[j];
            }
            for(int i=0;i<length;i++)
            {
                int m=i+k;
                if(m>=length) m=m%length;
                temp=temp-code[i]+code[m];
                result[i]=temp;
            }
        }
        else
        {
            k=-k;
            int temp=0;
            for(int i=length-1;i>length-k;i--)
            {
                int j=i;
                while (j<0)j=j+length;
                temp+=code[j];
            }
            for(int i=length-1;i>=0;i--)
            {
                int m=i-k;
                while (m<0)m=m+length;
                temp=temp-code[i]+code[m];
                result[i]=temp;
            }
        }
        return result;
    }
}
