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
    public static boolean[] visited;
    public final static int UNVISITED = 0;
    public final static int VISITED = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("wine.txt")));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n];
        cost = new int[n][n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());
        System.out.println(cal(n));
    }

    public static int cal(int n) {
        for (int i = 0; i < n; i++)
            cost[i][i] = arr[i];
        for (int r = 1; r < n; r++) {
            for (int i = 0; i < n - r; i++) {
                int j = r;
                int n1 = cost[i][j - 1] + (check(i, j - 1, j) ? arr[j] : 0);
                int n2 = cost[i + 1][j] + (check(i + 1, j, i) ? arr[i] : 0);
                if (n1 > n2) {
                    visited[j] = true;
                    cost[i][j] = n1;
                } else {
                    visited[i] = true;
                    cost[i][j] = n2;
                }
            }
        }
        return cost[0][n - 1];
    }

    public static boolean check(int addIdx, int s, int e) {
        if (addIdx < s) {
            if (!visited[s]) {
                return true;
            } else if (s + 1 <= e && !visited[s + 1]) {
                return true;
            }
        } else {
            if (!visited[e]) {
                return true;
            } else if (e - 1 >= s && !visited[e - 1]) {
                return true;
            }
        }
        return false;
    }
}
