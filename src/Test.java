import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.Arrays;
import java.util.Random;

/**
 * @description:
 * @projectName:test
 * @see:PACKAGE_NAME
 * @author:王祎霖
 * @createTime:2024/2/21 16:08
 * @version:1.0
 */
@SuppressWarnings("Duplicates")
public class Test {

    public static void main(String[] args) {
        int[] nums1 = {1, 5, 6, 8, 10, 0, 0, 0, 0};
        int m = 5;
        int[] nums2 = {2, 5, 8, 17};
        int n = 4;

//        int[] merge = merge1(nums1, m, nums2, n);
//        int[] merge = merge2(nums1, m, nums2, n);
//        System.out.println(Arrays.toString(merge));

//        randomizeNums(nums1);

//        checkIfPowers2(1024);

//        exchangeItem();

//        mid();
        int[] arr = {3, 5, 1, 8, 6, 4, 9, 8};
        bubble(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static int[] merge2(int[] nums1, int m, int[] nums2, int n) {
//        m是nums1里的元素个数，n是nums2里的元素个数，也是长度。nums1的长度等于m+n
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        int tmp = 0;
        for (int i = 0; i < nums1.length - 1; i++) {
            for (int j = 0; j < nums1.length - 1 - i; j++) {
                if (nums1[j] > nums1[j + 1]) {
                    tmp = nums1[j + 1];
                    nums1[j + 1] = nums1[j];
                    nums1[j] = tmp;
                }
            }
        }
        return nums1;
    }


    public static int[] merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m + n];
        int index = 0;
        for (int i = 0; i < m; i++, index = i) {
            nums3[i] = nums1[i];
        }
        System.out.println(index);
        for (int i = 0; i < n; i++) {
            nums3[i + index] = nums2[i];
        }
        int tmp = 0;
        for (int i = 0; i < nums3.length - 1; i++) {
            for (int j = 0; j < nums3.length - 1 - i; j++) {
                if (nums3[j] >= nums3[j + 1]) {
                    tmp = nums3[j + 1];
                    nums3[j + 1] = nums3[j];
                    nums3[j] = tmp;
                }
            }
        }
        nums1 = nums3;
        return nums1;
    }

    //1、数据里有{1,2,3,4,5,6,7,8,9}，请随机打乱顺序，生成一个新的数组
    public static void randomizeNums(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
//            获取随机下标
            int random = new Random().nextInt(nums.length - i);
//            int random = (int) (Math.random() * (nums.length - i));
            result[i] = nums[random];
//            将取出元素放到后面
            int tmp = nums[random];
            nums[random] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = tmp;
        }
        System.out.println(Arrays.toString(result));
    }


    // 2、写出代码判断一个整数是不是2的阶次方
    public static void checkIfPowers2(int a) {
        boolean flag = true;
        while (a > 1) {
            if (a % 2 == 0) {
                System.out.println(a);
                a /= 2;
            } else {
                flag = false;
                break;
            }
        }
        System.out.println(flag);
    }

    //有两个篮子，分别为A 和 B，篮子A里装有鸡蛋，篮子B里装有苹果，请用面向对象的思想实现两个篮子里的物品交换
    public static void exchangeItem() {
        Basket basketA = new Basket("篮子A", new Goods("鸡蛋"));
        Basket basketB = new Basket("篮子B", new Goods("苹果"));

        basketA.exchange(basketB);

        basketA.show();
        basketB.show();
    }

    //二分查找 a为要查找的数字，返回下标
    public static void mid() {
        int[] array = {1, 3, 8, 9, 10, 13, 26, 48, 481, 418646, 46846646};
        int a = 15;

        boolean flag = false;
        int start = 0;
        int mid = 0;
        int end = array.length - 1;
        while (start < end) {
            mid = (start + end) / 2;
            if (array[mid] == a) {
                System.out.println(mid);
                flag = true;
                break;
            } else if (array[mid] < a) {
                start = mid + 1;
            } else if (array[mid] > a) {
                end = mid - 1;
            }
        }
        if (!flag) {
            System.out.println("没有找到该数字");
        }
    }

    // 冒泡排序
    public static void bubble(int[] arr) {

        int tmp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }




}
