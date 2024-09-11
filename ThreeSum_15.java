/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {
    /*Processing with Outer Loop:

    For i = 0 (nums[i] = -4):

    j = 1, k = 5.
    Compute total = -4 + (-1) + 2 = -3. Since total < 0, increment j to 2.
    Compute total = -4 + (-1) + 2 = -3. Still < 0, increment j to 3.
    Compute total = -4 + 0 + 2 = -2. Still < 0, increment j to 4.
    Compute total = -4 + 1 + 2 = -1. Still < 0, increment j to 5.
    j equals k, exit while loop.
            For i = 1 (nums[i] = -1):

    j = 2, k = 5.
    Compute total = -1 + (-1) + 2 = 0. Valid triplet [-1, -1, 2]. Add it to res.
    Move j to 3. Skip over duplicate nums[j].
    Compute total = -1 + 0 + 1 = 0. Valid triplet [-1, 0, 1]. Add it to res.
    Move j to 4. j equals k, exit while loop.
            For i = 2 (nums[i] = -1): Skip because it's a duplicate of nums[i - 1].

    For i = 3 (nums[i] = 0):

    j = 4, k = 5.
    Compute total = 0 + 1 + 2 = 3. Since total > 0, decrement k.
    j equals k, exit while loop.
            For i = 4 and i = 5: Skip as there are no valid pairs left.
    */

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) { //skips duplicate elements to avoid processing the same triplet multiple times
                continue;
            }
            int j = i + 1; //starts just after i (i + 1).
            int k = nums.length - 1; // k starts from the end of the array
            while (j < k) {
                int total = nums[i] + nums[j] + nums[k];

                if (total > 0) {
                    k--;
                } else if (total < 0) {
                    j++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k])); // Add the Triplet to the Result List
                    j++;

                    while (nums[j] == nums[j - 1] && j < k) { //skips over any duplicate elements for nums[j] to avoid adding duplicate triplets.
                        j++;
                    }
                }
            }
        }
        return res;
    }
}
