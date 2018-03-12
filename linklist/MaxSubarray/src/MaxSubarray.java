public class MaxSubarray {
    public static void main(String[] args) {
        MaxSubarray maxSubarray = new MaxSubarray();
        int[] arr = {1, -2, 3, 10, -4, 7, 2, -5};
        maxSubarray.fun1(arr);
        System.out.println("fun2:" + maxSubarray.fun2(arr, 0, arr.length - 1));
        maxSubarray.fun3(arr);
        maxSubarray.fun4(arr);
    }

    void fun1(int[] arr) {//  线性时间法
        int max = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > max)
                max = sum;
            if (sum < 0)
                sum = 0;
        }
        System.out.println("fun1:" + max);
    }

    int fun2(int[] arr, int low, int high) {// 动态规划法
        if (low >= high) return arr[low];
        int mid = (high + low) / 2;
        int lmax = fun2(arr, low, mid);
        int rmax = fun2(arr, mid + 1, high);

        int mmax = arr[mid];
        int ans = mmax;

        for (int i = mid - 1; i >= low; i--) {//跨越中点的,左半边的最大数组和
            ans += arr[i];
            mmax = mmax < ans ? ans : mmax;
        }

        ans = mmax;

        for (int i = mid + 1; i < high; i++) {//跨越中点的,右半边的最大数组和
            ans += arr[i];
            mmax = mmax < ans ? ans : mmax;
        }

        // 左边,右边,跨越中点的一部分,三者比较得出最大的数组和
        int t = lmax > rmax ? lmax : rmax;
        ans = t > mmax ? t : mmax;

        return ans;

    }

    // 双重循环,记录累加的和
    void fun3(int[] arr) {//暴力求解法
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum > max)
                    max = sum;
            }
        }
        System.out.println("fun3:" + max);
    }

    // 顺序叠加元素,一旦和为负数,就清空重新叠加
    void fun4(int[] arr) {// 线性时间法
        int[] C = new int[arr.length];
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            if (C[i - 1] > 0) {
                C[i] = C[i - 1] + arr[i];
            } else {
                C[i] = arr[i];
            }

            max = C[i] > max ? C[i] : max;
        }
        System.out.println("fun4:" + max);
    }
}

