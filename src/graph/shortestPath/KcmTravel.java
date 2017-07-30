package graph.shortestPath;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class KcmTravel {
    private static ArrayList<Vertex>[] edges;
    private static long[] dist;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("shortestPath2.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder bd = new StringBuilder();

        for (int t = 0; t < Integer.parseInt(st.nextToken()); t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            dist = new long[n];
            edges = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                edges[i] = new ArrayList<>();
            }
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken()) - 1;
                int v = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                edges[u].add(new Vertex(v, c));
            }
            bd.append(dijkstra(m));
        }
    }

    private static String dijkstra(int m) {

        return null;
    }

    private static class Vertex {
        int v;
        int w;

        public Vertex(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
