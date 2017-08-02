package dynamicProgramming;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by acorn on 2017-08-02.
 */
public class ThreeKangaroo {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("threeKangaroo.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int t = s - 1;
        s -= t;
        m -= t;
        e -= t;
        int[][] d = new int[e + 1][e + 1];
        d[2][1] = 1;
        int[] best = new int[e + 1];
        best[2] = 1;
        // 길이
        for (int i = s; i <= e; i++) {
            // 중간점
            int max = 0;
            for (int j = 1; j < e; j++) {
                if (i > j) {
                    if (max < Math.max(best[j], best[i - j])) {
                        max = Math.max(best[j], best[i - j])+1;
                    }
                    d[i][j] = Math.max(best[j], best[i - j])+1;
                }
            }
            best[i] = max;
        }
    }
}
