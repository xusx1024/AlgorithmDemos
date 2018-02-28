/**
 * 基数排序
 *
 * @author sxx.xu
 */
public class RadixSort {

    private static int getMax(int[] array) {
        int max = array[0];
        for (int i : array) {
            max = i > max ? i : max;
        }
        return max;
    }

    public static void radixSort(int[] array) {
        int exp = 1;// 个、十、百、千。。。位
        int max = getMax(array);

        for (exp = 1; max / exp > 0; exp *= 10)
            countSort(array, exp);
    }

    private static void countSort(int[] array, int exp) {

        int[] outputs = new int[array.length];
        int[] buckets = new int[10];// 0-9

        //统计array中对应位数的元素的个数
        for (int i : array) {
            buckets[(i / exp) % 10]++;
        }
        //统计array中，小于该位的元素的个数，相当于排序
        for (int i = 1; i < buckets.length; i++) {
            buckets[i] += buckets[i - 1];
        }
        //赋值
        for (int i = array.length - 1; i >= 0; i--) {
            int item = array[i];
            int idx = buckets[item / exp % 10] - 1;
            //
            outputs[buckets[(array[i] / exp) % 10] - 1] = array[i];
            buckets[(array[i] / exp) % 10]--;
        }

        for (int i = 0; i < outputs.length; i++) {
            array[i] = outputs[i];
        }
    }

    private static void radixSort(int[] array, int d) {
        int n = 1;// 个、十、百、千。。。位
        int k = 0;// 保存每一位排序后的结果用于下一位的排序输入
        int length = array.length;
        int[][] bucket = new int[10][length];// 排序桶用于保存每次排序后的结果，这一位上排序结果相同的数字放在同一个桶里
        int[] order = new int[length];// 用于保存每个桶里有多少个数字
        while (n <= d) {
            for (int num : array) {// 将数组array里的每个数字放在相应的桶里
                int digit = (num / n) % 10;
                bucket[digit][order[digit]] = num;
                order[digit]++;
            }
            for (int i = 0; i < length; i++) {// 将前一个循环生成的桶里的数据覆盖到原数组中用于保存这一位的排序结果
                if (order[i] != 0) {// 这个桶里有数据，从上到下遍历这个桶并将数据保存到原数组中
                    for (int j = 0; j < order[i]; j++) {
                        array[k] = bucket[i][j];
                        k++;
                    }
                }
                order[i] = 0;// 将桶里计数器置0，用于下一次位排序
            }
            n *= 10;
            k = 0;// 将k置0，用于下一轮保存位排序结果
        }

    }

    public static void main(String[] args) {
        int array[] = {53, 3, 542, 748, 14, 214, 154, 63, 616, 70};
        for (int i : array) {
            System.out.print(i + "  ");
        }
        System.out.println("");
        System.out.println("before===================================after");
        radixSort(array);
        for (int i : array) {
            System.out.print(i + "  ");
        }
        int[] A = new int[]{53, 3, 542, 748, 14, 214, 154, 63, 616, 70};
        radixSort(A, 100);
        System.out.println("");
        for (int i : A) {
            System.out.print(i + "  ");
        }
    }
}