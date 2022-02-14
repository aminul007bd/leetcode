import java.util.ArrayList;
import java.util.Arrays;

public class ContainsDuplicate217 {

    public boolean containsDuplicate(int[] nums) {
        // first with O(n2)
        for( int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] == nums[i]) return true;
            }
        }

        // second approach O(nlogn)
        Arrays.sort(nums);
        for( int i = 0; i< nums.length - 1; i++){
            if(nums[i] == nums[i =1]) return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
