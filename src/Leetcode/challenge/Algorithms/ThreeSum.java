package Leetcode.challenge.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> finalList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                break;

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum > 0)
                    break;

                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                if (Arrays.binarySearch(nums, -sum) > 0) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[k] == -sum) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            //if (!finalList.contains(list))
                            finalList.add(list);
                            break;
                        }
                    }

                }


            }
        }

        return finalList;
    }

}
