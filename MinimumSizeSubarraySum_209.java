/*Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray
whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

Example 1:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.*/

/*Intuition
Use two pointers: Left & Right
Move right pointer and add nums[right] if sum < target
Move left pointer and substract nums[left] if sum >= target

Approach
Initial variables:
n : length of input nums
minLength : to update the minimum length of valid subarray
sum : to record the current sum of subarray
left, right : two pointers
Compare the value of sum and the value of target:
When sum < target:
We need to add more elements one by one on the right side (increase the length of the subarray), so that the sum can be closer to the target.

When sum >= target:
We need to substract more elements one by one on the left side (decrease the length of the subarray), so that the sum can be closer to the target.
Return answer:
If minLength == Integer.MAX_VALUE, it means there is not a valid subarray's sum equal to target. Return 0.
If minLength != Integer.MAX_VALUE, we found the satisfied subarray, return minLength.

Complexity
Time complexity:O(n)
n is the length of nums
Space complexity:O(1)*/

/*Example walkthrough:
Example: target = 7, nums = [2, 3, 1, 2, 4, 3]
Initial state:

minLength = Integer.MAX_VALUE, sum = 0, left = 0.
Right = 0 (nums[0] = 2):

sum = 2
sum < target, so continue expanding the window.
        Right = 1 (nums[1] = 3):

sum = 2 + 3 = 5
sum < target, so continue expanding the window.
        Right = 2 (nums[2] = 1):

sum = 5 + 1 = 6
sum < target, so continue expanding the window.
        Right = 3 (nums[3] = 2):

sum = 6 + 2 = 8
Now sum >= target, so we enter the while loop:
Window: [2, 3, 1, 2]
minLength = Math.min(Integer.MAX_VALUE, 4) = 4
Shrink window: sum -= nums[left] = 8 - 2 = 6
Move left = 1.
Right = 3, Left = 1 (sum = 6):

sum < target, so exit the while loop.
        Right = 4 (nums[4] = 4):

sum = 6 + 4 = 10
Now sum >= target, enter the while loop:
Window: [3, 1, 2, 4]
minLength = Math.min(4, 4) = 4
Shrink window: sum -= nums[left] = 10 - 3 = 7
Move left = 2.
Still sum >= target, so:
Window: [1, 2, 4]
minLength = Math.min(4, 3) = 3
Shrink window: sum -= nums[left] = 7 - 1 = 6
Move left = 3.
Right = 4, Left = 3 (sum = 6):

sum < target, so exit the while loop.
        Right = 5 (nums[5] = 3):

sum = 6 + 3 = 9
Now sum >= target, enter the while loop:
Window: [2, 4, 3]
minLength = Math.min(3, 3) = 3
Shrink window: sum -= nums[left] = 9 - 2 = 7
Move left = 4.
Still sum >= target, so:
Window: [4, 3]
minLength = Math.min(3, 2) = 2
Shrink window: sum -= nums[left] = 7 - 4 = 3
Move left = 5.
Right = 5, Left = 5 (sum = 3):

sum < target, exit the while loop.
Final result: minLength = 2. The smallest subarray with a sum >= 7 is [4, 3].*/

public class MinimumSizeSubarraySum_209 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;

        for (int right = 0; right < n; right++) { //This starts a loop that moves the right pointer from the beginning to the end of the nums array, expanding the window.
            sum += nums[right];

            while (sum >= target) { //This checks if the sum of the current window (sum) is greater than or equal to the target. If so, the inner while loop starts.
                minLength = Math.min(minLength, right - left + 1); //This calculates the length of the current subarray (right - left + 1) and updates minLength to the smaller of the current minimum and the new subarray length.
                sum -= nums[left];
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
