import java.util.HashMap;

public class TwoNumSolution {
    static int[] twoSum( int[] nums, int target) {
        for(int i = 0; i < nums.length - 1; i ++) {
            for(int j = i ; j < nums.length; j++ ) {
                return new int[] { i, j };
            }
        }
        return null;
    }

    static int[] twoSumMap(int[] nums, int target) {
        HashMap <Integer, Integer> mapNums = new HashMap<>();

        for(int i = 0; i < nums.length; i ++) {
            // get current value
            // x value
            int x = target - nums[i];
            if(mapNums.containsKey(x)) {
                return new int[] {mapNums.get(x), i};
            }
            mapNums.put(x, i);
        }


        return null;
    }

    public static void main (String args []) {
        int [] a = {1 , 4 , 5 , 11 , 12};
        int target = 9;
        System.out.println(" I am printing: " + twoSum(a, target));
    }
}
