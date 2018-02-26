
public class MergeSort {
    public static void main(String[] args) {
        new Data().sort();
    }
}

class Data {
    public void sort() {
        int arr[] = {29, 10, 14, 37, 14};
        arr = mergeSort(arr, 0, arr.length - 1);
        for (int i : arr)
            System.out.println(i + "  ");
    }

    public int[] mergeSort(int a[], int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            int N = high - low + 1;
            int[] b = new int[high - low + 1];// temporary array,double storage
            int left = low, right = mid + 1, bidx = 0;
            while (left <= mid && right <= high) {
                b[bidx++] = a[left] > a[right] ? a[right++] : a[left++];
            }
            while (left <= mid)
                b[bidx++] = a[left++];
            while (right <= high)
                b[bidx++] = a[right++];

            for (int i = 0; i < N; i++) {
                a[low + i] = b[i];
            }
        }
        return a;
    }

}
