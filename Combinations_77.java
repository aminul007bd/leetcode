import java.util.ArrayList;
import java.util.List;

public class Combinations_77 {
    // Given two integers n and k, return all possible combinations of
    // k numbers out of the range [1, n].
    //You may return the answer in any order.
    //Input: n = 4, k = 2
    //Output: [
    //  [2,4],
    //  [3,4],
    //  [2,3],
    //  [1,2],
    //  [1,3],
    //  [1,4],
    //]
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), n, k, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int n, int k, int start) {
        if(k == 0) result.add(new ArrayList<>(tempList));
        for(int i = start; i <= n; i++) {
            tempList.add(i);
            backtrack(result, tempList, n, k - 1, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
