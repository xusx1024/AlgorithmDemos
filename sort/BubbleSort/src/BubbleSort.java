class Bubble {
    public static void main(String[] args) {
        new Data().sort();
    }
}

class Data {
    public void sort() {
        int arr[] = {29, 10, 14, 37, 14};
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i : arr)
            System.out.print(i + "  ");
    }
}