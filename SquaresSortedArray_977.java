import java.util.ArrayList;
import java.util.Arrays;

public class SquaresSortedArray_977 {
    public static int[] sortedSquares(int[] nums) {
        // square the numbers
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length ; i ++) {
            result[i] = nums[i] * nums[i];
        }
        Arrays.sort(result);
        return result;
    }
    // Two pointer Approach
    public static int[] sortedSquaresTwo(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        // pointers for left and right
        int left = 0, right = n - 1;
        // iterate from n to 0
        for(int i = n - 1; i >= 0; i--) {
            // check if abs left is less than or equal to abs right
            if(Math.abs(nums[left]) >= Math.abs(nums[right])) {
                // add left square to the result array
                result[i] = nums[left] * nums[left];
                left++;
            } else {
                result[i] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int [] nums = {-4,-1,0,3,10};
        // Output: [0,1,9,16,100]
        var output = sortedSquaresTwo(nums);
        System.out.println(Arrays.toString(output));
    }
}
