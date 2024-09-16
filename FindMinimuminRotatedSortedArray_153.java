/*Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example,
the array nums = [0,1,2,4,5,6,7] might become:
[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.



Example 1:
Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.*/

/*
Walkthrough Example:
Let's take an example of a rotated sorted array: nums = [4, 5, 6, 7, 0, 1, 2].

Initial Setup:

left = 0 (points to 4).
right = 6 (points to 2).
The array looks like this: [4, 5, 6, 7, 0, 1, 2].

First Iteration of the Loop:
Calculate mid = left + (right - left) / 2 = 0 + (6 - 0) / 2 = 3.
mid = 3 (points to 7).
Check nums[mid] = 7 and nums[right] = 2.
Since nums[mid] > nums[right] (7 > 2), it means the minimum must be in the right half, so we move the left pointer:
left = mid + 1 = 3 + 1 = 4.
The new search range is: [0, 1, 2] (left points to 0, right still points to 2).

Second Iteration of the Loop:

Calculate mid = left + (right - left) / 2 = 4 + (6 - 4) / 2 = 5.
mid = 5 (points to 1).
Check nums[mid] = 1 and nums[right] = 2.
Since nums[mid] < nums[right] (1 < 2), it means the minimum must be in the left half (including mid), so we move the right pointer:
right = mid = 5.
The new search range is: [0, 1] (left points to 0, right points to 1).

Third Iteration of the Loop:

Calculate mid = left + (right - left) / 2 = 4 + (5 - 4) / 2 = 4.
mid = 4 (points to 0).
Check nums[mid] = 0 and nums[right] = 1.
Since nums[mid] < nums[right] (0 < 1), the minimum is in the left half (including mid), so we move the right pointer:
right = mid = 4.
Now, left = right = 4, and the loop ends.

Result:

The loop ends when left == right.
The minimum element is at nums[left], which is nums[4] = 0.

Key Concepts:
Rotated Sorted Array: This algorithm works specifically for rotated sorted arrays, where part of the array is rotated from a sorted array.
Binary Search: The algorithm uses a modified binary search to find the minimum element.
It compares the middle element (nums[mid]) with the rightmost element (nums[right]) to decide whether to move left or right.
Convergence of left and right: The loop continues until left and right converge on the index of the minimum element.
*/

public class FindMinimuminRotatedSortedArray_153 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;  // Step 1: Initialize pointers 'left' at the start of the array and 'right' at the end.

        while (left < right) {  // Step 2: Continue the loop until 'left' and 'right' converge to the same point (when left == right, we've found the minimum).
            int mid = left + (right - left) / 2;  // Step 3: Calculate the middle index to avoid overflow.

            if (nums[mid] < nums[right]) {  // Step 4: If the middle element is smaller than the rightmost element, the minimum is in the left half (including mid).
                right = mid;  // Step 5: Move 'right' to 'mid' to search the left half.
            } else {  // Step 6: If the middle element is greater than or equal to the rightmost element, the minimum is in the right half.
                left = mid + 1;  // Step 7: Move 'left' to 'mid + 1' to search the right half.
            }
        }

        return nums[left];  // Step 8: Once the loop ends, 'left' and 'right' have converged, and 'nums[left]' will be the minimum element.
    }

}
