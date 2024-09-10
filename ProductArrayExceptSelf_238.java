import java.util.Arrays;

public class ProductArrayExceptSelf_238 {
    /*Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
    You must write an algorithm that runs in O(n) time and without using the division operation.
    Example 1:

    Input: nums = [1,2,3,4]
    Output: [24,12,8,6]*/


/*### Code Breakdown

1. **Initialize Variables**:
            - `n`: Stores the length of the input array `nums`.
            - `ans[]`: The result array that will store the final products, initialized with 1's (because multiplying by 1 won’t affect the product).
            - `curr`: A variable that keeps track of the product of elements as you traverse the array.

2. **First Pass (Left to Right)**:
            - Traverse the array from left to right, building a cumulative product from the left side of the array (excluding the current element).
            - For each element `i`, multiply the current element of `ans[i]` by `curr`, which is the cumulative product of all elements before `i`.
            - Update `curr` by multiplying it with `nums[i]` (this will include `nums[i]` for the next iteration).

            3. **Second Pass (Right to Left)**:
            - Traverse the array from right to left, similarly building a cumulative product from the right side of the array.
            - For each element `i`, multiply the current element of `ans[i]` by `curr`, which is the cumulative product of all elements after `i`.
            - Update `curr` by multiplying it with `nums[i]` (this will include `nums[i]` for the next iteration).

            4. **Return the `ans[]` array**: After both passes, the `ans[]` array contains the product of all elements in `nums[]` except the current element at each index.

### Example Walkthrough

    Let's go through an example with `nums = [1, 2, 3, 4]`.

            #### Initial Setup:
            - `nums = [1, 2, 3, 4]`
            - `ans = [1, 1, 1, 1]` (initialized to 1's)
            - `curr = 1`

            #### First Pass (Left to Right):
            - Traverse from left to right, calculating the product of all elements **before** the current element:

            1. **i = 0**:
            - `ans[0] = ans[0] * curr = 1 * 1 = 1`
            - Update `curr = curr * nums[0] = 1 * 1 = 1`

            2. **i = 1**:
            - `ans[1] = ans[1] * curr = 1 * 1 = 1`
            - Update `curr = curr * nums[1] = 1 * 2 = 2`

            3. **i = 2**:
            - `ans[2] = ans[2] * curr = 1 * 2 = 2`
            - Update `curr = curr * nums[2] = 2 * 3 = 6`

            4. **i = 3**:
            - `ans[3] = ans[3] * curr = 1 * 6 = 6`
            - Update `curr = curr * nums[3] = 6 * 4 = 24`

    After the first pass, the `ans[]` array is: `[1, 1, 2, 6]`.

            #### Second Pass (Right to Left):
            - Traverse from right to left, calculating the product of all elements **after** the current element:

            1. **i = 3**:
            - `ans[3] = ans[3] * curr = 6 * 1 = 6`
            - Update `curr = curr * nums[3] = 1 * 4 = 4`

            2. **i = 2**:
            - `ans[2] = ans[2] * curr = 2 * 4 = 8`
            - Update `curr = curr * nums[2] = 4 * 3 = 12`

            3. **i = 1**:
            - `ans[1] = ans[1] * curr = 1 * 12 = 12`
            - Update `curr = curr * nums[1] = 12 * 2 = 24`

            4. **i = 0**:
            - `ans[0] = ans[0] * curr = 1 * 24 = 24`
            - Update `curr = curr * nums[0] = 24 * 1 = 24`

    After the second pass, the `ans[]` array is: `[24, 12, 8, 6]`.

            #### Final Output:
    The final array is `[24, 12, 8, 6]`, which means:
            - For index 0: The product of `[2 * 3 * 4]` = 24.
            - For index 1: The product of `[1 * 3 * 4]` = 12.
            - For index 2: The product of `[1 * 2 * 4]` = 8.
            - For index 3: The product of `[1 * 2 * 3]` = 6.

            ### Key Points:
            - **Time Complexity**: O(n) because the array is traversed twice.
            - **Space Complexity**: O(1) (excluding the output array), as no extra space is used other than the result array `ans[]`.

    This approach efficiently solves the problem without using division and in linear time.*/

    // Brute Force
    public int[] productExceptSelfBruteForce(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        for(int i = 0; i < n; i++) {
            int pro = 1;
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                pro *= nums[j];
            }
            ans[i] = pro;
        }

        return ans;
    }

    //Directly store the product of prefix and suffix into the final answer array
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        int curr = 1;
        for(int i = 0; i < n; i++) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        curr = 1;
        for(int i = n - 1; i >= 0; i--) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        return ans;
    }
}