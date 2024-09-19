/* Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane,
return the maximum number of points that lie on the same straight line.

Input: points = [[1,1],[2,2],[3,3]]
Output: 3 */

import java.util.HashMap;
import java.util.Map;

public class MaxPointsonaLine_149 {

    public int maxPoints(int[][] points) {
        int max = 0; // Initialize the variable 'max' to store the maximum number of points on the same line

        for (int[] x : points) { // Loop through each point 'x' in the 'points' array
            Map<Double, Integer> map = new HashMap<>();   // Create a HashMap to store slopes and their frequencies
            for (int[] y : points) { // Loop through each point 'y' in the 'points' array
                if (x == y) continue; // Skip if 'x' and 'y' are the same point
                double slope = 0; // Initialize the variable 'slope' to store the slope of the line between 'x' and 'y'
                if (y[0] - x[0] == 0) { // Check if the line is vertical (x2 - x1 == 0)
                    slope = Double.POSITIVE_INFINITY; // Use positive infinity to represent the slope of a vertical line
                } else {
                    slope = (y[1] - x[1]) / (double) (y[0] - x[0]); // Calculate the slope of the line as (y2 - y1) / (x2 - x1)
                }
                map.put(slope, map.getOrDefault(slope, 0) + 1); // Update the frequency count of the slope in the HashMap
                max = Math.max(max, map.get(slope)); // Update 'max' to be the maximum of its current value or the frequency of the current slope
            }
        }

        return max + 1; // Return the maximum number of points on the same line plus 1 (including the point 'x')
    }
}

/*
Approach
Loop Through Points: Iterate through each point x in the points array.
Calculate Slopes: For each point x, calculate the slope of the line between x and every other point y.
Handle Vertical Lines: Use Double.POSITIVE_INFINITY for vertical lines where the denominator is zero.
Count Slopes: Use a HashMap to keep track of how many times each slope occurs.
Update Maximum Points: Keep track of the maximum number of points that lie on the same line by updating the max variable.
Return Result: Return the maximum number of points on a line plus 1 to include the starting point x.


Walkthrough Example
Let's consider an example with the points [[1, 1], [2, 2], [3, 3], [4, 1], [5, 1]]:

First Iteration (x = [1, 1]):

Calculate slopes with all other points:
With [2, 2]:
Slope = (2 - 1) / (2 - 1) = 1.0
Update map: {1.0: 1}

With [3, 3]:
Slope = (3 - 1) / (3 - 1) = 1.0
Update map: {1.0: 2}

With [4, 1]:
Slope = (1 - 1) / (4 - 1) = 0.0
Update map: {1.0: 2, 0.0: 1}

With [5, 1]:
Slope = (1 - 1) / (5 - 1) = 0.0
Update map: {1.0: 2, 0.0: 2}

Maximum points on a line passing through [1, 1]: 2
Second Iteration (x = [2, 2]):

Calculate slopes with all other points:
With [3, 3]:
Slope = (3 - 2) / (3 - 2) = 1.0
Update map: {1.0: 1}
With [4, 1]:
Slope = (1 - 2) / (4 - 2) = -0.5
Update map: {1.0: 1, -0.5: 1}
With [5, 1]:
Slope = (1 - 2) / (5 - 2) = -0.333
Update map: {1.0: 1, -0.5: 1, -0.333: 1}
Maximum points on a line passing through [2, 2]: 1
Subsequent Iterations:

Repeat the above steps for each remaining point.
Final Maximum Calculation:

After all iterations, the highest count of points on the same line is found to be 3.
Result:

Return max + 1 which is 3 + 1 = 4.*/
