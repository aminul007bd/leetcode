import java.util.Arrays;

public class PartitionToKEqualSumSubsets_698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int totalArraySum = 0;
        int n = nums.length;
        for(int num: nums) totalArraySum += num;
        // if total sum is not divisible by k, we can not make subsuts
        if(totalArraySum % k != 0) return false;

        // Sort in decreasing order
        Arrays.sort(nums);
        // Reverse the array
        reverse(nums);

        int targetSum = totalArraySum / k;
        boolean[] taken = new boolean[n];
        return backtrack(nums, 0, 0, 0, k, targetSum, taken);
    }

    private void reverse(int[] nums) {
        for(int i = 0, j = nums.length - 1; i < j; i++, j--){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    private boolean backtrack(int[] nums, int index, int count, int currSum, int k, int targetSum, boolean[] taken) {
        int n = nums.length;
        // we made k - 1 subsets with target sum and last subset will also have target sum.
        if(count == k - 1) return true;

        // No need to proceed further
        if(currSum > targetSum) return false;

        // when curr sum reaches target then one subset is made.
        // Increment count and reset current sum.
        if(currSum == targetSum) {
            return backtrack(nums, 0, count + 1, 0, k, targetSum, taken);
        }

        // try not picked elements to make some combinations.
        for(int j = index; j < n; j++) {
            if(!taken[j]){
                // Include this element in current subset.
                taken[j] = true;

                // if using current jth element in this subset leads to make all valid subsets.
                if(backtrack(nums, j + 1, count, currSum + nums[j], k, targetSum, taken)) {
                    return true;
                }
                // Backtrack step.
                taken[j] = false;
            }
        }

        // we were not able to make a valid combination after picking each element from the array,
        // hence we can't make k subsets.
        return false;
    }
}













