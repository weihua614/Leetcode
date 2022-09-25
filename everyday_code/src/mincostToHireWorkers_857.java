import org.junit.Test;

import java.util.*;

public class mincostToHireWorkers_857 {
//    ArrayList<Integer> list=new ArrayList<>();
//    double min=Integer.MAX_VALUE;
//    public double mincostToHireWorkers1(int[] quality, int[] wage, int k) {
//        recall(quality,wage,k,0);
//        return min;
//    }
//    public void recall(int[] quality, int[] wage, int k,int index)
//    {
//        if(list.size()>=k)
//        {
//            double temp=getMinSalary(quality,wage);
//            min=temp<min?temp:min;
//            return;
//        }
//        for(int i=index;i<wage.length&&i<wage.length-(k-list.size()-1);i++)
//        {
//            list.add(i);
//            recall(quality,wage,k,i+1);
//            list.remove(list.size()-1);
//        }
//    }
//    public double getMinSalary(int[] quality, int[] wage)
//    {
//        double maxQ=0;
//        int maxIndex=0;
//        for(int i=0;i<list.size();i++)
//        {
//
//            int index=list.get(i);
//            double temp=(double)wage[index]/quality[index];
//            if(temp>maxQ)
//            {
//                maxQ=temp;
//                maxIndex=index;
//            }
//            System.out.println(maxQ);
//        }
//        int maxQuality=quality[maxIndex];
//        int maxWage=wage[maxIndex];
//        System.out.println(maxQuality+":"+maxWage);
//        double sum=0;
//        for(int i=0;i<list.size();i++)
//        {
//            double temp1=quality[list.get(i)];
//            double temp2=wage[list.get(i)];
//            double temp3=(temp1/maxQuality)*maxWage;
//            sum+=temp3;
//        }
//        return sum;
//    }

//    ArrayList<Map.Entry<Integer,Double>> list=new ArrayList<>();
//    double sum=Double.MAX_VALUE;
//    public double mincostToHireWorkers2(int[] quality, int[] wage, int k) {
//        HashMap<Integer,Double> map=new HashMap<>();
//        for(int i=0;i<wage.length;i++)
//        {
//            double temp=(double)wage[i]/quality[i];
//            map.put(i,temp);
//        }
//        List<Map.Entry<Integer,Double>> entries = new ArrayList<>(map.entrySet());
//        System.out.println(entries);
//        Collections.sort(entries, new Comparator<Map.Entry<Integer, Double>>() {
//            @Override
//            public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
//                return o2.getValue()-o1.getValue()>0?1:-1;
//            }
//        });
//        System.out.println(entries);
//        recall(quality,wage,k,0,0,entries);
//        return sum;
//    }
//
//    public void recall(int[] quality, int[] wage, int k,int index,double sumNum,List<Map.Entry<Integer,Double>> entries)
//    {
//        if(list.size()>=k)
//        {
//           // System.out.println(sumNum);
//            if(sum>sumNum) sum=sumNum;
//            return;
//        }
//        for(int i=index;i<wage.length&&i<wage.length-(k-list.size()-1);i++)
//        {
//            list.add(entries.get(i));
//            Integer key = list.get(0).getKey();
//           // System.out.println(key);
//            Integer key1 = entries.get(i).getKey();
//            double temp=(double)quality[key1]/quality[key]*wage[key];
//            sumNum+=temp;
//            //System.out.println(sumNum);
//            recall(quality,wage,k,i+1,sumNum,entries);
//            list.remove(list.size()-1);
//            sumNum-=temp;
//        }
//    }



    ArrayList<Integer> list=new ArrayList<>();
    double sum=Double.MAX_VALUE;
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Integer[] h = new Integer[n];
        for (int i = 0; i < n; i++) {
            h[i] = i;
        }
        Arrays.sort(h, (a, b) -> {
            return -(quality[b] * wage[a] - quality[a] * wage[b]);
        });
        recall(quality,wage,k,0,0,h);
        return sum;
    }

    public void recall(int[] quality, int[] wage, int k,int index,double sumNum,Integer[] h)
    {
        if(list.size()>=k)
        {
            // System.out.println(sumNum);
            if(sum>sumNum) sum=sumNum;
            return;
        }
        for(int i=index;i<wage.length&&i<wage.length-(k-list.size()-1);i++)
        {
            list.add(h[i]);
            Integer key = list.get(0);
            // System.out.println(key);
            Integer key1 = h[i];
            double temp=(double)quality[key1]/quality[key]*wage[key];
            sumNum+=temp;
            //System.out.println(sumNum);
            recall(quality,wage,k,i+1,sumNum,h);
            list.remove(list.size()-1);
            sumNum-=temp;
        }
    }

    @Test
    public void test()
    {
        //recall(new int[]{1,2,3,4,1,2,3},new int[]{1,2,3,4,1,2,3},3,0);
        System.out.println(mincostToHireWorkers(new int[]{4,5}, new int[]{8,14}, 2));
    }
}
