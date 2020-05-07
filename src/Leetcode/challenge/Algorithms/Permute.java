package Leetcode.challenge.Algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Permute {
    public List<List<Integer>> permute(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        return permutePart(nums,set,result);
    }
    public List<List<Integer>> permutePart(int[] nums, List<Integer> set, List<List<Integer>> result) {
        if(nums.length==0){
            result.add(new ArrayList<>(set));
        }
        for(int j = 0 ; j < nums.length ; j++)
        {
            final int index = j ;
            int[] newNums = IntStream
                    .range(0, nums.length)
                    .filter(i -> i  != index).flatMap( i -> IntStream.of(nums[i])).toArray();
            if(set.contains(nums[j]))
            {
                continue;
            }
            set.add(nums[j]);
            permutePart(newNums,set,result);
            set.remove(set.size()-1);
        }
        return result;
    }
}
