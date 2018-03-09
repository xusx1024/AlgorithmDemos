
public class ShellSort {
    public static void main(String[] args) {
        ShellSort ss = new ShellSort();
        int arr[] = {29, 10, 14, 37, 14};
        ss.standardSort(arr, 5);
        for (int i : arr)
            System.out.print(i + " ");
    }


    // 严格按照定义来实现
      void standardSort(int[] arr, int n) {
        int i, j, gap;
        for (gap = n / 2; gap > 0; gap /= 2) {
            for (i = 0; i < gap; i++) {
                for (j = i + gap; j < n; j += gap) {
                    if (arr[j] < arr[j - gap]) {
                        int temp = arr[j];
                        int k = j - gap;
                        while (k >= 0 && arr[k] > temp) {
                            arr[k + gap] = arr[k];
                            k -= gap;
                        }
                        arr[k + gap] = temp;
                    }
                }
            }
        }
    }


}
