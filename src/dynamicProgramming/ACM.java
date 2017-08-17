package dynamicProgramming;

import java.io.*;
import java.util.*;

/**
 * Created by acorn on 2017-08-17.
 */
public class ACM {
    static int[] cost = new int[1001];
    static long[] d = new long[1001];
    static ArrayList<Integer>[] adjList = new ArrayList[1001];
    static Queue<Integer> queue = new LinkedList<>();
    static int[] indegree = new int[1001];
    private static int n;
    private static int k;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input/acm.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder bd = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(st.nextToken());
        int goal;
        for (int i = 0; i < T; i++) {
            st= new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                cost[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 1; j <= k; j++) {
                st = new StringTokenizer(br.readLine());
                int prev = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                if (adjList[prev] == null) {
                    adjList[prev] = new ArrayList<>();
                }
                adjList[prev].add(to);
                indegree[to]++;
            }
            goal = Integer.parseInt(br.readLine());
            topologicalSort();
        }


    }

    private static void topologicalSort() {
        Queue<Integer> noIndegrees = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                noIndegrees.add(i);
            }
        }
        while (!noIndegrees.isEmpty()) {
            int node = noIndegrees.poll();
            System.out.print(node + " ");
            if (adjList[node] != null) {
                for (int outNode : adjList[node]) {
                    indegree[outNode]--;
                    if(indegree[outNode]==0){
                        noIndegrees.add(outNode);
                    }
                }
            }
            adjList[node] = null;
        }
    }

    private static void build(int goal) {
        boolean[] visited = new boolean[1001];
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                int curNode = queue.remove();
                d[curNode] += cost[curNode];
                if (adjList[curNode] != null) {
                    for (int adjNode : adjList[curNode]) {
                        if (visited[adjNode]) {
                            // 다른 node들에 의해 이미
                        }
                    }
                }
            }
        }
    }
}
