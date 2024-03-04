import java.util.Arrays;
import java.util.Random;

@SuppressWarnings("DuplicatedCode")
public class Test2 {


    public static void main(String[] args) {
//        rearrange();
//        checkIfPowered2();
//        calculateDate();
//        divideSearch(101);
        bubble();
    }


    public static void rearrange() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] result = new int[arr.length];
        int tmp = 0;
        for (int i = 0; i < arr.length; i++) {
            int random = new Random().nextInt(arr.length - i);
            result[i] = arr[random];
            // 将random取出元素的下标后移
            tmp = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = arr[random];
            arr[random] = tmp;
        }
        System.out.println(Arrays.toString(result));

    }


    public static void checkIfPowered2() {
        int a = new Random().nextInt(1000);
//        a = 2048;
        System.out.println(a);
        boolean flag = true;
        while (a > 1) {
            if (a % 2 == 0) {
                a /= 2;
                System.out.println(a);
            } else {
                flag = false;
                break;
            }
        }
        System.out.println(flag);
    }


    public static void calculateDate() {
        // 定义初始日期
        int year = 2015;
        int month = 3;
        int day = 1;
        int dayOfWeek = 0; // 假设星期日为0

        // 计算13个月零6天后的日期
        int futureMonth = month + 13;
        int futureDay = day + 6;

        if (futureMonth > 12) {
            year += futureMonth / 12;
            futureMonth %= 12;
        }

        // 处理闰年
        if (futureMonth == 2 && futureDay > 28) {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                futureDay = 29;
            } else {
                futureDay = 28;
            }
        } else if ((futureMonth == 4 || futureMonth == 6 || futureMonth == 9 || futureMonth == 11) && futureDay > 30) {
            futureDay = 30;
        }

        // 计算星期几
        dayOfWeek = (dayOfWeek + (13 * 365) + (13 * 30) + 6) % 7;

        // 计算距离现在的天数
        int currentYear = 2022;
        int currentMonth = 11;
        int currentDay = 30;
        int daysUntilFutureDate = 0;

        while (year != currentYear || month != currentMonth || day != currentDay) {
            daysUntilFutureDate++;
            day++;
            if (day > 30) {
                day = 1;
                month++;
            }
            if (month > 12) {
                month = 1;
                year++;
            }
        }

        // 输出结果
        System.out.println("13个月零6天后是星期" + dayOfWeek);
        System.out.println("距离现在还有" + daysUntilFutureDate + "天");
    }


    public static void divideSearch(int a) {
        int[] arr = new int[100];
        for (int i = 0; i <= 99; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
        int start = 0;
        int end = arr.length - 1;
        int mid = 0;
        boolean flag = false;
        while (start < end) {
            mid = (start + end) / 2;
            if (arr[mid] == a) {
                flag = true;
                break;
            } else if (arr[mid] > a) {
                end = mid - 1;
            } else if (arr[mid] < a) {
                start = mid + 1;
            } else {
                break;
            }
        }
        System.out.println(flag ? "下标为" + mid + 1 : "没有找到");
    }


    public static void bubble() {
        int[] arr = {12, 5, 89, 5, 36, 8, 42, 15, 1, 0, 55};
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
        System.out.println(Arrays.toString(arr));
    }

}
