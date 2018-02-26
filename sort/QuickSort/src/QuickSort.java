public class QuickSort {
    public static void main(String[] args) {
        new Data().sort();
    }
}

class Data {

    public void sort() {

        int arr[] = {29, 10, 14, 37, 14};
        arr = quickSort(arr, 0, arr.length - 1);
        for (int i : arr)
            System.out.println(i + " ");

    }

    public int[] quickSort(int a[], int low, int high) {
        if (low < high) {
            int p = a[low];
            int m = low;
            int temp;
            for (int i = low + 1; i <= high; i++) {
                if (a[i] < p) {
                    m++;
                    temp = a[i];
                    a[i] = a[m];
                    a[m] = temp;
                }
            }
            temp = a[low];
            a[low] = a[m];
            a[m] = temp;

            quickSort(a, low, m - 1);
            quickSort(a, m + 1, high);
        }
        return a;
    }
}
