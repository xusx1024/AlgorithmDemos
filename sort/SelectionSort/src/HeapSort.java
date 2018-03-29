/**
 * 1.字母序
 * 2.数字序
 */
public class HeapSort {

    static String[] sort = new String[]{"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
//    static int[] sort = new int[]{2,6,12,0,9,5,17};

    public static void main(String[] args) {
        buildMaxHeap(sort);
        heapSort(sort);
        for (String s : sort) {
            System.out.println(s);
        }
    }

    private static void buildMaxHeap(String data[]) {
        // 树的根节点从0开始.和数组的下标保持一致.
        int startIndex = (int) Math.ceil(data.length - 1) / 2;// 从二叉堆的倒数第二层开始,最后一层是叶子
//        startIndex = data.length - 1;// 从二叉堆最后也可开始,会白白循环
        for (int i = startIndex; i >= 0; i--) {
            maxHeap(data, data.length, i);
        }
    }

    private static void maxHeap(String[] data, int heapSize, int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        int largest = index;
        if (left < heapSize && data[index].compareTo(data[left]) < 0) {
            largest = left;
        }
        if (right < heapSize && data[largest].compareTo(data[right]) < 0) {
            largest = right;
        }
        if (largest != index) {
            String temp = data[index];
            data[index] = data[largest];
            data[largest] = temp;
            maxHeap(data, heapSize, largest);
        }
    }

    private static void heapSort(String[] data) {
        for (int i = data.length - 1; i > 0; i--) {
            String temp = data[0];
            data[0] = data[i];
            data[i] = temp;
            maxHeap(data, i, 0);
        }
    }
}
