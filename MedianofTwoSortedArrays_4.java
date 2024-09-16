/*Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.*/

public class MedianofTwoSortedArrays_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;  // Step 1: Get the lengths of both arrays.
        // Ensure nums1 is the smaller array for simplicity
        if (n1 > n2)
            return findMedianSortedArrays(nums2, nums1);  // Step 2: Ensure nums1 is the smaller array to reduce complexity.
        int n = n1 + n2;  // Step 3: Calculate the total number of elements from both arrays.
        int left = (n + 1) / 2;  // Step 4: Calculate the size of the left partition (rounded up if odd total).
        int start = 0, end = n1;  // Step 5: Set the initial binary search range on nums1.
        // Binary search begins on nums1
        while (start <= end) { // Binary search loop continues while the low index is less than or equal to the high index
            int mid1 = start + (end - start) / 2; // Calculates the midpoint index for the first array (nums1) based on the current search range (low to high)
            int mid2 = left - mid1; // Determines the midpoint index for the second array (nums2) such that the total number of elements to the left of both partitions is equal
            // Handle out-of-bound values with edge conditions:
            int l1 = (mid1 > 0) ? nums1[mid1 - 1] : Integer.MIN_VALUE; // l1 and r1 are the elements on the left and right of the partition in nums1
            int r1 = (mid1 < n1) ? nums1[mid1] : Integer.MAX_VALUE; // l2 and r2 are the elements on the left and right of the partition in nums2
            int l2 = (mid2 > 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE; // Integer.MIN_VALUE and Integer.MAX_VALUE are used as sentinels for out-of-bound indices
            int r2 = (mid2 < n2) ? nums2[mid2] : Integer.MAX_VALUE;
            // Check if the partitions are correct:
            if (l1 <= r2 && l2 <= r1) { // l1 should be less than or equal to r2, and l2 should be less than or equal to r1
                if (n % 2 == 1) {
                    return Math.max(l1, l2); // If total length is odd, return the larger left partition
                } else {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0; // If even, return average of middle elements
                }
            } else if (l1 > r2) {
                end = mid1 - 1; // If l1 is greater than r2, it means mid1 is too far to the right, so adjust the search range to the left
            } else {
                start = mid1 + 1; // If l2 is greater than r1, it means mid1 is too far to the left, so adjust the search range to the right
            }
        }
        return 0;  // Step 19: If arrays were not sorted properly, return 0 (though this case should never be reached if input is valid).
    }
}
//link of the video: https://www.youtube.com/watch?v=F9c7LpRZWVQ&ab_channel=takeUforward
