public class findLength_718 {//43
    public int findLength1(int[] nums1, int[] nums2) {
        /*
        result[i][j]代表以i-1为尾、j-1为尾最长公共字串
        不以i、j为尾是当i、j为0时实现不太方便；
         */
        int result[][]=new int[nums1.length+1][nums2.length+1];
        int max=0;
        for(int i=1;i<=nums1.length;i++)
        {
            for(int j=1;j<nums2.length+1;j++)
            {
                if(nums1[i-1]==nums2[j-1])
                {
                    result[i][j]=result[i-1][j-1]+1;
                    max=Math.max(max,result[i][j]);
                }
            }
        }
        return max;
    }
//    public int findLength(int[] nums1, int[] nums2) {
//        int result[][]=new int[nums1.length][nums2.length];
//        int max=0;
//        if (nums1[0]==nums2[0])result[0][0]=1;
//        for(int i=0;i<nums1.length;i++)
//        {
//            for(int j=0;j<nums2.length;j++)
//            {
//                if(i==0&&j==0) continue;
//                if(nums1[i]==nums2[j])
//                {
//                    result[i][j]=result[i-1][j-1]+1;
//                    max=Math.max(max,result[i][j]);
//                }
//            }
//        }
//        return max;
//    }
}
