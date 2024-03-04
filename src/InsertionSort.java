public class InsertionSort {
    public static void insertionSort(int[] arr) {
        // 获取数组长度
        int n = arr.length;

        // 从第二个元素开始，依次将元素插入到已排序部分的合适位置
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // 当前待插入的元素
            int j = i - 1; // 已排序部分的最后一个元素的索引

            // 将大于key的元素向右移动，为key腾出插入位置
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]; // 向右移动元素
                j--;
            }

            arr[j + 1] = key; // 插入key到正确位置
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};

        System.out.println("Original array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        insertionSort(arr); // 调用插入排序算法

        System.out.println("\nSorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
