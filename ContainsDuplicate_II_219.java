import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate_II_219 {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
       // Input: nums = [1,2,3,1], k = 3
        //Output: true
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i ++ ) {
            if(!set.add(nums[i])) {
                return true;
            }
            if(set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [] nums = { 1,2,3,1,2,3};

        var result = containsNearbyDuplicate(nums, 2);

        System.out.println(result);
    }
}
