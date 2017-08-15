package tree;

import java.io.*;
import java.util.*;

/**
 * Created by junhyeok on 2017-08-13.
 * Problem No: 1167
 * 트리의 지름을 구하는 문제이다.
 * 임의의 두정점의 길이 중 가장 긴 것을 트리의 지름이라고 부른다.
 * 먼저 임의의 정점 x(root 노드로 정해도 된다)로부터 가장 먼 정점  y를 구한다.
 * 그리고 y로부터 가장 먼 정점 t를 구하게 되면, y에서 t까지의 거리는 트리의 지름이 된다.
 */

public class TreeRadius {
    private static ArrayList<Edge>[] adjList;
    private static int n;
    private static long[] d;
    private static boolean[] visited;
    private static long dfsMax = 0;
    private static int dfsIdx;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input/treeHeight.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder bd = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[n + 1];
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
        /*int fromRoot = bfs(1);
        int away = bfs(fromRoot);
        System.out.println(d[away]);*/
        visited = new boolean[n + 1];
        dfs(1, 0);
        visited = new boolean[n + 1];
        dfsMax = 0;
        dfs(dfsIdx, 0);
        System.out.println(dfsMax);
    }

    private static int bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[n + 1];
        visited[s] = true;
        d = new long[n + 1];
        d[s] = 0;
        queue.add(s);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int u = queue.remove();
                if (adjList[u] != null) {
                    for (Edge adjNode : adjList[u]) {
                        if (!visited[adjNode.to]) {
                            queue.add(adjNode.to);
                            visited[adjNode.to] = true;
                            d[adjNode.to] = d[u] + adjNode.len;
                        }
                    }
                }
            }
        }
        long max = 0;
        int idx = s;
        for (int i = 1; i <= n; i++) {
            if (max < d[i]) {
                max = d[i];
                idx = i;
            }
        }
        return idx;
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


 
 
 