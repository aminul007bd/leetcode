import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {

    public static int primeNumbers(int n) {
        int primeCount = 0;
        boolean[] primes = new boolean[n];

        // i * i because it should not more than the square
        for(int i = 2; i * i < primes.length; i ++) {
            // if it is not 2,4,6,8 or 3, 9, 12...
            if(primes[i] == false) {
                for(int j = i; j * i < primes.length; j++) {
                    primes [i * j] = true;
                }
            }
        }

        // Leetcode approach
        for(int i = 0; i <= (int)Math.sqrt(n); i++) {
            if(primes[i] == false){
                for(int j = i * i; j < n; j+= i) {
                    primes[j] = true;
                }
            }
        }
        // i < n or i <  primes.length
        for (int i = 2; i < n; i++) {
            if(primes[i] == false) {
                primeCount++;
            }
        }

        return primeCount;

    }

        public static void main (String args []) {
            // A prime number is a whole number greater than 1
            // that has only two factors and that is 1 and the number ifself
            List<Integer> primeNumbers = new ArrayList<>();

            for (int numberToCheck = 2; numberToCheck <= 10; numberToCheck++) {
                // Check if the number is prime or not
                boolean isPrime = true;
                for(int factor = 2; factor <= numberToCheck / 2; factor++) {
                    if(numberToCheck % factor == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if(isPrime) {
                    primeNumbers.add(numberToCheck);
                }
            }

            System.out.println("Prime numbers are: " + primeNumbers.toArray().length);
        }
}
