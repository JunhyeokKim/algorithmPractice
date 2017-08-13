package tree;

import java.io.*;
import java.util.*;

/**
 * Created by junhyeok on 2017-08-13.
 */

public class TreeHeight {
    private static ArrayList<Edge>[] adjList;
    static boolean[] visited;
    static long[][] dist;
    static long[] rDist;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input/treeHeight.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder bd = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        adjList = new ArrayList[n + 1];
        dist = new long[n + 1][n + 1];
        rDist = new long[n + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            if (adjList[u] == null) {
                adjList[u] = new ArrayList<>();
            }
            while (true) {
                int v = Integer.parseInt(st.nextToken());
                if (v == -1) {
                    break;
                } else {
                    int len = Integer.parseInt(st.nextToken());
                    adjList[u].add(new Edge(v, len));
                }

            }
        }
        long max = 0;
        for (int i = 1; i <= n; i++) {
            long r = dfs(i);
            if (r > max) {
                max = r;
            }
        }
        System.out.println(max);
    }

    private static long dfs(int s) {
        if (visited[s]) {
            return 0;
        } else {
            visited[s] = true;
            long max = 0;
            int maxIdx = -1;
            if (adjList[s] != null) {
                PriorityQueue queue= new PriorityQueue();
                for (Edge edge : adjList[s]) {
                    if (!visited[edge.to]) {
                        long childLength = dfs(edge.to);
                        queue.add(childLength+)
                        if (max < edge.len + childLength) {
                            max = edge.len + childLength;
                            maxIdx = edge.to;
                        }
                    }
                }
            }
            if (maxIdx != -1) {
                dist[s][maxIdx] = max;
                dist[maxIdx][s] = max;
            }

            return max;
        }
    }


    private static class Edge {
        int to;
        int len;

        public Edge(int to, int len) {
            this.to = to;
            this.len = len;
        }
    }
}


 
 
 