/* Problem 45: You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].*/

// leetcode solution from niits
/*
Approach
Input: nums = [2,3,1,1,4]
We start from index 0. In that case above, we have two choices. I mean jump to index 1 or index 2.

Problem:
We don't know whether we should jump to index 1 or index 2 to get minimum number of jumps in the end.

Let's think about index 1 and index 2 cases.

From index 1, We have three choices. Jump to index 2, 3 or 4.
From index 2, We have one choice. Jump to index 3.*/

/*Intuition :
Important thing is that farthest position(= index 2) from previous jump position(= index 0) is not always following the next farthest position.

From index 0, the farthest position should be index 2, because maximum jump from index 0 is 2. But if we jump from index 2, we can jump to the next position(= index 3).

On the other hand, if we jump to index 1 from index 0, we can jump to index 4 from index 1. which is farther than index 3 from index 2.

So my strategy is to have near and far position and we check all jumps between the positions and get the farthest position every time.

Let's see one by one.

Input: nums = [2,3,1,1,4]

near = 0
far = 0
jumps = 0
First of all, the range between near and far is 0, so we check only index 0. The farthest position should be

farthest position = current index + maximum jump
= 0 + 2
= 2
We check all positions in the range.

Next, before we move to the next range, we should update near, far and jumps.

This question guarantee that we can definitely reach the last index, so at least, we must move forward from the current range, so

The next near position should be

far + 1
Because far position is the most right position of current range.

The next far position should be

far = current farthest we found = 2
Of course, add +1 to jump times

jumps += 1
In the end,

   n f
[2,3,1,1,4]

jumps = 1
Next we check between index 1 and index 2.

From index 1, the farthest position should

farthest = 1 + 3 = 4
From index 2, the farthest position should

farthest = 2 + 1 = 3
We take index 4. Then update near, far and jumps.

near = far + 1 = 3
far = farthest = 4
jumps = 1 + 1 = 2
In the end,

       n f
[2,3,1,1,4]

jumps = 2
We will repeat the same algorithm. And now far position is reach the last index, so we stop iteration.

return 2(= jumps)
.

Complexity :
Time complexity : O(n)
Space complexity: O(1)*/

public class JumpGameII_45 {
    public int jump(int[] nums) {
        int near = 0, far = 0, jumps = 0;

        while (far < nums.length - 1) {
            int farthest = 0;
            for (int i = near; i <= far; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            near = far + 1;
            far = farthest;
            jumps++;
        }

        return jumps;
    }
}

/* ### Step-by-Step Breakdown:
1. **Initialization**:
    - `near` is the starting index of the current jump range.
   - `far` is the farthest index we can reach with the current number of jumps.
   - `jumps` counts the total number of jumps made.

2. **While loop** (`while (far < nums.length - 1)`):
        - The loop continues until `far` has reached or surpassed the last index (`nums.length - 1`).
        - In each iteration, the algorithm processes the current jump range (from `near` to `far`) to determine the farthest point reachable with one more jump.

        3. **Farthest Calculation**:
        - For each index `i` in the current jump range (from `near` to `far`), the algorithm calculates the farthest point reachable:

                 farthest = Math.max(farthest, i + nums[i]);

             - `i + nums[i]` represents the farthest index reachable from position `i` by jumping `nums[i]` steps.
   - The algorithm keeps track of the maximum possible jump within the current range.

4. **Update Range**:
        - Once the farthest point for the current jump range is determined:

        near = far + 1;
         far = farthest;

             - The next range to process begins just after the current range (`near = far + 1`), and the `far` variable is updated to the new `farthest` point.

5. **Increment Jumps**:
        - After processing each jump range, the algorithm increments the `jumps` counter:
                jumps++;

6. **Return the Number of Jumps**:
        - The algorithm continues this process until the `far` variable reaches or exceeds the last index of the array (`nums.length - 1`), at which point the total number of jumps is returned.

        ### Example:

        **Input**: `nums = [2, 3, 1, 1, 4]`

        - **Iteration 1**:
        - `near = 0`, `far = 0`, `jumps = 0`.
        - The algorithm processes the range from `near = 0` to `far = 0`.
        - `farthest = Math.max(0, 0 + nums[0]) = 2` (reachable from index 0).
        - Update `near = 1`, `far = 2`, `jumps = 1`.

        - **Iteration 2**:
        - `near = 1`, `far = 2`, `jumps = 1`.
        - The algorithm processes the range from `near = 1` to `far = 2`.
        - `farthest = Math.max(2, 1 + nums[1]) = 4` (reachable from index 1).
        - `farthest = Math.max(4, 2 + nums[2]) = 4` (no improvement from index 2).
        - Update `near = 3`, `far = 4`, `jumps = 2`.

        - **Termination**:
        - Now, `far = 4` (reached or exceeded the last index), so the loop exits.
        - The algorithm returns `jumps = 2`.

        ### Complexity:
        - **Time complexity**: O(n), where `n` is the number of elements in the array. Each element is processed only once.
        - **Space complexity**: O(1), since only a few variables (`near`, `far`, `farthest`, `jumps`) are used, and no extra space is required.
*/
