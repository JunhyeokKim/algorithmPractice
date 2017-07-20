package dynamicProgramming;

import java.io.*;

/**
 * Created by acorn on 2017-07-20.
 */
public class ACM {
    public final static int AVAILABLE = -1;
    public final static int NOWAY = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("acm.txt")));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] nk = br.readLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            int[] delay = new int[n + 1];
            int[][] map = new int[n + 1][n + 1];
            String[] delayStr = br.readLine().split(" ");
            for (int j = 1; j <= delay.length; j++) {
                delay[j] = Integer.parseInt(delayStr[j]);
            }
            for (int j = 1; j <= k; j++) {
                String[] rule = br.readLine().split(" ");
                int prev = Integer.parseInt(rule[0]);
                int to = Integer.parseInt(rule[1]);
                map[to][prev] = 1;
            }
            int target = Integer.parseInt(br.readLine());
        }
    }
}
