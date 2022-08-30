import org.junit.Test;

public class numTrees_96 {
    public int numTrees(int n) {
        int result[]=new int[n+1];
        result[0]=1;
        result[1]=1;
        for(int i=2;i<=n;i++)
        {
            int sum=0;
            for(int j=1;j<=i;j++)
            {
                int left=j-1;
                int right=i-j;
                sum+=result[left]*result[right];
            }
            result[i]=sum;
        }
        return result[n];
    }
    @Test
    public void test(){
        numTrees(3);
    }
}
