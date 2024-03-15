package dailyAlgorithm.day_08;

import java.util.Stack;

/**
 * @author wangyilin
 * @date 2024/3/11 15:31
 */
public class Algorithm311 {

    public static void main(String[] args) {
//        int num = new Scanner(System.in).nextInt();
//        System.out.println(checkNum(num) ? "是素数" : "不是素数");

//        String val = new Scanner(System.in).next();
//        System.out.println(revertString(val));

//        int num = new Scanner(System.in).nextInt();
//        System.out.println(fibonacci(num));

//        int[] nums = {1, 10, 2, 3, 4, 5, 6, 7, 8, 9};
//        findMaxAndMin01(nums);
//        findMaxAndMin02(nums);

//        String val = new Scanner(System.in).next();
//        System.out.println(checkRevert(val) ? "是" : "不是");
//        System.out.println(checkRevert2(val) ? "是" : "不是");

//        int[] arr1 = {1, 3, 5};
//        int[] arr2 = {2, 4, 6};
//        System.out.println(getMiddle(arr1, arr2)); // {1,2,3,4,5}, {1,2,3,4,5,6}

//        String braces = new Scanner(System.in).next();
//        System.out.println(brackMatchCheck(braces) ? "match" : "don't match");

        String a = "aaabbbccc";
        System.out.println(a.contains("bbccc"));

    }

    private static boolean brackMatchCheck(String braces) {
        Stack<Character> stack = new Stack<>();
        for (char c : braces.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek()=='(') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek()=='{') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek()=='[') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    private static double getMiddle(int[] arr1, int[] arr2) {
        int m = arr1.length, n = arr2.length;
        int[] arr3 = new int[m + n];
        int index = 0;
        for (int i = 0; i < m; i++, index = i) {
            arr3[i] = arr1[i];
        }
//        System.out.println(index);
        for (int i = 0; i < n; i++) {
            arr3[i + index] = arr2[i];
        }
        int tmp = 0;
        for (int i = 0; i < arr3.length - 1; i++) {
            for (int j = 0; j < arr3.length - 1 - i; j++) {
                if (arr3[j] >= arr3[j + 1]) {
                    tmp = arr3[j + 1];
                    arr3[j + 1] = arr3[j];
                    arr3[j] = tmp;
                }
            }
        }
//        System.out.println(Arrays.toString(arr3));
        double res = 0;
        if (arr3.length % 2 == 0) {
            res = ((double) (arr3[(arr3.length - 1) / 2] + arr3[(arr3.length - 1) / 2 + 1]) / 2);
        } else {
            res = arr3[(m + n) / 2];
        }
        return res;
    }


    private static boolean checkRevert(String val) {
        String s = revertString(val);
        if (s.equals(val)) return true;
        else return false;
    }

    private static boolean checkRevert2(String val) {
        int left = 0, right = val.length() - 1;
        while (right > left) {
            if (val.charAt(left) != val.charAt(right)) {
                return false;
            }
            right--;
            left++;
        }
        return true;
    }

    private static void findMaxAndMin01(int[] nums) {
        int max = 0, min = 0;
        boolean maxFlag = true;
        boolean minFlag = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] < nums[j]) maxFlag = false;
                if (nums[i] > nums[j]) minFlag = false;
            }
            if (maxFlag) max = nums[i];
            if (minFlag) min = nums[i];
            maxFlag = true;
            minFlag = true;
        }
        System.out.println("最大值是：" + max + "\n最小值是：" + min);
    }

    private static void findMaxAndMin02(int[] nums) {
        int max = nums[0], min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) max = nums[i];
            if (nums[i] < min) min = nums[i];
        }
        System.out.println("最大值是：" + max + "\n最小值是：" + min);
    }

    private static int fibonacci(int num) {
        if (num <= 0) {
            return 0;
        } else if (num == 1 || num == 2) {
            return 1;
        } else {
            int a = 1, b = 1, res = 0;
            int tmp = 0;
            for (int i = 3; i < num; i++) {
                res = a + b;
                a = b;
                b = res;
            }
            return res;
        }
    }

    private static String revertString(String val) {
        StringBuilder revert = new StringBuilder();
        int length = val.length();
        for (int i = length - 1; i >= 0; i--) {
            revert.append(val.charAt(i));
        }
        return revert.toString();
    }

    private static boolean checkNum(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
