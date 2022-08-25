import java.util.*;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class uniquePaths_62 {
    public int uniquePaths(int m, int n) {
        int[][] result = new int[m][n];
        for(int i=0;i<m;i++)
        {
            result[i][0]=1;
        }
        for(int i=0;i<n;i++)
        {
            result[0][i]=1;
        }
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                result[i][j]=result[i-1][j]+result[i][j-1];
            }
        }
        return result[m-1][n-1];
    }

    public  static void main(String[] arg){
        Scanner in=new Scanner(System.in);
        int n = Integer.valueOf(in.next());
        System.out.println(n);
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            String str1=in.next();
            System.out.println(str1);
            int length1=str1.length();
            for(int j=length1-1;j>=0;j--)
            {
                map.put(str1.charAt(j),map.getOrDefault(str1.charAt(j),0)+(int)Math.pow(10,length1-j-1)*1);
            }
        }


        LinkedList<Map.Entry<Character, Integer>> entries = new LinkedList<>(map.entrySet());
        Collections.sort(entries,new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue()-o1.getValue(); //重写排序规则，小于0表示升序，大于0表示降序
            }
        });
        int sum=0;
        for(int i=9;i>9-entries.size();i--)
        {

            sum+=entries.get(9-i).getValue()*i;
        }
        System.out.println(sum);
    }
}
