public class PartitionEqualSubsetSum_416 {
    public boolean canPartition(int[] nums) {
        if(nums.length == 0) return false;
        int totalSum = 0;
        // find sum of all array elements
        for(int i: nums) {
            totalSum += i;
        }
        // if totalSum is odd, it cannot be partitioned into equal sum subset
        if(totalSum % 2 != 0) return false;
        int subSetSum = totalSum / 2;

        // logic
        boolean[] dp = new boolean[subSetSum + 1];
        dp[0] = true;
        for(int curr: nums) {
            for(int j = subSetSum; j >= curr; j--) {
                dp[j] = dp[j] | dp[j - curr];
            }
        }
        return dp[subSetSum];
    }
}
