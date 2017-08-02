package dynamicProgramming;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by acorn on 2017-08-02.
 */
public class ContinuousSum {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("continuousSum.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] d = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        d[0] = arr[0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            if (arr[i] + arr[i - 1] > arr[i]) {
                arr[i] = arr[i] + arr[i - 1];
            } else {
                arr[i] = arr[i];
            }
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println(max);
        /*for (int r = 0; r < n; r++) {
            for (int i = 0; i < n - r; i++) {
                int j = r + i;
                if (r == 0) {
                    d[i][j] = arr[i];
                } else {
                    int max = Integer.MIN_VALUE;
                    int minus = i;
                    for (int k = i; k < j; k++) {
                        int temp;
                        if (d[i][k] >= 0 && d[k + 1][j] >= 0 && arr[k] >= 0 && arr[k + 1] >= 0) {

                            temp = d[i][k] + d[k + 1][j];
                        } else {
                            temp = Math.max(d[i][k], d[k + 1][j]);
                        }
                        if (max < temp) {
                            max = temp;
                        }
                        System.out.println(String.format("r: %d, i: %d, j: %d, k: %d", r, i, j, k));
                    }
                    d[i][j] = max;
                }
            }
        }*/


    }
}
