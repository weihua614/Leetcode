public class searchMatrix_240 {
    public boolean searchMatrix1(int[][] matrix, int target) {
        int index1 = matrix.length;
        int index2 = matrix[0].length;
        for (int left=0; left < index1; left++)
        {
            for (int right=0;right<index2;right++)
            {
                if (matrix[left][right]==target)
                {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean searchMatrix2(int[][] matrix, int target) {
        int index1 = matrix.length;
        int index2 = matrix[0].length;
        for (int i=0;i<index1;i++)
        {
            if (target<matrix[i][0]||target>matrix[i][index2-1]) continue;
            int left=0;
            int right=index2-1;
            int mid;
            while (left<=right)
            {
                mid=(left+right)/2;
                if (matrix[i][mid]==target) return true;
                if (matrix[i][mid]<target)
                {
                    left=mid+1;
                }
                else right=mid-1;
            }
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int index1 = matrix.length;
        int index2 = matrix[0].length;
        int left=0;
        int right=index2-1;
        while(left<index1&&right>0)
        {
            if (matrix[left][right]==target) return true;
            if (matrix[left][right]<target)
            {
                left++;
            }
            else
            {
                right--;
            }
        }
        return false;
    }

}
