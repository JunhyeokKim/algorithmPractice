package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by acorn on 2017-07-20.
 */
public class StepNumber {
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 5;
        arr = new int[n + 1][10];
        System.out.println(answer(n));
    }

    private static int answer(int n) {
        if (n == 1)
            return 9;
        Arrays.fill(arr[1], 1);
        arr[1][0] = 0;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    arr[i][j] = arr[i - 1][j + 1]% 1000000000;
                } else if (j == 9) {
                    arr[i][j] = arr[i - 1][j - 1]% 1000000000;
                } else {
                    arr[i][j] = (arr[i - 1][j - 1] + arr[i - 1][j + 1]) % 1000000000;
                }
            }
        }
        for (int i = 0; i <= 9; i++)
            sum = (sum + arr[n][i])% 1000000000;
        return sum;
    }
}
