package com.qiaoshuai.linked.list;

public class Solution {
    /**
     *11. 盛最多水的容器
     * 两边不断 往中间开始
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int n = height.length-1;
        int i =0;
        int res =0;
        while (i<n){
            int temp;
            if(height[i]>height[n]){
                temp= (n-i)*height[n];
            }else {
                temp= (n-i)*height[i];
            }
            res = res> temp?res:temp;
            if( height[i]>height[n]){
                n--;
            }else {
                i++;
            }

        }
        return res;
    }
}
