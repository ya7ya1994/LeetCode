package Leetcode.challenge.Algorithms;
import java.util.HashMap;
import java.util.Map;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] results = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int rest = target - nums[i];
            if (map.containsKey(rest)) {
                results[0] = i;
                results[1] = map.get(rest);
                break;
            }
            map.put(nums[i], i);
        }
        return results;
    }
}