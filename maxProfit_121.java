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

        for(int i = 0; i< price.length; i++) {
            if(price[i] < minSoFar) {
                minSoFar = price[i];
            } else {
                largestDifference = Math.max(largestDifference, price[i] - minSoFar);
            }
        }
        return largestDifference;
    }
    public static void main(String[] args) {
        int [] price = {7,6,4,3,1};
        var result = maxProfit(price);
        System.out.println(result);
    }
}
