package dailyAlgorithm.day_05;


import java.util.Map;
import java.util.Scanner;

/**
 * TODO 计算给定非负整数 num 的平方根，要求精确到小数点后 k 位。
 */
public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入数字");
        int num = scanner.nextInt();
        System.out.println("输入小数位数");
        int k = scanner.nextInt();
//        System.out.println("数字" + num + "的平方根为:" + sqrt(num, k));
        System.out.println("数字" + num + "的平方根为:" + mySqrt(num, k));
    }


    /**
     * 用二分法
     *
     * @param num
     * @param k
     * @return
     */
    private static double sqrt(int num, int k) {
        double start = 0;
        double end = num;
        while (end - start > Math.pow(10, -k)) { // 例如，当k=4时，当右边界与左边界的差值小于等于10^-4==>0.0001时，代表中间值已经取到了小数点后四位
            double mid = (end + start) / 2;
            double square = mid * mid;

            if (Math.abs(square - num) < Math.pow(10, -k)) {
                return mid;
            } else if (square < num) {
                start = mid;
            } else {
                end = mid;
            }
        }

        double factor = Math.pow(10, k);
        start = Math.round(start * factor) / factor;
        return start;
    }


    /**
     * 用Math方法，答案并不精确到小数点后k位
     */
    private static double mySqrt(int num, int k) {
        double sqrt = Math.sqrt(num);
        double pow = Math.pow(10, k);
        return Math.round(sqrt * pow) / pow;
    }

}
