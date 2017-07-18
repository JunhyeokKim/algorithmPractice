package dynamicProgramming;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by junhyeok on 2017-07-16.
 */
public class LCS {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("lcs.txt")));
        char[] x = br.readLine().toCharArray();
        char[] y = br.readLine().toCharArray();
        System.out.println(getLcs(x, y));
        br.close();
    }

    public static int getLcs(char[] x, char[] y) {
        int xLen = x.length;
        int yLen = y.length;
        int[][] l = new int[xLen + 1][yLen + 1];

        for (int i = 1; i <= xLen; i++) {
            for (int j = 1; j <= yLen; j++) {
                if (x[i - 1] == y[j - 1]) {
                    l[i][j] = l[i - 1][j - 1] + 1;
                } else {
                    l[i][j] = Math.max(l[i - 1][j], l[i][j - 1]);
                }
            }
        }
        return l[xLen][yLen];
    }
}
