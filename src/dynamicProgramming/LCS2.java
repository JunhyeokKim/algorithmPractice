package dynamicProgramming;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by acorn on 2017-08-17.
 */
public class LCS2 {
    static StringBuilder bd = new StringBuilder();
    private static char[] x;
    private static char[] y;
    private static int[][] l;
    private static char[][] path;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input/lcs2.txt")));
        x = br.readLine().toCharArray();
        y = br.readLine().toCharArray();
        getLcs();
        System.out.println(l[x.length][y.length]);
        printLCS(x.length, y.length);
        System.out.println(bd.toString());
    }

    public static void getLcs() {
        int xLen = x.length;
        int yLen = y.length;
        l = new int[xLen + 1][yLen + 1];
        path = new char[xLen + 1][yLen + 1];
        // 0: left, 1: up -1: diagNeg

        for (int i = 1; i <= xLen; i++) {
            for (int j = 1; j <= yLen; j++) {
                if (x[i - 1] == y[j - 1]) {
                    l[i][j] = l[i - 1][j - 1] + 1;
                    path[i][j] = '2';
                } else {
                    if (l[i - 1][j] > l[i][j - 1]) {
                        l[i][j] = l[i - 1][j];
                        path[i][j] = '1';
                    } else {
                        l[i][j] = l[i][j - 1];
                        path[i][j] = '0';
                    }
                }
            }
        }
    }

    private static void printLCS(int xIdx, int yIdx) {
        if (xIdx == 0 || yIdx == 0) {
            return;
        } else {
            if (path[xIdx][yIdx] == '2') {
                printLCS(xIdx-1, yIdx-1);
                bd.append(x[xIdx-1]);
            }
            if (path[xIdx][yIdx] == '0') {
                yIdx--;
                printLCS(xIdx, yIdx);
            } else if (path[xIdx][yIdx] == '1') {
                xIdx--;
                printLCS(xIdx, yIdx);
            }
        }
    }
}
