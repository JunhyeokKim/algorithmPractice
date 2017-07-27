package graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by acorn on 2017-07-27.
 */
public class Virus {
    public static int n;
    public static int m;
    public static int[][] map;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("virus.txt")));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            String[] param = br.readLine().split(" ");
            map[Integer.parseInt(param[0])][Integer.parseInt(param[1])] = 1;
            map[Integer.parseInt(param[1])][Integer.parseInt(param[0])] = 1;
        }
        bw.write((bfs(1)) + "\n");
        bw.flush();
    }

    public static int dfs(int v) {
        visited[v] = true;
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && map[i][v] == 1) {
                sum += dfs(i);
            }
        }
        return sum - 1;
    }

    public static int bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        int sum = 0;
        visited[v] = true;
        while (!queue.isEmpty()) {
            int s = queue.remove();
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && map[s][i] == 1) {
                    queue.add(i);
                    sum++;
                    visited[i] = true;
                }
            }
        }
        return sum;
    }
}
