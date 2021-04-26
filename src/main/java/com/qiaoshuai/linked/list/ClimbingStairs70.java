package com.qiaoshuai.linked.list;


import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs70 {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public int climbStairs(int n) {
        if (map.containsKey(Integer.valueOf(n))) {
            return map.get(Integer.valueOf(n));
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int res = climbStairs(n - 1) + climbStairs(n - 2);
        map.put(Integer.valueOf(n), res);
        return res;
    }
}
