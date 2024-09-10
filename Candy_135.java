import java.util.Arrays;

public class Candy_135 {
    /*There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
    You are giving candies to these children subjected to the following requirements:

    Each child must have at least one candy.
    Children with a higher rating get more candies than their neighbors.
    Return the minimum number of candies you need to have to distribute the candies to the children.

   Example 1:
    Input: ratings = [1,0,2]
    Output: 5
    Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.*/

    /*Example Walkthrough: (one pass)
    Consider the ratings: ratings = [1, 2, 2, 3, 2, 1].

    Initialize ret = 1, up = 0, down = 0, peak = 0.
    Start iterating:
            1 < 2: It's an increasing sequence, up = 1, add 1 + up = 2 to ret. Now, ret = 3.
            2 == 2: It's a flat sequence, reset up, down, and peak, add 1 to ret. Now, ret = 4.
            2 < 3: Increasing sequence, up = 1, add 1 + up = 2 to ret. Now, ret = 6, and peak = 1.
3 > 2: Decreasing sequence, down = 1, add 1 + down = 2 to ret. Now, ret = 8, no peak adjustment.
2 > 1: Decreasing sequence, down = 2, add 1 + down = 3 to ret. Now, ret = 11, but since peak (1) < down (2), adjust ret = 10.
    Final result: The function returns 10, meaning 10 candies are required.*/

    public int candy(int[] ratings) {
        if (ratings.length == 0) {
            return 0; // If the ratings array is empty, return 0 because no candy is needed.
        }
        int ret = 1, up = 0, down = 0, peak = 0;
        // Initialize:
        // `ret` as 1 because we give at least 1 candy to the first child,
        // `up` to track how many consecutive increasing ratings we've seen,
        // `down` to track how many consecutive decreasing ratings we've seen,
        // `peak` to store the height of the last peak (highest point in increasing ratings).

        for (int i = 0; i < ratings.length - 1; i++) { // Iterate over the array, comparing each rating with the next one (until the second-to-last rating).
            int prev = ratings[i], curr = ratings[i + 1]; // `prev` holds the current rating, `curr` holds the next rating.
            if (prev < curr) { // If the current rating is smaller than the next, it’s an increasing sequence.
                up++;
                down = 0; // Reset `down` since we're in an increasing sequence.
                peak = up; // Set the peak as `up` since we're at a new highest point.
                ret += 1 + up; // Add the base candy (1) and `up` for the increasing sequence to the total.
            } else if (prev == curr) { // If the current rating is equal to the next one, reset everything to start fresh.
                up = down = peak = 0; // Reset `up`, `down`, and `peak` because it's a flat sequence.
                ret += 1; // Add 1 candy since the next child gets exactly 1 candy.
            } else { // If the current rating is greater than the next, it’s a decreasing sequence.
                up = 0; // Reset `up` because the increasing sequence has ended.
                down++; // Increment `down` to track the length of the decreasing sequence.
                ret += 1 + down; // Add the base candy (1) and `down` for the decreasing sequence to the total.
                if (peak >= down) { // If the previous peak is greater than or equal to the current `down` count,
                    ret--; // Decrease the candy count by 1 because we over-counted at the peak.
                }
            }
        }
        return ret;
    }

    //Solution with O(n)
    public int candyOn(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
                // If the current rating is greater than the previous rating,
                // then the current child should receive more candies than the previous child.
                // Hence, increment the candies for the current child.
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
                // Traverse the ratings array from right to left.
                // If the current rating is greater than the next rating,
                // ensure that the current child receives more candies than the next child.
                // Take the maximum between the current value and the required value.
            }
        }

        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy; // Sum up the candies from each index in the `candies` array.
        }

        return totalCandies;
    }

}
