package dynamicProgramming;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by junhyeok on 2017-07-21.
 */
public class Wine {
    public static int[] cost;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("wine.txt")));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        cost = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());
        if (n > 0) {
            cost[0] = arr[0];
        }
        if (n > 1) {
            cost[1] = arr[0] + arr[1];
        }
        if (n > 2) {
            cost[2] = Math.max(Math.max(arr[0] + arr[1], arr[0] + arr[2]), arr[1] + arr[2]);
        }
        System.out.println(cal(n));
    }

    public static int cal(int n) {
        for (int i = 3; i < n; i++) {
            cost[i] = Math.max(Math.max(arr[i] + cost[i - 2], arr[i] + arr[i - 1] + cost[i - 3]), cost[i - 1]);
        }
        return cost[n - 1];
    }

}
