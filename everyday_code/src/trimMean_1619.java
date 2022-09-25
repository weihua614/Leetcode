import java.util.Arrays;

public class trimMean_1619 {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int num=(int)(arr.length*0.05);
        double sum=0;
        for(int i=num;i<arr.length-num;i++)
        {
            sum+=arr[i];
        }
        return sum/(arr.length-2*num);
    }

}
