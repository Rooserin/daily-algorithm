package dailyAlgorithm.day_09;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wangyilin
 * @date 2024/3/14 13:17
 */
public class Algorithm314 {

    public static void main(String[] args) {
        Algorithm314 main = new Algorithm314();
//        System.out.println(main.reverseString(new Scanner(System.in).next()));
//        main.getMaxAndMin(new int[]{11, 1, 2, 3, 4, 5, 6});
//        System.out.println(main.isPalindromic(new Scanner(System.in).next()));
//        System.out.println(main.getFibonacci(new Scanner(System.in).nextInt()));
//        System.out.println(main.checkDuplicate(new Scanner(System.in).next()));
//        System.out.println(main.findAbsentNum(new int[]{6, 2, 1, 3, 7, 4, 8, 9}));
//        System.out.println(main.cleverlyFindAbsentNum(new int[]{6, 2, 1, 3, 7, 4, 8, 9}));
//        System.out.println(Arrays.toString(main.sortAndCombine(new int[]{3, 4, 6, 1, 0, 0}, new int[]{5, 2}, 4, 2)));
//        System.out.println(Arrays.toString(main.cleverSortAndCombine(new int[]{3, 4, 6, 1, 0, 0}, new int[]{5, 2}, 4, 2)));
//        System.out.println(Arrays.toString(main.violentFindSumNumIndex()));
//        System.out.println(Arrays.toString(main.findSumNumIndexWithHash()));
        System.out.println(main.randomString());
    }


    public String reverseString(String str) {
        StringBuilder reverted = new StringBuilder();
        char[] chars = str.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            reverted.append(chars[i]);
        }
        return reverted.toString();
    }

    public void getMaxAndMin(int[] arr) {
        int max = 0, min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
            if (arr[i] < min) min = arr[i];
        }
        System.out.println("最大值：" + max + "\n最小值：" + min);
    }

    public boolean isPalindromic(String str) {
//        return Objects.equals(new StringBuilder(str).reverse().toString(), str);
        return Objects.equals(str, reverseString(str));
    }

    public int getFibonacci(int n) {
        int a = 1, b = 1, res = 0;
        if (n == 0 || n == 1) {
            return 1;
        }
        for (int i = 2; i <= n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }

    public boolean checkDuplicate(String str) {
        HashSet<Character> characters = new HashSet<>();
        for (char c : str.toCharArray()) {
            boolean addFlag = characters.add(c);
            if (!addFlag) return true;
        }
        return false;
    }

    public int findAbsentNum(int[] arr) {
//        int[] sorted = new int[arr.length];
        int tmp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        int a = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - a > 1) {
                return arr[i] - 1;
            }
            a = arr[i];
        }
        return -1;
    }

    public int cleverlyFindAbsentNum(int[] arr) {
        int n = arr.length + 1;
        int sum = n * (n + 1) / 2;
        for (int num : arr) {
            sum -= num;
        }
        return sum;
    }


    public int[] sortAndCombine(int[] nums1, int[] nums2, int m, int n) {
        for (int i = 0; i < n; i++) {
            nums1[i + m] = nums2[i];
        }
        System.out.println(Arrays.toString(nums1));
        int tmp = 0;
        for (int i = 0; i < m + n - 1; i++) {
            for (int j = 0; j < m + n - 1 - i; j++) {
                if (nums1[j] >= nums1[j + 1]) {
                    tmp = nums1[j + 1];
                    nums1[j + 1] = nums1[j];
                    nums1[j] = tmp;
                }
            }
        }
        return nums1;
    }


    public int[] cleverSortAndCombine(int[] nums1, int[] nums2, int m, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
        return nums1;
    }


    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那两个整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案。
     */
    public int[] violentFindSumNumIndex() {
        int[] nums = {2, 7, 11, 15};
        int[] res = new int[2];
        int target = 9;
        first:
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                if (nums[i] + nums[j] == target) {
                    res = new int[]{i, j};
                    break first;
                }
            }
        }
        return res;
    }

    private int[] findSumNumIndexWithHash() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    private List<List<String>> randomString() {
        String[] origin = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        List<List<String>> res = new ArrayList<>();
//        for (String str : origin) {
//            Set<String> strSet = new HashSet<>();
//            char[] chars = new char[str.length()];
//            char tmp;
//            for (int i = 0; i < str.length(); i++) {
//                int random = new Random().nextInt(str.length() - i);
//                chars[str.length() - i - 1] = str.charAt(random);
//                tmp = chars[str.length() - i - 1];

//            }

//        }
//        return res;
        return new ArrayList<>(Arrays.stream(origin).collect(
                Collectors.groupingBy(
                        str -> str.chars().sorted().collect(
                                        StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append
                                ).toString()
                )
        ).values());
    }




}
