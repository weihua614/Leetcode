public class constructArray_667 {
    public int[] constructArray(int n, int k) {
        int result[]=new int[n];
        if(k==1)
        {
            for(int i=0;i<n;i++)
            {
                result[i]=i+1;
            }
            return result;
        }
        else if (k==n-1)
        {
            for(int i=0;i<n/2;i++)
            {
                result[i*2]=i+1;
                result[i*2+1]=n-i;
            }
            if(n%2==1) result[n]=n/2+1;
            return result;
        }
        else
        {
            for(int i=0;i<n-k-1;i++)
            {
                result[i]=i+1;
            }

            for(int i=n-k-1;i<n;i++)
            {
                result[i]=(i-n+k+1)/2+n-k;
                if(i+1<n)
                result[i+1]=n-(i-(i-n+k+1)/2);
                i++;
            }
            if((n-k)%2==1) result[n-1]=(n+n-k)/2;
            return result;
        }

    }
}
