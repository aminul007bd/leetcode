/*There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
*/

/*Example:
Let's say nums = [4, 5, 6, 7, 0, 1, 2] and target = 0.

Initial Setup:
left = 0, right = 6 (last index of the array)
mid = (0 + 6) / 2 = 3
nums[mid] = 7

First Iteration:
Check if nums[mid] == target: 7 != 0 (not equal)
Check if the left side (nums[0] = 4 to nums[3] = 7) is sorted: yes, it is.
Check if target is within the sorted left side: target = 0, but 4 <= 0 <= 7 is false.
So, move left = mid + 1 = 4 to search the right side.
Second Iteration:

left = 4, right = 6
mid = (4 + 6) / 2 = 5
nums[mid] = 1

Second Iteration (continued):
Check if nums[mid] == target: 1 != 0 (not equal)
Check if the left side (nums[4] = 0 to nums[5] = 1) is sorted: yes, it is.
Check if target is within the sorted left side: target = 0, and 0 <= 0 <= 1 is true.
So, move right = mid - 1 = 4 to search the left side.

Third Iteration:
left = 4, right = 4
mid = (4 + 4) / 2 = 4
nums[mid] = 0
Third Iteration (continued):

nums[mid] == target: 0 == 0, so the target is found at index 4.

Time Complexity:
O(log n): The algorithm divides the array in half during each iteration, leading to logarithmic time complexity, similar to binary search.*/

public class SearchRotatedSortedArray_33 {
    public int search(int[] nums, int target) {
        int left = 0;  // Step 1: Initialize the 'left' pointer to the start of the array (index 0).
        int right = nums.length - 1;// Step 2: Initialize the 'right' pointer to the last element in the array (index nums.length - 1).

        while (left <= right) { // Step 3: Repeat the loop until 'left' crosses 'right' (the search space is valid).
            int mid = (left + right) / 2; // Step 4: Calculate the middle index by averaging 'left' and 'right'.

            if (nums[mid] == target) { // Step 5: Check if the middle element is the 'target'. If true, return 'mid'.
                return mid;
            } else if (nums[mid] >= nums[left]) { // Step 6: Check if the left side (from 'left' to 'mid') is sorted. If true:
                if (nums[left] <= target && target <= nums[mid]) { // Step 7: If the 'target' lies within the sorted left side (between 'nums[left]' and 'nums[mid]'):
                    right = mid - 1;  // Step 8: Narrow the search to the left side by moving 'right' to 'mid - 1'.
                } else {  // Step 9: Otherwise, the 'target' must be in the right half.
                    left = mid + 1; // Step 10: Move the 'left' pointer to 'mid + 1' to search the right half.
                }
            } else {  // Step 11: If the left side is not sorted, the right side (from 'mid' to 'right') must be sorted.
                if (nums[mid] <= target && target <= nums[right]) { // Step 12: If the 'target' lies within the sorted right side:
                    left = mid + 1;  // Step 13: Narrow the search to the right side by moving 'left' to 'mid + 1'.
                } else { // Step 14: Otherwise, the 'target' must be in the left half.
                    right = mid - 1; // Step 15: Move the 'right' pointer to 'mid - 1' to search the left half.
                }
            }
        }

        return -1; // Step 16: If the loop ends without finding the 'target', return -1 (target not found).
    }

}