import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {
    //Given an integer array nums of unique elements, return all possible subsets (the power set).
    //The solution set must not contain duplicate subsets. Return the solution in any order.

    // Input: nums = [1,2,3]
    //Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    //
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubset(0, nums, new ArrayList<>(), result);

        return result;
    }

    public void generateSubset(int index, int[] nums, List<Integer> current, List<List<Integer>> subset) {
            subset.add(new ArrayList<>(current));
            for(int i = index; i< nums.length; i++) {
                current.add(nums[i]);
                generateSubset(i + 1, nums, current, subset);
                // remove from current size
                current.remove(current.size() - 1);
            }
    }
}
