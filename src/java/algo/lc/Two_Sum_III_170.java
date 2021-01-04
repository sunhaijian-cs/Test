package algo.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: sunhaijian
 * @Date: 2020/6/27
 * @Description:
 *
我们设计一个类，拥有两个 API：


class TwoSum {
    // 向数据结构中添加一个数 number
    public void add(int number);
    // 寻找当前数据结构中是否存在两个数的和为 value
    public boolean find(int value);
}
add 时间复杂度O(1)
find 时间复杂度O(n)
 ps
 1,哈希结构的用法
 2，如果find请求非常频繁，可以优化find 时间复杂度为O（1），
 做法是媒资add 都缓存所有新增的两数和。



 **/
public class Two_Sum_III_170 {

    Map<Integer, Integer> freq = new HashMap<>();

    public void add(int number) {
        // 记录 number 出现的次数
        freq.put(number, freq.getOrDefault(number, 0) + 1);
    }

    public boolean find(int value) {
        for (Integer key : freq.keySet()) {
            int other = value - key;
            // 情况一
            if (other == key && freq.get(key) > 1){
                return true;
            }

            // 情况二
            if (other != key && freq.containsKey(other)) {
                return true;
            }
        }
        return false;
    }
}
