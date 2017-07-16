package dynamicProgramming;

import java.util.Arrays;

/**
 * Created by junhyeok on 2017-07-14.
 */
public class Binomial {
    public static int[][] arr;

    public static void main(String[] args) {
        int n = 32;
        int k = 17;
        arr = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(arr[i], -1);
        }
        double s;
        double e;

        s = System.nanoTime();
        System.out.println(binomialTopDown(n, k));
        e = System.nanoTime();
        System.out.println("수행 시간: " + (e - s) / 1000000000);
        s = System.nanoTime();
        System.out.println(binomialBottomUp(n, k));
        e = System.nanoTime();
        System.out.println("수행 시간: " + (e - s) / 1000000000);
        s = System.nanoTime();
        System.out.println(binomial(n, k));
        e = System.nanoTime();
        System.out.println("수행 시간: " + (e - s) / 1000000000);
    }

    public static int binomial(int n, int k) {
        if (n == k || k == 0) {
            return 1;
        } else {
            return binomial(n - 1, k) + binomial(n - 1, k - 1);
        }
    }

    public static int binomialTopDown(int n, int k) {
        if (n == k || k == 0) {
            arr[n][k] = 1;
            return 1;
        } else if (arr[n][k] > -1) {
            return arr[n][k];
        } else {
            arr[n][k] = binomialTopDown(n - 1, k) + binomialTopDown(n - 1, k - 1);
            return arr[n][k];
        }
    }

    public static int binomialBottomUp(int n, int k) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (n == k || k == 0) {
                    arr[n][k] = 1;
                }
                arr[n][k] = arr[n - 1][k - 1] + arr[n - 1][k];
            }
        }
        return arr[n][k];
    }
}
