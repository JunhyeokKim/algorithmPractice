package dynamicProgramming;

import java.io.*;

/**
 * Created by acorn on 2017-07-20.
 * Problem No: 2579
 */
public class Step {
    public static int[][] cost;
    public static int[] step;

    public static void main(String[] args) throws IOException {
        //ufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("step.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        step = new int[n + 1];
        cost = new int[n + 1][2];
        for (int i = 1; i <= n; i++)
            step[i] = Integer.parseInt(br.readLine());
        System.out.println(getStepMax2(n));
    }

    public static int getStepMax2(int n) {
        cost[1][1] = 0;
        cost[1][0] = step[1];
        cost[2][1] = step[2];
        cost[2][0] = step[1] + step[2];
        for (int i = 3; i <= n; i++) {
            cost[i][1] = step[i] + cost[i - 2][0];
            cost[i][0] = step[i] + Math.max(cost[i-1][1], cost[i-2][0]);
        }
        return cost[n][0];
    }


}
