package graph;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by jhKim on 2017-08-11.
 */
public class Wave {
    private static long[] d = new long[101];

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input/wave.txt")));
        StringBuilder bd = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[] nums = new int[T];
        int max = 0;

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            nums[i] = n;
            if (n > max) {
                max = n;
            }
            /*bw.write(cal(n) + "\n");*/
        }
        br.close();
        cal(max);
        for (int i = 0; i < T; i++) {
            bd.append(d[nums[i]] + "\n");
        }
        System.out.println(bd.toString());
    }

    private static void cal(int n) {
        d[1] = 1;
        d[2] = 1;
        d[3] = 1;
        d[4] = 2;
        d[5] = 2;
        for (int i = 6; i <= n; i++) {
            d[i] = d[i - 1] + d[i - 5];
        }
    }
}
