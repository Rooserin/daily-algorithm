package dailyAlgorithm.day_03;


/**
 * TODO 给定一个非空整数数组，除了一个元素只出现一次之外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 */
public class Test {

    public static void main(String[] args) {
//        int[] arr = {1, 1, 1, 1, 2, 3, 3, 3, 4, 4, 5, 5, 6, 6, 6, 6};
        int[] arr = {1, 1, 1, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6};
//        System.out.println(myFindSingle01(arr));
//        System.out.println(singleNumber(arr));
        System.out.println(singleNumber(arr));
    }

    private static int myFindSingle01(int[] arr) {
        int count = 0;
        int res = 0;
        for (int num : arr) {
            // 第二层比较
            for (int j = 0; j < arr.length; j++) {
                if (num == arr[j]) {
                    count += 1;
                }
            }
            if (count == 1) {
                break;
            } else {
                count = 0;
            }
        }
        return res;
    }

    /**
     * 对于数组中的每个元素，我们可以使用两个变量 ones 和 twos 来表示当前元素出现一次和两次的情况。
     * <p>
     * ones：表示当前元素出现一次的位级表示。
     * twos：表示当前元素出现两次的位级表示。
     * 遍历数组中的每个元素，对于每个元素，执行以下操作：
     * <p>
     * 将当前元素与 ones 进行按位异或操作，并将结果赋值给 ones，这样做的效果是将当前元素加入 ones 中，但是如果当前元素已经在 twos 中出现过，则会被移除。
     * 将当前元素与 twos 进行按位异或操作，并将结果赋值给 twos，这样做的效果是将当前元素加入 twos 中，但是如果当前元素已经在 ones 中出现过，则会被移除。
     * 如果当前元素同时出现在 ones 和 twos 中（即 ones 和 twos 中的对应位均为 1），则将 ones 和 twos 中对应位清零。
     * 最终，ones 中存储的就是只出现一次的元素。
     * <p>
     * 下面是对应的 Java 代码实现：
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        return ones;
    }
    //刚开始one和two两个数都是0，0异或任何数都为任何数本身，假设a出现第一次的时候，
    // one^a&~one=0^a&1=a&1=a
    // two^a&~two=0^a&~a=a&~a=0
    //
    //第二次a出现的时候
    // one^a&~one=a^a&~a=0&~a=0
    // two^a&~two=0^a&~a=a&1=a
    //
    //第三次a出现的时候
    // one^a&~one=0^a&~0=0&1=0
    // two^a&~two=a^a&~a=0&~a=0
}
