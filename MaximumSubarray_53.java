public class MaximumSubarray_53 {

    public static int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for(int i = 1; i < nums.length; i ++) {
            int num = nums[i];
            currentSum = Math.max(num, currentSum + num);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        //Input: nums = [5,4,-1,7,8]
        //Output: 23

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        var result = maxSubArray(nums);
        System.out.println(result);
    }
}
