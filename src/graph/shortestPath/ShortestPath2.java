package graph.shortestPath;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by junhyeok on 2017-07-30.
 * Problem No:1504
 */
public class ShortestPath2 {
    // 최단거리의 INF값. 보통 987654321을 쓴다고 한다.
    public final static long INF = 300000000;
    // s, e1, e2의 출발점에서의 최단 거리를 저장하기 위함
    private static long[][] d = new long[3][801];
    private static int n;
    private static int e;
    private static int[][] map = new int[801][801];

    static {
        for (int i = 0; i < 3; i++) {
            Arrays.fill(d[i], INF);
        }
    }

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("shortestPath2.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int prev = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            map[prev][to] = w;
            map[to][prev] = w;
        }

        st = new StringTokenizer(br.readLine(), " ");
        int e1 = Integer.parseInt(st.nextToken());
        int e2 = Integer.parseInt(st.nextToken());
        dijkstra(1, 0);
        dijkstra(e1, 1);
        dijkstra(e2, 2);
        long dist1 = d[0][e1] + d[1][e2] + d[2][n];
        long dist2 = d[0][e2] + d[2][e1] + d[1][n];
        long result = Math.min(dist1, dist2);
        if (result >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }


    public static void dijkstra(int start, int idx) {
        d[idx][start] = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (int i = 1; i <= n; i++) {
                if (map[v][i] != 0 && d[idx][i] > d[idx][v] + map[v][i]) {
                    d[idx][i] = d[idx][v] + map[v][i];
                    queue.add(i);
                }
            }
        }
    }
}
