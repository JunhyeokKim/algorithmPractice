package graph.mst;


import java.io.*;
import java.util.PriorityQueue;

/**
 * Created by acorn on 2017-07-28.
 */
public class MST {
    public static Edge[] edges;
    public static int[] p;
    public static PriorityQueue<Edge> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("mst.txt")));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = 0;
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        p = new int[n + 1];
        edges = new Edge[m + 1];
        for (int i = 1; i <= m; i++) {
            String[] params = br.readLine().split(" ");
            int u = Integer.parseInt(params[0]);
            int v = Integer.parseInt(params[1]);
            int w = Integer.parseInt(params[2]);
            queue.add(new Edge(u, v, w));
        }
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
        while (!queue.isEmpty() && size < n - 1) {
            Edge edge = queue.peek();
            if (find(edge.u) != find(edge.v)) {
                union(edge.u,edge.v);
            }
        }


    }

    private static void union(int u, int v) {

    }

    private static int find(int u) {
        if (p[u] != u) {
            p[u] = find(p[u]);
        }
        return p[u];
    }

    private static class Edge {
        int u;
        int v;
        int w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
}