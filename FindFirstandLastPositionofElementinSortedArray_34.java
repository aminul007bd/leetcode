/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
*/

public class FindFirstandLastPositionofElementinSortedArray_34 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};  // Step 1: Initialize the result array with [-1, -1] which will be returned if target is not found.

        int left = binarySearch(nums, target, true);  // Step 2: Perform binary search to find the leftmost occurrence of the target.
        int right = binarySearch(nums, target, false);  // Step 3: Perform binary search to find the rightmost occurrence of the target.

        result[0] = left;  // Step 4: Store the leftmost index found in the result.
        result[1] = right;  // Step 5: Store the rightmost index found in the result.

        return result;  // Step 6: Return the result array with the positions of the target in the array.
    }

    private int binarySearch(int[] nums, int target, boolean isSearchingLeft) {
        int left = 0;  // Step 7: Initialize the left pointer to 0 (start of the array).
        int right = nums.length - 1;  // Step 8: Initialize the right pointer to the last index of the array.
        int idx = -1;  // Step 9: Initialize the index variable to -1 (default value in case target is not found).

        while (left <= right) {  // Step 10: Loop until the left pointer crosses the right pointer (standard binary search condition).
            int mid = left + (right - left) / 2;  // Step 11: Calculate the middle index (to prevent overflow).

            if (nums[mid] > target) {  // Step 12: If the middle element is greater than the target, discard the right half.
                right = mid - 1;  // Step 13: Move the right pointer to mid - 1 to search the left half.
            } else if (nums[mid] < target) {  // Step 14: If the middle element is less than the target, discard the left half.
                left = mid + 1;  // Step 15: Move the left pointer to mid + 1 to search the right half.
            } else {  // Step 16: If nums[mid] is equal to target, we've found a match.
                idx = mid;  // Step 17: Store the index of the target in the 'idx' variable.
                if (isSearchingLeft) {  // Step 18: If we are searching for the leftmost occurrence of the target:
                    right = mid - 1;  // Step 19: Move the right pointer to mid - 1 to continue searching on the left side.
                } else {  // Step 20: If we are searching for the rightmost occurrence of the target:
                    left = mid + 1;  // Step 21: Move the left pointer to mid + 1 to continue searching on the right side.
                }
            }
        }

        return idx;  // Step 22: Return the index of the target (or -1 if the target is not found).
    }

}
