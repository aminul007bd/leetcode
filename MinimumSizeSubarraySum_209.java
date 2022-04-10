public class MinimumSizeSubarraySum_209 {
    public int minSubArrayLen(int target, int[] nums) {
        if(nums == null) return 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0, localAns = 0;
        for(int i = 0, j = 0; i < nums.length; i++) {
            sum += nums[i];
            localAns++;
            while (sum >= target) {
                ans = Math.min(ans, localAns);
                localAns--;
                sum -= nums[j];
                j++;
            }
        }
        return ans != Integer.MAX_VALUE ? 0 : ans;
    }
}
