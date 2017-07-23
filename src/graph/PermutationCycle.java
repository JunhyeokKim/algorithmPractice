package graph;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by junhyeok on 2017-07-22.
 * Prolem NO: 10451
 */
public class PermutationCycle {
    public static int[] map;
    public static boolean[] visited;
    public static int cycle = 0;
    public static int n = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("permutationCycle.txt")));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            cycle = 0;
            n = Integer.parseInt(br.readLine());
            map = new int[n + 1];
            // map의 특정 원소를 가리키는 인덱스를 i라 할 때, 이는 정점 i에서 정점 map[i]를 연결하는 간선이 존재한다는 의미이다.
            visited = new boolean[n + 1];
            String[] str = br.readLine().split(" ");
            for (int i = 1; i <= n; i++) {
                map[i] = Integer.parseInt(str[i - 1]);
            }
            checkCycle();
            bw.write(cycle + "\n");
        }
        bw.flush();
    }

    public static void checkCycle() {
        List<Integer> r = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    public static void dfs(int v, List<Integer> r) {
        visited[v] = true;
        if (visited[map[v]]) {
            cycle++;
        }
        if (!visited[map[v]]) {
            dfs(map[v]);
        }
        r.add(0, v);
    }

    public static void dfs(int v) {
        visited[v] = true;
        if (visited[map[v]]) {
            cycle++;
        }
        if (!visited[map[v]]) {
            dfs(map[v]);
        }
    }
}
