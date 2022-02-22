public class BinarySearch_704 {

    // time complexity O(n)
    public static int searchV1(int[] nums, int target) {
        for(int i = 0; i< nums.length; i ++) {
            if(nums[i] == target) return i;
        }
        return -1;
    }
    // using binary search algorithm
    // time complexity n(log n)
    public static int search(int[] nums, int target) {
        int left = 0, middle = 0;
        int right = nums.length - 1;
        while (left <= right) {
            middle = (left + right) / 2;
            if(target < nums[middle]) right = middle -1;
            if(target > nums[middle]) left = middle + 1;
            if(target == nums[middle]) return middle;
        }
        return -1;
    }

    public static void main(String[] args) {
        //Input: nums = [-1,0,3,5,9,12], target = 9
        //Output: 4
        //Explanation: 9 exists in nums and its index is 4

        int[] nums = {-1,0,3,5,9,12};

        var result = search(nums, 3);

        System.out.println(result);
    }
}
