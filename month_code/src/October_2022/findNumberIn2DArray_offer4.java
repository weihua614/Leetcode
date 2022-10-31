package October_2022;

import java.util.ArrayList;

public class findNumberIn2DArray_offer4 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix==null||matrix.length==0||matrix[0]==null) return false;
        int left=0;
        int right=matrix[0].length-1;
        while (left<matrix.length&&right>=0)
        {
            if (matrix[left][right]==target)
                return true;
            if (matrix[left][right]>target)
            {
                right--;
            }
            else
                left++;
        }
        return false;


    }
}
