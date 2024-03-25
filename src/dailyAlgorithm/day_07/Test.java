package dailyAlgorithm.day_07;


import java.util.*;

/**
 * TODO 有 N件物品和一个容量是 V 的背包。每件物品只能使用一次。 第 i件物品的体积是 vi，价值是 wi。求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。输出最大价值。
 */
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入物品数量(>0)");
        int itemNum = scanner.nextInt();
        System.out.println("请输入背包容积(>0)");
        int cap = scanner.nextInt();
        Item[] items = new Item[itemNum];
        for (int i = 0; i < itemNum; i++) {
            System.out.println("请输入物品体积和价值，空格隔开");
            String[] item = new Scanner(System.in).nextLine().split(" ");
            items[i] = new Item(Integer.parseInt(item[0]), Integer.parseInt(item[1]));
        }

        System.out.println(Arrays.toString(items));


        Item tmp;
        int curVal = 0, curSize = 0;
        ArrayList<Integer> vals = new ArrayList<>();

        for (int i = 0; i < itemNum; i++) {
            int random = new Random().nextInt(itemNum - 1 - i);

            curSize += items[random].getSize();
            if (curSize > cap) {
                vals.add(curVal);
                break;
            }
            curVal += items[random].getValue();

            tmp = items[random];
            items[random] = items[itemNum - 1 - i];
            items[itemNum - 1 - i] = tmp;
        }

        System.out.println(vals);
        Integer[] arr = new Integer[vals.size()];
        bubble(vals.toArray(arr));


        System.out.println(Arrays.toString(arr));
        System.out.println(arr[0]);

    }

    public static void bubble(Integer[] arr) {
        int tmp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }


}


class Item {
    private int size;
    private int value;

    public Item() {
    }

    public Item(int size, int value) {
        this.size = size;
        this.value = value;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getSize() {
        return size;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.size) + ", " + this.value;
    }
}