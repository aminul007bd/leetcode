
public class isPalindrome {

    public static void main (String args []) {
        int x = 121;
        if( x < 0 || (x % 10 == 0 && x != 0)) {
//             false;
        }
        int revertedNumber = 0;
        while ( x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
//        x == revertedNumber || x == revertedNumber / 10;


    }
}
