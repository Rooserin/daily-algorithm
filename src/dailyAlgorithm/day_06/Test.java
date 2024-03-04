package dailyAlgorithm.day_06;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO 给定一个整数数组 nums，其中每个元素出现两次，除了一个元素只出现一次。找出那个只出现了一次的元素（使用位运算）。
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 4, 4};
        int ones = findSingle(nums);
//        int ones = myFindSingle(nums);
        System.out.println(ones);
    }

    private static int findSingle(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num; // (((((0^1)^1)^2)^3)^4)^4
        }
        return res;
    }

    private static int myFindSingle(int[] nums) {
        AtomicInteger res = new AtomicInteger();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            if (!countMap.containsKey(num)) {
                countMap.put(num, 1);
            } else {
                int count = countMap.get(num) + 1;
                countMap.put(num, count);
            }
        }
        countMap.forEach((key, value) -> {
            if (value == 1) res.set(key);
        });
        return res.get();
    }


}
