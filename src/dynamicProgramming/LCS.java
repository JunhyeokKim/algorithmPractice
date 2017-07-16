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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("lcs.txt")));
        while (true) {
            String sequences = br.readLine();
            if (sequences == null || sequences.equals(""))
                break;
            else {
                String x = null, y = null;
                for (int i = 0; i < sequences.length(); i++) {
                    if (sequences.charAt(i) == ' ') {
                        x = sequences.substring(0, i);
                        y = sequences.substring(i + 1, sequences.length());
                        break;
                    }
                }
                x = x.trim();
                y = y.trim();
                System.out.println(getLcs(x, y));
            }
        }
        br.close();
    }

    public static int getLcs(String x, String y) {
        int xLen = x.length();
        int yLen = y.length();
        int[][] l = new int[xLen + 1][yLen + 1];

        for (int i = 1; i <= xLen; i++) {
            for (int j = 1; j <= yLen; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    l[i][j] = l[i - 1][j - 1] + 1;
                } else {
                    l[i][j] = Math.max(l[i - 1][j], l[i][j - 1]);
                }
            }
        }
        return l[xLen][yLen];
    }
}
