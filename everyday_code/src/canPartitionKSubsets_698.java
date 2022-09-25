import org.junit.Test;

import java.util.Arrays;

public class canPartitionKSubsets_698 {
    int[] nums;
    int per, n;
    boolean[] dp;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        this.nums = nums;
        int all = Arrays.stream(nums).sum();
        if (all % k != 0) {
            return false;
        }
        per = all / k;
        Arrays.sort(nums);
        n = nums.length;
        if (nums[n - 1] > per) {
            return false;
        }

        dp = new boolean[1 << n];
        Arrays.fill(dp, true);
        return dfs((1 << n) - 1, 0);
    }

    public boolean dfs(int s, int p) {
        if (s == 0) {
            return true;
        }
        if (!dp[s]) {
            return dp[s];
        }
        dp[s] = false;
        for (int i = 0; i < n; i++) {
            if (nums[i] + p > per) {
                break;
            }
            if (((s >> i) & 1) != 0) {
                if (dfs(s ^ (1 << i), (p + nums[i]) % per)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canPartitionKSubsets1(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];
        if (sum % k != 0) return false;
        int target = sum / k;
        // 排序优化
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        return backtrack(nums, 0, new int[k], k, target);
    }
    private boolean backtrack(int[] nums, int index, int[] bucket, int k, int target) {
        // 结束条件优化
        if (index == nums.length) return true;
        for (int i = 0; i < k; i++) {
            // 优化点二
            if (i > 0 && bucket[i] == bucket[i - 1]) continue;
            // 剪枝
            if (bucket[i] + nums[index] > target) continue;
            bucket[i] += nums[index];
            if (backtrack(nums, index + 1, bucket, k, target)) return true;
            bucket[i] -= nums[index];
        }
        return false;
    }

    @Test
    public void test()
    {
        System.out.println(canPartitionKSubsets(new int[]{2,2,2,2,3,4,5}, 4));
    }
}
