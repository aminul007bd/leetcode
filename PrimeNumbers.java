import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {

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
