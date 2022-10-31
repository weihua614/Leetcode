//把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。 
//
// 
//
// 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。 
//
// 
//
// 示例 1: 
//
// 输入: 1
//输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
// 
//
// 示例 2: 
//
// 输入: 2
//输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0
//.05556,0.02778] 
//
// 
//
// 限制： 
//
// 1 <= n <= 11 
// Related Topics 数学 动态规划 概率与统计 
// 👍 492 👎 0

package leetcode.editor.cn;
import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayList;

//Java：n个骰子的点数
//2022-10-31 18:30:34
//剑指 Offer 60
    
    
class NgeTouZiDeDianShuLcof{
   //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double[] dicesProbability(int n) {
        double sum=Math.pow(6,n);
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        list.add(new ArrayList<>());
        list.get(0).add(1);
        list.get(0).add(1);
        list.get(0).add(1);
        list.get(0).add(1);
        list.get(0).add(1);
        list.get(0).add(1);
        int index=2;
        while (index<=n)
        {
            ArrayList<Integer> objects = new ArrayList<>();
            ArrayList<Integer> list1 = list.get(index - 2);
            objects.add(1);
            for (int i=1;i<list1.size();i++)
            {
                if (i<=5)
                objects.add(objects.get(i-1)+list1.get(i));
                else
                    objects.add(objects.get(i-1)+list1.get(i)-list1.get(i-6));
            }
            int temp=objects.size()-2;
            for (int j=5;j>=0;j--)
            {
                objects.add(objects.get(j));
            }
            list.add(objects);
            index++;
        }
        double[]result=new double[5*n+1];
        ArrayList<Integer> list1 = list.get(list.size() - 1);
        //System.out.println(list1);
        for (int i=0;i<result.length;i++)
        {
            result[i]=list1.get(i)/sum;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void test()
    {
    
    }
    
    
}
