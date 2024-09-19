public class CountPrimes_204 {

    public static int primeNumbers(int n) {
        int primeCount = 0;
        boolean[] primes = new boolean[n];

        // i * i because it should not more than the square
        for (int i = 2; i * i < primes.length; i++) {
            // if it is not 2,4,6,8 or 3, 9, 12...
            if (primes[i] == false) {
                for (int j = i; j * i < primes.length; j++) {
                    primes[i * j] = true;
                }
            }
        }

        // Leetcode approach
        for (int i = 0; i <= (int) Math.sqrt(n); i++) {
            if (primes[i] == false) {
                for (int j = i * i; j < n; j += i) {
                    primes[j] = true;
                }
            }
        }
        // i < n or i <  primes.length
        for (int i = 2; i < n; i++) {
            if (primes[i] == false) {
                primeCount++;
            }
        }

        return primeCount;

    }

}
