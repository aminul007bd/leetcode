import java.util.HashMap;

public class TwoNum_1 {

    static int[] twoSumMap(int[] nums, int target) {
        HashMap <Integer, Integer> mapNums = new HashMap<>();

        for(int i = 0; i < nums.length; i ++) {
            // get current value
            // x value
            int x = target - nums[i];
            if(mapNums.containsKey(x)) {
                return new int[] {mapNums.get(x), i};
            }
            mapNums.put(nums[i], i);
        }


        return new int[]{}; // No solution found
    }
}
