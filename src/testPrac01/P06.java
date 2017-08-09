package testPrac01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by junhyeok on 2017-08-04.
 */
public class P06 {
    private static int[] house;
    private final static int ATYPE = 1;
    private final static int BTYPE = 2;
    private final static int NONE = 0;
    private final static int MYHOUSE = 3;
    private final static int INF = 987654321;
    private static int[][] map;
    private static int n;
    private static int m;
    private static long[] d;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("testPrac01_input/p06.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder bd = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }
        house = new int[5001];
        d = new long[5001];
        int j = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        house[j] = MYHOUSE;
        for (int i = 0; i < k; i++) {
            int aHouseIdx = Integer.parseInt(st.nextToken());
            house[aHouseIdx] = ATYPE;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int bHouseIdx = Integer.parseInt(st.nextToken());
            house[bHouseIdx] = BTYPE;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int prev = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map[prev][to] = cost;
            map[to][prev] = cost;
        }
        dijkstra(j);
        long minA = INF;
        int minIdxA = -1;
        long minB = INF;
        int minIdxB = -1;
        for (int i = 1; i <= n; i++) {
            if (d[i] < INF) {
                if (house[i] == ATYPE) {
                    if (minA > d[i]) {
                        minA = d[i];
                        minIdxA = i;
                    }
                } else if (house[i] == BTYPE && d[i] < INF) {
                    if (minB > d[i]) {
                        minB = d[i];
                        minIdxB = i;
                    }
                }
            }
        }
        if (minIdxA == -1 && minIdxB == -1) {
            System.out.println(-1);
        } else {
            if (minA <= minB) {
                bd.append("A\n");
                bd.append(minA + "\n");
            } else {
                bd.append("B\n");
                bd.append(minB + "\n");
            }
            System.out.println(bd.toString());
        }
    }

    private static void dijkstra(int j) {
        Arrays.fill(d, INF);
        d[j] = 0;
        PriorityQueue<Edge> queue = new PriorityQueue<>(60000);
        queue.add(new Edge(j, 0));
        while (!queue.isEmpty()) {
            Edge popped = queue.remove();
            ArrayList<Integer> adjEdges = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (map[popped.to][i] < INF) {
                    adjEdges.add(i);
                }
            }
            for (int adjEdge : adjEdges) {
                if (d[adjEdge] > d[popped.to] + map[popped.to][adjEdge]) {
                    d[adjEdge] = d[popped.to] + map[popped.to][adjEdge];
                    queue.add(new Edge(adjEdge, map[popped.to][adjEdge]));
                }
            }
        }

    }

    private static class Edge implements Comparable<Edge> {
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            if (this.cost > o.cost) {
                return 1;
            } else
                return -1;
        }
    }
}
