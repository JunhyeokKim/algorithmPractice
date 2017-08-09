package testPrac01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by junhyeok on 2017-08-04.
 */
public class P04 {
    private static ArrayList<Integer>[] edges;
    private static ArrayList<Integer>[] reversedEdges;
    private static int n;
    private static int m;
    private static boolean[] availableFromStart;
    private static boolean[] availableFromEnd;


    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("testPrac01_input/p04.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder bd = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        availableFromStart = new boolean[n + 1];
        availableFromEnd = new boolean[n + 1];
        edges = new ArrayList[n + 1];
        reversedEdges = new ArrayList[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (edges[x] == null) {
                edges[x] = new ArrayList<>();
            }
            edges[x].add(y);
        }
        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> list = edges[i];
            if (list != null) {
                for (int to : list) {
                    if (reversedEdges[to] == null) {
                        reversedEdges[to] = new ArrayList<>();
                    }
                    reversedEdges[to].add(i);
                }
            }
        }
        bfs(edges, availableFromStart, 1);
        bfs(reversedEdges, availableFromEnd, n);
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int bomb = Integer.parseInt(st.nextToken());
            if (availableFromStart[bomb] && availableFromEnd[bomb]) {
                bd.append("Defend the CTP\n");
            } else {
                bd.append("Destroyed the CTP\n");
            }
        }
        System.out.println(bd.toString());

    }

    private static void bfs(ArrayList<Integer>[] whatEdge, boolean[] mark, int start) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int v = queue.remove();
            ArrayList<Integer> adjEdges = whatEdge[v];
            if (adjEdges != null) {
                for (int node : adjEdges) {
                    if (!visited[node]) {
                        queue.add(node);
                        visited[node] = true;
                        mark[node] = true;
                    }
                }
            }
        }
    }

}
