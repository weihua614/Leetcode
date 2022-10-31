import org.junit.Test;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.BinaryOperator;

public class Test1 {
    @Test
    public void test(){
        long startTime1 = System.currentTimeMillis();
        ArrayList<Object> list = new ArrayList<Object>();
        final int N = 10000000;
        list.ensureCapacity(N);
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("使用ensureCapacity方法后："+(endTime1 - startTime1));
    }

   ThreadPoolExecutor yt= (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
   @Test
    public void test1(){
      int[]temp=new int[]{1,2,3,4,5};
      Integer i=5;
      yt.execute(()->{
          synchronized (this)
          {
              try {
                  Thread.sleep(5000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              finally {
                  System.out.print("0");
                  System.out.println(System.currentTimeMillis());
              }

          }
      });
       synchronized (this)
       {
           System.out.println(System.currentTimeMillis());
       }
    }
    @Test
    public void TestArrayBlockQueue()
    {
        
    }
}
