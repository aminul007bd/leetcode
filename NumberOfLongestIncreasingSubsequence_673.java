import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequence_673 {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if( n <= 0) return 0;
        int[] length = new int[n], count = new int[n];
        Arrays.fill(length, 1);
        Arrays.fill(count, 1);
        int maxLen = 1;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j< i; j++) {
                if(nums[i] > nums[j])
                    if(length[j] + 1 > length[i]) {
                        length[i] =  length[j] + 1;
                        count[i] = count[j];
                    } else if(length[j] + 1 == length[i]) {
                        count[i] += count[j];
                    }
            }
            maxLen = Math.max(maxLen, length[i]);
        }
        int result = 0;
        for(int i = 0; i < n; i++){
            if(length[i] == maxLen)
                result += count[i];
        }

        return result;
    }
}
