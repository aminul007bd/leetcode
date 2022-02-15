import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindAllNumbersDisappearedArray_448 {

    //Input: nums = [4,3,2,7,8,2,3,1]
    //Output: [5,6]

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static List<Integer> findDisappearedNumbers (int[] nums) {
        HashMap<Integer, Boolean> mapTable = new HashMap<>();
        for(int i = 0; i< nums.length; i++) {
            mapTable.put(nums[i], true);
        }

        // other approach with O(n) and O(1)
//        for(int i = 0; i< nums.length; i++) {
//            // Treat the value as the new index
//            int newIndex = Math.abs(nums[i]) -1;
//
//            if(nums[newIndex] > 0) {
//                nums [newIndex] *= -1;
//            }
//        }


        List<Integer> output = new ArrayList<>();
        for(int i = 1; i<= nums.length ; i++) {
            if(!mapTable.containsKey(i)) {
                output.add(i);
            }

            // Other approach
//            if(nums[i-1] > 0) {
//                output.add(i);
//            }
        }
        return output;
    }

    public static void main(String[] args) {
        int [] nums = {4,3,2,7,8,2,3,1};

        var result = findDisappearedNumbers(nums);

        System.out.println(result);
    }
}
