import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII_47 {
    //Given a collection of numbers, nums, that might contain duplicates,
    // return all possible unique permutations in any order.

    // https://leetcode.com/problems/permutations-ii/discuss/1527937/Java-or-TC%3A-O(N*N!)-or-SC%3A-O(N)-or-Recursive-Backtracking-and-Iterative-Solutions

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        if(nums == null || nums.length == 0) return result;
        Arrays.sort(nums);
        backtrack(result, nums, new ArrayList<>(), visited);
        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] nums, List<Integer> tempList, boolean[] visited) {
        if(tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for(int i = 0; i< nums.length; i++) {
            /**
             * !visited[i - 1] is making sure that duplicate results are not added. Since
             * nums[i-1] and nums[i] are same, nums[i] can only be used if nums[i-1] is
             * currently in use.
             */
            if(visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) continue;

            visited[i] = true;
            tempList.add(nums[i]);
            backtrack(result, nums, tempList, visited);
            tempList.remove(tempList.size() - 1);
            visited[i] = false;
        }
    }

}
