import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate_II_219 {
    // problem: checks if an array contains duplicate elements such that the duplicates are at most k indices apart.

   /* Example:
    Input:

    nums = [1, 2, 3, 1], k = 3
    Execution:

    i = 0: set = [1]
    i = 1: set = [1, 2]
    i = 2: set = [1, 2, 3]
    i = 3: nums[3] = 1, set.add(1) returns false (since 1 is already in the set), so the method returns true.
    Output: true
    */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        //A HashSet is created to store the unique elements from the array.
        Set<Integer> set = new HashSet<>();  // A set to keep track of the last 'k' elements.
        for (int i = 0; i < nums.length; i++) {
            //The add() method of the HashSet returns false if the element already exists in the set.
            if (!set.add(nums[i])) {// If we find a duplicate element already in the set, return true immediately.
                return true;
            }
            // Maintain the sliding window of size 'k'. Remove the element that is more than 'k' distance away.
            if (i >= k) {
                set.remove(nums[i - k]);  // Remove the element at index (i - k).
            }
        }
        return false; // If no duplicates are found within 'k' distance, return false.
    }

}
