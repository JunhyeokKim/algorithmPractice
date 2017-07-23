package dynamicProgramming;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by junhyeok on 2017-07-15.
 * Problem No: 11049
 */
public class MatrixMultiply {
    public static int[] p;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("matrixMultiply.txt")));
        int n = Integer.parseInt(br.readLine());
        p = new int[n + 1];
        for (int i = 0; i < n; i++) {
            String[] params = br.readLine().split(" ");
            p[i] = Integer.parseInt(params[0]);
            if (i == n - 1)
                p[i + 1] = Integer.parseInt(params[1]);
        }
        System.out.println(cal(n));
    }

    public static int cal(int n) {
        int[][] m = new int[n + 1][n + 1];
        // i==j는 0으로 초기화 . i<=j인 부분은 사용하지 않는다
        for (int r = 1; r <= n - 1; r++) {      // 대각선 인덱스. i==j인 대각선을 제외한 1~n-1 까지의 대각선이다.
            for (int i = 1; i <= n - r; i++) {  // row 인덱스. 1부터 n-r까지 반복. 이는 대각선 상의 모든 i 인덱스이다.
                int j = i + r;  //대각선 상의 col 인덱스.
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
