public class CountingSort {
    public static void main(String[] args) {
        new Data().sort3();
    }
}

class Data {

    // 自己想的
    public void sort2() {
        int A[] = {1, 0, 3, 1, 0, 1, 1};
        int C[] = new int[max(A) + 1];// 空间少一点
        for (int i : A) {
            C[i]++;
        }
        for (int i = 0; i < C.length; i++) {
            for (int j = 1; j <= C[i]; j++) {
                System.out.println(i + " ");
            }
        }
    }

    int max(int[] arr) {
        int max = arr[0];
        for (int i : arr) {
            if (max < i)
                max = i;
        }
        return max;
    }

    // 算法导论
    public void sort3() {
        int A[] = {1, 0, 3, 1, 0, 1, 1};
        int B[] = new int[A.length];
        int k = max(A) + 1;
        int C[] = new int[k];

        for (int i : A) {
            C[i]++;
        }

        // 思考:此处为什么保证了稳定性?
        for (int i = 1; i < k; i++) {
            C[i] = C[i] + C[i - 1];
        }

        for (int i = A.length - 1; i >= 0; i--) {
            B[C[A[i]]-1] = A[i];
            C[A[i]] = C[A[i]] - 1;
        }

        for (int i : B)
            System.out.print(i + " ");
    }
}
