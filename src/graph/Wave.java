package graph;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by acorn on 2017-08-11.
 */
public class Wave {
    private static int[] d = new int[101];

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input/wave.txt")));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        d[1] = 1;
        d[2] = 1;
        d[3] = 1;
        d[4] = 2;
        d[5] = 2;
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(cal(n) + "\n");
        }
        bw.flush();
    }

    private static int cal(int n) {
        if (d[n] != 0) {
            return d[n];
        }
        for (int i = 6; i <= n; i++) {
            d[i] = d[i - 1];
            for (int j = 1; ; j++) {
                if (i  - (5 * j) >= 1) {
                    d[i] += d[i  - (5 * j)];
                } else {
                    break;
                }
            }
        }
        return d[n];
    }
}
