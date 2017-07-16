package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by junhyeok on 2017-07-15.
 */
public class MatrixMultiply {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n+1];
        for (int i = 0; i < n; i++) {
            String[] params=br.readLine().split(" ");
            p[i] = Integer.parseInt(params[0]);
            if(i==n-1)
                p[i+1]=Integer.parseInt(params[1]);
        }
        System.out.println(cal(n, p));
    }

    public static int cal(int n, int[] p) {
        int[][] m = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++)
            m[i][i] = 0;
        for (int r = 1; r <= n - 1; r++) {
            for (int i = 1; i <= n - r; i++) {
                int j = i + r;
                if (i == j)
                    m[i][j] = 0;
                else {
                    m[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k <= j - 1; k++) {
                        if (m[i][j] > m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j])
                            m[i][j] = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    }
                }
            }
        }
        return m[1][n];
    }

}
