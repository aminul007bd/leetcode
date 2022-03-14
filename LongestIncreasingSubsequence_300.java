import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSubsequence_300 {
    // Input: nums = [10,9,2,5,3,7,101,18]
    //Output: 4
    //Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);

        for(int i = 1; i< nums.length; i++) {
            int num = nums[i];
            if(num > sub.get(sub.size() - 1)) {
                sub.add(num);
            } else {
                // Find the first element in sub that is greater than or equal to num
                int j = 0;
                while( num > sub.get(j)) {
                    j += 1;
                }
                sub.set(j, num);
            }
        }

        return sub.size();
    }

    // with dynamic solution
    public int lengthOfLISD(int[] nums) {
       if(nums.length <= 1) return nums.length;
       int[] dp = new int[nums.length];
       Arrays.fill(dp, 1);
        int max = -1;
        for(int i = 1; i< nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
