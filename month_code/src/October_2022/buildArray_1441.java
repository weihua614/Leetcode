package October_2022;

import java.util.ArrayList;
import java.util.List;

public class buildArray_1441 {
    public static void na()
    {
        System.out.println("静态");
    }
    public List<String> buildArray(int[] target, int n) {
        int length = target.length;
        ArrayList<String> strings = new ArrayList<>(length);
        String Push="Push";
        String Pop="Pop";
        int index=0;
        for (int i=1;i<=n;i++)
        {
            if (index>=length)
            {
                break;
            }
            if (i==target[index])
            {
                strings.add(Push);
                index++;
            }
            else
            {
                strings.add(Push);
                strings.add(Pop);
            }
        }
        return strings;
    }

    public static void main(String[] args) {
        buildArray_1441 a=new buildArray_1441();
        a.notifyAll();
    }
}
