/*A peak element is an element that is strictly greater than its neighbors.
Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
You must write an algorithm that runs in O(log n) time.

Example 1:
Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.*/

public class FindPeakElement_162 {
    /*Example Walkthrough: nums = [1, 2, 3, 1]
    Step 1:
    left = 0, right = 3
    Calculate mid = 0 + (3 - 0) / 2 = 1
    nums[1] = 2, nums[2] = 3
    Since nums[1] < nums[2], we are in an ascending part, so move left = mid + 1 = 2.
    Step 2:

    left = 2, right = 3
    Calculate mid = 2 + (3 - 2) / 2 = 2
    nums[2] = 3, nums[3] = 1
    Since nums[2] > nums[3], we are in a descending part, so move right = mid = 2.
    End:

    left = 2, right = 2
    The loop exits, and the peak element is at index 2, which is the value 3.
    Time Complexity:
    O(log n): The algorithm divides the array in half at each step, just like binary search.*/

    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) { // the loop will break when both the index will be on the same posi unlike the traditional BS algo
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) { // case 1: it means nums is in asc order, and we know next ele(mid+1) is greater so move start= mid+1
                left = mid + 1;
            } else { // case 2: it means nums is in desc order, and for desc we dont know that arr[mid]> arr[mid-1] so we cant directly move end to mid-1,
                // there can pe a possibilty that mid is the peak so we are moving end= mid
                right = mid;
            }
        }
        return left; // or return end, at the end both will be pointing to the peak index
    }
}
