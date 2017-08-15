package tree;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by junhyeok on 2017-08-14.
 */

public class TreeRadius2 {
    private static ArrayList<Edge>[] adjList;
    private static int n;
    private static boolean[] visited;
    private static int dfsMax;
    private static int dfsIdx;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input/treeHeight2.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder bd = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[n + 1];
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            if (adjList[parent] == null) {
                adjList[parent] = new ArrayList<>();
            }
            if (adjList[child] == null) {
                adjList[child] = new ArrayList<>();
            }
            adjList[parent].add(new Edge(child, len));
            adjList[child].add(new Edge(parent, len));
        }
        visited = new boolean[n + 1];
        dfs(1, 0);
        visited = new boolean[n + 1];
        dfsMax = 0;
        dfs(dfsIdx, 0);
        System.out.println(dfsMax);

    }

    private static void dfs(int s, int fromRoot) {
        if (!visited[s]) {
            visited[s] = true;
            if (adjList[s] != null) {
                for (Edge adjNode : adjList[s]) {
                    if (!visited[adjNode.to]) {
                        // leaf node인 경우
                        if (adjList[adjNode.to].size() == 1) {
                            if (dfsMax < fromRoot + adjNode.len) {
                                dfsMax = fromRoot + adjNode.len;
                                dfsIdx = adjNode.to;
                            }
                        } else {
                            dfs(adjNode.to, fromRoot + adjNode.len);
                        }
                    }
                }
            }
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


 
 
 