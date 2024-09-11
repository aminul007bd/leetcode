import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence_128 {
    //Given an unsorted array of integers nums, return the length of the
    // longest consecutive elements sequence.
    //You must write an algorithm that runs in O(n) time.
    //Input: nums = [100,4,200,1,3,2]
    //Output: 4
    //Explanation: The longest consecutive elements sequence is
    // [1, 2, 3, 4]. Therefore its length is 4.

    // O(nlgn)
    // Space O(n)

    /*Example:
    Let’s say num = 1, and numSet = {1, 2, 3, 4, 100, 200}.

            First check:
    num + length = 1 + 1 = 2. Since 2 is in the set, we increment length to 2.
    Second check:
    num + length = 1 + 2 = 3. Since 3 is in the set, we increment length to 3.
    Third check:
    num + length = 1 + 3 = 4. Since 4 is in the set, we increment length to 4.
    Fourth check:
    num + length = 1 + 4 = 5. Since 5 is not in the set, the loop breaks, and the final length of the sequence is 4.
    In this case, the sequence [1, 2, 3, 4] has a length of 4.*/

    public static int longestConsecutiveMy(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int result = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i] + 1) { // this is the main logic
                result += 1;
            }
        }
        return result;
    }

    /*Time complexity: O(n)
    Space complexity: O(n)*/

    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longest = 0;
        for (int num : nums) {
            // When the loop hits num = 1, the condition !numSet.contains(0) is true because 0 is not in the set.
            // This means 1 is the start of a new sequence, so we count how long this sequence goes (1, 2, 3, 4).
            if (!numSet.contains(num - 1)) { //ensures that we only process a number num if it is the first number in a consecutive sequence.
                int length = 1;
                while (numSet.contains(num + length)) { // The contains(num + length) checks whether the value num + length is present in the numSet.
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }

}
