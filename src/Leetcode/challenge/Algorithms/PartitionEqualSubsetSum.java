package Leetcode.challenge.Algorithms;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int total = 0 ;
        for(int i = 0 ; i < nums.length ; i++)
        {
            total += nums[i];
        }

        if(total % 2 != 0){
            return false;
        }
        if(nums[0] == total / 2){
            return true;
        }
        for(int k=0 ; k < nums.length-1 ; k++ ){
            int [] temp = Arrays.copyOfRange(nums,k,nums.length);
            for(int i = -1 ; i < temp.length ; i++){
                final int index = i ;
                int[] newNums = IntStream.range(0, temp.length)
                        .filter(l -> l  != index)
                        .flatMap( l -> IntStream.of(temp[l]))
                        .toArray();
                int sum = total/2;
                for(int j=0 ; j < newNums.length-1 ; j++){
                    sum -= newNums[j];
                    if(sum < 0){
                        break;
                    }
                    if( sum == 0 ){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
