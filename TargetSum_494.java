import java.util.Arrays;

public class TargetSum_494 {
    // Recursion with Memoization
    int total;
    public int findTargetSumWays(int[] nums, int target) {
        total = Arrays.stream(nums).sum();
        int[][] memo = new int[nums.length][ 2 * total + 1];
        for(int[] row: memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return calculate(nums, 0, 0, target, memo);
    }

    private int calculate(int[] nums, int i, int sum, int target, int[][] memo) {
        if(i == nums.length) {
            return sum == target ? 1 : 0;
        }
        if(memo[i][sum + total] != Integer.MIN_VALUE) return memo[i][sum + total];
        int add = calculate(nums, i + 1, sum + nums[i], target, memo);
        int subtract = calculate(nums, i + 1, sum - nums[i], target, memo);
        memo[i][sum + total] = add + subtract;
        return memo[i][sum + total];
    }

    // Need to understand later
    public int findTargetSumWaysV2(int[] nums, int target) {
        int total = Arrays.stream(nums).sum();
        int[][] dp = new int[nums.length][2 * total + 1];
        dp[0][nums[0] + total] = 1;
        dp[0][-nums[0] + total] += 1;

        for(int i = 0; i< nums.length; i++) {
            for(int sum = -total; sum <= total; sum++) {
                if(dp[i - 1][sum + total] > 0) {
                    dp[i][sum + nums[i] + total] += dp[i - 1][sum + total];
                    dp[i][sum - nums[i] + total] += dp[i - 1][sum + total];
                }
            }
        }
        return Math.abs(target) > total ? 0 : dp[nums.length - 1][target + total];
    }
}
