public class HouseRobberII_213 {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int max1 = rob_simple(nums, 0, nums.length - 2);
        int max2 = rob_simple(nums, 1, nums.length - 1);
        return Math.max(max1, max2);
    }

    private int rob_simple(int[] nums, int start, int end) {
        int t1 = 0, t2 = 0;
        for(int i = start; i <= end; i++) {
            int temp = t1;
            t1 = Math.max(nums[i] + t2, t1);
            t2 = temp;
        }
        return t1;
    }
}
