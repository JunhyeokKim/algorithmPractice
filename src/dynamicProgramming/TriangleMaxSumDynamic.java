package dynamicProgramming;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by junhyeok on 2016-10-21.
 */
public class TriangleMaxSumDynamic {
    public static int[][] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("triangleMaxSum.txt")));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < line.length; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }
        System.out.println(findMaxSum(n, arr));
    }

    public static int findMaxSum(int n, int[][] arr) {
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                cost[0][0] = arr[0][0];
                continue;
            }
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    cost[i][j] = cost[i - 1][j] + arr[i][j];
                } else if (j == i) {
                    cost[i][j] = cost[i - 1][j - 1] + arr[i][j];
                } else {
                    cost[i][j] = Math.max(cost[i - 1][j - 1], cost[i - 1][j]) + arr[i][j];
                }
            }
        }
        int max=0;
        for(int i=0; i<n; i++){
            if(max<cost[n-1][i])
                max=cost[n-1][i];
        }

        return max;
    }


}
