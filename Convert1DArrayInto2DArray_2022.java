public class Convert1DArrayInto2DArray_2022 {
    //Explanation :
    //
    //     For  m=2,n=2
    //
    //     i      i/n         i%n        [ ][ ]
    //
    //    0]      0/2       0%2          [0][0]
    //    1]      1/2       1%2          [0][1]
    //    2]      2/2       2%2          [1][0]
    //    3]      3/2       3%2          [1][1]

    public int[][] construct2DArray(int[] original, int m, int n) {
        if(original.length != m*n) return new int[0][0];
        int[][] result = new int[m][n];
        for(int i = 0; i < original.length; i++)
            result[i/n][i%n] = original[i];

        return result;
    }
}
