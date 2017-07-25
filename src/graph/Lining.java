package graph;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by junhyeok on 2017-07-25.
 */
public class Lining {
    public static boolean[] visited;
    public static int n;
    public static int[][] map;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("lining.txt")));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            String[] str = br.readLine().split(" ");
            map[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = 1;
        }
        sort();
    }

    public static void sort() throws IOException {
        List<Integer> list = new LinkedList<>();
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i, list);
            }
        }
        for (int v : list
                ) {
            bw.write(v+" ");
        }
        bw.flush();
    }

    public static void dfs(int v, List list) {
        visited[v] = true;
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && map[v][i] == 1) {
                dfs(i, list);
            }
        }
        list.add(0, v);
    }
}
