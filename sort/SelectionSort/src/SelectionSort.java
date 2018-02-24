public class SelectionSort {
    public static void main(String[] args) {
        new Data().sort();
    }
}

class Data {
    public void sort() {
        int arr[] = {29, 10, 14, 37, 14};
        int min = arr[0];
        int idx = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    idx = j;
                }
            }
            if (min < arr[i]) {
                arr[idx] = arr[i];
                arr[i] = min;
            }
        }
        for (int i : arr)
            System.out.print(i + " ");
    }
}
