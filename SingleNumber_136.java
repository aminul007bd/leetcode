import java.util.Arrays;
import java.util.HashSet;

public class SingleNumber_136 {
    public static int singleNumber(int[] nums) {

        //Input: nums = [2,2,1]
        //Output: 1
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        for (int i : set) return i;
        return -1;
    }
}
