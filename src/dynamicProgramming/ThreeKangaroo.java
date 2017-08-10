package dynamicProgramming;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by acorn on 2017-08-02.
 */
public class ThreeKangaroo {
    private static int[] d;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("threeKangaroo.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        s=2;
        m=6;
        e=15;
        d = new int[e - s + 1];
        System.out.println(Math.max(cal(m - s), cal(e - m)));

    }

    private static int cal(int len) {
        if (len <= 1) {
            return 0;
        } else if (len == 2) {
            return 1;
        } else if (d[len] != 0) {
            return d[len];
        } else {
            int max = 0;
            for (int i = 1; i < len; i++) {
                int temp = Math.max(cal(i), cal(len - i));
                if (max < temp) {
                    max = temp;
                }
            }
            d[len] = max + 1;
            return max + 1;
        }
    }
}
