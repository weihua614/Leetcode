//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。 
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 
// 👍 392 👎 0

package November_2022.leetcode.editor.cn;
import org.junit.Test;

import java.util.ArrayList;

//Java：丑数
//2022-11-01 12:46:59
//剑指 Offer 49
    
    
class ChouShuLcof{
   //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //2 3 5
       /*
            2 3 5
            4 3 5
            4 6 5
            8 6 5
            8 6 10
            8 12 10
            16
        */
    public int nthUglyNumber(int n) {
        int result[]=new int[n];
        result[0]=1;
        int indexTwo=0;
        int indexThree=0;
        int indexFive=0;
        for (int i=1;i<n;i++)
        {
            int temp1=result[indexTwo]*2;
            int temp2=result[indexThree]*3;
            int temp3=result[indexFive]*5;
            if (temp1<temp2&&temp1<temp3)
            {
                result[i]=temp1;
                indexTwo++;
            }
            if (temp2<temp1&&temp2<temp3)
            {
                result[i]=temp2;
                indexThree++;
            }
            if (temp3<temp1&&temp3<temp2)
            {
                result[i]=temp3;
                indexFive++;
            }
            if (temp1==temp2&&temp2<temp3)
            {
                result[i]=temp2;
                indexThree++;
                indexTwo++;
            }
            if (temp1==temp3&&temp1<temp2)
            {
                result[i]=temp1;
                indexFive++;
                indexTwo++;
            }
            if (temp2==temp3&&temp2<temp1)
            {
                result[i]=temp2;
                indexFive++;
                indexThree++;
            }
            if (temp3==temp2&&temp2==temp1)
            {
                result[i]=temp2;
                indexFive++;
                indexThree++;
                indexTwo++;
            }

           // System.out.println(result[i]);
        }
        return result[n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


   
  
    
}
//public class P剑指 Offer 49_ChouShuLcof{
//
// @Test
// public void test(){
// }
//}

