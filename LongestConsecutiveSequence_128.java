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
    public static int longestConsecutiveMy(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int result = 1;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i + 1]  == nums[i] + 1) {
                result += 1;
            }
        }
        return result;
    }

    // For O(n)
    public static int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int num: nums)
            numSet.add(num);

        int longestStreak = 0;
        for(int num: nums) {
            if(!numSet.contains(num - 1)){
                int currentStreak = 1;
                int currentNumber = num;
                while (numSet.contains(currentNumber + 1)) {
                    currentNumber += 1;
                    currentNumber += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        var result = longestConsecutiveMy(nums);
        System.out.println(result);
    }
}
