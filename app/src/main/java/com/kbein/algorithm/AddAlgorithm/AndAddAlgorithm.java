package com.kbein.algorithm.AddAlgorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * com.kbein.algorithm.AndAlgorithm
 * Created by KBein on 2018/11/9 10:46
 *
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * 示例:
 *   给定 nums = [2, 7, 11, 15], target = 9
 *   因为 nums[0] + nums[1] = 2 + 7 = 9
 *   所以返回 [0, 1]
 *
 */

public class AndAddAlgorithm {
//    时间复杂度：O(n^2)
//    对于每个元素，我们试图通过遍历数组的其余部分来寻找它所对应的目标元素.
//    这将耗费 O(n)O(n) 的时间。因此时间复杂度为 O(n^2)O(n2)。
//    空间复杂度：O(1)O(1)。
    public int[] twoSum1(int[] nums, int target) {
        int[] targetNum = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length;j++){
                if (nums[i] + nums[j] == target){
                    targetNum[0] =i;
                    targetNum[1] =j;
                }
            }
        }
        return targetNum;
    }

    //优化后算法
    public int[] twoSum2(int[] nums,int target){

        Map<Integer,Integer> targetNum = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int sumResult = target - nums[i];
            if (targetNum.containsKey(sumResult)){
                return new int[]{targetNum.get(sumResult),i};
            }
            targetNum.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");

    }



}
