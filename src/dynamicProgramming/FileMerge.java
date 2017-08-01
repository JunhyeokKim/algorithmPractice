package dynamicProgramming;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by junhyeok on 2017-08-01.
 * Problem No: 11066
 */
public class FileMerge {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("fileMerge.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] c = new int[k];
            for (int i = 0; i < k; i++) {
                c[i] = Integer.parseInt(st.nextToken());
            }
            bw.write(solve(k, c) + "\n");
        }
        bw.flush();
    }

    private static int solve(int k, int[] c) {
        int[][] d = new int[k][k];
        int[] sum = new int[k];
        sum[0] = c[0];
        // 부분합을 초기화한다.
        for (int i = 1; i < k; i++) {
            sum[i] += sum[i - 1] + c[i];
        }
        // r: 대각선의 index
        for (int r = 1; r < k; r++) {
            // i: row index
            for (int i = 0; i < k - r; i++) {
                // j: col index
                int j = i + r;
                if (r == 1) {
                    d[i][j] = c[i] + c[j];
                } else {
                    int min = Integer.MAX_VALUE;
                    // 행렬곱 문제와 동일한 방식이다.
                    for (int t = i; t < j; t++) {
                        if (d[i][t] + d[t + 1][j] < min) {
                            min = d[i][t] + d[t + 1][j];
                        }
                    }
                    // i~j의 부분합을 더해준다.
                    d[i][j] = min + sum[j];
                    if (i != 0) {
                        d[i][j] -= sum[i - 1];
                    }
                }
            }
        }
        return d[0][k - 1];
    }
}
