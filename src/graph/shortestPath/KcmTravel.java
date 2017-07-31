package graph.shortestPath;
/*
* Created by JhKim
* Problem No: 10217
* dp와 dijkstra를 이용한 조건 내 최단거리 비용 계산 문제이다. 경로의 길이 d 외에 추가적으로 운임 비용인 c가 추가되어, 비용이 c원 이하임을 유지한 채 최단 거리를 구해야 한다.
*
*
* */
import java.io.*;
import java.util.*;

public class KcmTravel {
    private static ArrayList<Edge>[] edges;
    private static int[][] dist;
    private final static int INF = 987654321;
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("kcmTravel.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            dist = new int[n][m + 1];
            edges = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                edges[i] = new ArrayList<>();
            }
            for (int i = 0; i < n; i++) {
                Arrays.fill(dist[i], INF);
                dist[i][0] = 0;
            }
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken()) - 1;
                int v = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                edges[u].add(new Edge(v, c, d));
            }
            /*int ans = dfs(0, 0, 0);
            if (ans < INF) {
                bw.write(ans + "\n");
            } else {
                bw.write("Poor KCM\n");
            }*/
            int min=dijkstra(n, m);
            if (min< INF) {
                bw.write(min+ "\n");
            } else {
                bw.write("Poor KCM\n");
            }
        }
        bw.flush();
    }

    private static int dijkstra(int n, int m) {
        int cost;
        int min = INF;
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(0, 0, 0));
        while (!queue.isEmpty()) {
            Edge popped = queue.remove();
            int u = popped.v;
            cost = popped.c;
            ArrayList<Edge> adjEdges = edges[u];
            if (adjEdges != null) {
                for (Edge adjEdge : adjEdges) {
                    // cost의 합이 m보다 작은 경우에만 최단 거리를 기록한다.
                    if (cost + adjEdge.c <= m) {
                        int newDis = dist[u][cost] + adjEdge.d;
                        if (adjEdge.v == n - 1) {
                            if (min > newDis) {
                                min = newDis;
                            }else{
                                continue;
                            }
                        }
                        if (dist[adjEdge.v][cost + adjEdge.c] > newDis) {
                            dist[adjEdge.v][cost + adjEdge.c] = newDis;
                            queue.add(new Edge(adjEdge.v, cost + adjEdge.c, newDis));
                        }
                    }
                }
            }
        }
        return min;
    }


    private static int dfs(int v, int cost, int distance) {
        if (cost > m) {
            return INF;
        } else if (v == n - 1) {
            return distance;
        } else {
            int min = INF;
            ArrayList<Edge> adjEdges = edges[v];
            if (adjEdges != null) {
                for (Edge adjEdge : adjEdges) {
                    int resultDistance = dfs(adjEdge.v, adjEdge.c + cost, distance + adjEdge.d);
                    if (resultDistance != INF && resultDistance < min) {
                        min = resultDistance;
                    }
                }
            }
            if (min != INF)
                return min;
            else
                return INF;
        }
    }

    private static class Edge implements Comparable<Edge> {
        int v;      // 정점
        int c;      // 비용
        int d;      // 거리

        public Edge(int v, int c, int d) {
            this.v = v;
            this.c = c;
            this.d = d;
        }

        @Override
        public int compareTo(Edge o) {
            if (this.d > o.d) {
                return 1;
            } else {
                return -1;
            }
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "v=" + v +
                    ", c=" + c +
                    ", d=" + d +
                    '}';
        }
    }
}
