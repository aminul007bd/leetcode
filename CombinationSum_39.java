import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_39 {
    //Given an array of distinct integers candidates and a target integer target,
    // return a list of all unique combinations of candidates where the chosen numbers sum
    // to target. You may return the combinations in any order.
    // Input: candidates = [2,3,6,7], target = 7
    //Output: [[2,2,3],[7]]

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, candidates, target, new ArrayList<>(), 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] nums, int target, List<Integer> tempList, int start) {
        if(target < 0) return;
        if(target == 0) result.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(result, nums, target - nums[i],tempList, i);
            tempList.remove(tempList.size() - 1);
        }
    }
}
