public class InsertionSort {
    public static void main(String[] args) {
        new Data().sort();
    }
}

class Data {
    public void sort() {
        int arr[] = {29, 10, 14, 37, 14};

        // for implemention
//        for (int i = 1; i < arr.length; i++) {
//            int curr = arr[i];
//            int idx = i - 1;
//            for (int j = idx; j >= 0 && arr[j] > curr; j--) {
//                arr[j + 1] = arr[j];
//                idx = j-1;
//            }
//            arr[idx + 1] = curr;
//            System.out.println(curr);
//        }

// while implemention
//        for (int i = 1; i < arr.length; i++) {
//            int currentNumber = arr[i];
//            int j = i - 1;
//            while (j >= 0 && arr[j] > currentNumber) {
//                arr[j + 1] = arr[j];
//                j--;
//            }
//            arr[j + 1] = currentNumber;
//
//            System.out.println(currentNumber);
//        }

        for (int i : arr)
            System.out.print(i + " ");

    }
}