package com.qiaoshuai.linked.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/solution/3sumpai-xu-shuang-zhi-zhen-yi-dong-by-jyd/
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        //排序；
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        //第一个指针，从0开始到 倒数第三个；
        for(int k = 0; k < nums.length - 2; k++){
            if(nums[k] > 0) {
                break;
            }
            if(k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int i = k + 1, j = nums.length - 1;
            while(i < j){
                int sum = nums[k] + nums[i] + nums[j];
                if(sum < 0){
                    while(i < j && nums[i] == nums[++i]) {
                        ;
                    }
                } else if (sum > 0) {
                    while(i < j && nums[j] == nums[--j]) {
                        ;
                    }
                } else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while(i < j && nums[i] == nums[++i]) {
                        ;
                    }
                    while(i < j && nums[j] == nums[--j]) {
                        ;
                    }
                }
            }
        }
        return res;
    }
}
