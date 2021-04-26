package com.qiaoshuai.linked.list;

public class MoveZeroes283 {
    /**
     * 283. 移动零
     * 双指针的方法；
     * i是循环指针
     * j是第一个0； 也就是后面当i 是0时候需要跟j交换；所以j是第一个0
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i == j) {
                    j++;
                }else {
                    nums[j] = nums[i];
                    nums[i]=0;
                    j++;
                }

            }

        }
    }
}
