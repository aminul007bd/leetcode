import java.sql.Array;
import java.util.Arrays;

public class CountingBits_338 {
    //Input: n = 2
    //Output: [0,1,1]
    //Explanation:
    //0 --> 0
    //1 --> 1
    //2 --> 1
    public static int[] countBits(int n) {
        int[] result = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            result[i] = result[i >> 1] + i % 2;
        }

        return result;
    }
}
