package dynamicProgramming;

import java.util.Arrays;

/**
 * Created by junhyeok on 2017-07-14.
 */
public class MinimumSumPath {
    public static int[][] sum;

    public static void main(String[] args) {

        int[][] m = {
                {6, 7, 12, 5},
                {5, 3, 11, 8},
                {7, 17, 3, 3},
                {8, 10, 14, 9}
        };
        sum = new int[m.length][m.length];
        System.out.println(findPathRecursive(m, m.length - 1, m.length - 1));

    }

    public static int findPathBtmUp(int[][] matrix) {
        int[][] sum = new int[matrix.length + 1][matrix.length + 1];
        Arrays.fill(sum[0], Integer.MAX_VALUE);
        for (int i = 0; i < matrix.length; i++)
            sum[i][0] = Integer.MAX_VALUE;
        int n = matrix.length;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    sum[i][j] = matrix[0][0];
                } else {
                    sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + matrix[i - 1][j - 1];
                }
            }
        }
        return sum[n][n];

    }

    public static int findPathRecursive(int[][] matrix, int i, int j) {
        if (i == 0 && j == 0) {
            return matrix[0][0];
        }
        if (i == 0) {
            sum[i][j] = findPathRecursive(matrix, i, j - 1) + matrix[i][j];
        } else if (j == 0) {
            sum[i][j] = findPathRecursive(matrix, i - 1, j) + matrix[i][j];
        } else {
            if (sum[i][j] != 0) {
                return sum[i][j];
            }
            sum[i][j] = Math.min(findPathRecursive(matrix, i - 1, j), findPathRecursive(matrix, i, j - 1)) + matrix[i][j];
        }
        return sum[i][j];
    }
}
