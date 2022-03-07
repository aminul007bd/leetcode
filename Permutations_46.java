import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Permutations_46 {
    // Given an array nums of distinct integers,
    // return all the possible permutations. You can return the answer in any order.

    // Input: nums = [1,2,3]
    //Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new LinkedList<>();
        // convert nums into list since the output is a list of lists
        ArrayList<Integer> nums_list = new ArrayList<>();
        for(int num: nums)
            nums_list.add(num);

        int n = nums.length;
        backtrack(n, nums_list, output, 0);
        return output;
    }

    public void backtrack(int n, ArrayList<Integer> tempList, List<List<Integer>> output, int first) {
        // if all the integers are used up
        if(first == n)
            output.add(new ArrayList<>(tempList));
        for(int i = first; i< n ; i++) {
            // place i-th integer first
            // in the current permutation
            Collections.swap(tempList, first, i);
            // use the next integers to complete the permutations
            backtrack(n, tempList, output, first + 1);
            // backtrack
            Collections.swap(tempList, first, i);
        }
    }

}
