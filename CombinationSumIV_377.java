import java.util.HashMap;

public class CombinationSumIV_377 {
    private HashMap<Integer, Integer> memo;
    public int combinationSum4(int[] nums, int target) {
        memo = new HashMap<>();
        return combs(nums, target);
    }

    private int combs(int[] nums, int remain) {
        if(remain == 0) return 1;
        if(memo.containsKey(remain)) return memo.get(remain);
        int total = 0;
        for(int num: nums) {
            if(remain - num >= 0)
                total += combs(nums, remain - num);
        }
        memo.put(remain, total);
        return total;

    }
}
