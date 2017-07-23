package dynamicProgramming;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by junhyeok on 2017-07-21.
 */
public class Wine {
    public static int[][] cost;
    public static int[] arr;
    public static int[] flag;
    public final static int UNVISITED = 0;
    public final static int VISITED = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("wine.txt")));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        flag = new int[n];
        cost = new int[n + 1][n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());
    }

    public static int cal(int n, int wine) {
        if (n == 1) {
            return arr[wine];
        } else if (arr[wine] != 0) {
            return 1;
        }
        return 1;
    }

    public static boolean checkAvailable(int wine) {
        if (wine == 0 && flag[1] == UNVISITED) {
            return true;
        } else if (wine == flag.length - 1 && flag[flag.length - 2] == UNVISITED) {
            return true;
        }
        return false;
    }
}
