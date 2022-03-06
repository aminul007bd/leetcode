import java.util.ArrayList;
import java.util.List;

public class SubsetsII_90 {
    //Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
    //The solution set must not contain duplicate subsets. Return the solution in any order.

    //Input: nums = [1,2,2]
    //Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, nums, new ArrayList<>(), 0);
        return list;
    }

    public void backtrack(List<List<Integer>> list, int[] nums, List<Integer> tempList, int index) {
        list.add(new ArrayList<>(tempList));
        for(int i = index; i < nums.length; i++) {
            if(i < index && nums[i] == nums[i - 1]) continue;
            tempList.add(nums[i]);
            backtrack(list, nums, tempList, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
