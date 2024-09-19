public class maxProfit_121 {
    //Input: prices = [7,1,5,3,6,4]
    //Output: 5
    //Explanation: Buy on day 2 (price = 1) and sell on day 5
    // (price = 6), profit = 6-1 = 5.

    public static int maxProfit(int[] price) {
        // keep track of the bust buy day so far
        int largestDifference = 0;

        // keep track of the largest difference so far
        int minSoFar = Integer.MAX_VALUE;

        for (int j : price) {
            if (j < minSoFar) {
                minSoFar = j;
            } else {
                largestDifference = Math.max(largestDifference, j - minSoFar);
            }
        }
        return largestDifference;
    }
}
