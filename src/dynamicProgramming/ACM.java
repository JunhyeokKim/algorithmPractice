package dynamicProgramming;

import java.io.*;
import java.util.*;

/**
 * Created by jhKim on 2017-08-17.
 * Problem No: 1005
 * ACM:
 * memoization 과 dfs를 활용하여 풀 수 있거나, 혹은 위상 정렬을 통해 풀 수 있다.
 * 성능상에서는 위상정렬은 모든 정점들을 모두 방문해야 하기 때문에 도착점에서 dfs를 수행하는 것이 성능에서는 더 좋다.
 * 위상 정렬, dp를 활용한 방법
 * 1. 각 노드의 indegree의 개수를 count한다.
 * 2. 위상정렬을 수행한다. 먼저 indegree가 0인 정점들을 큐에 삽입한 뒤,
 * 그 노드들을 방문하면서 outdegree로 연결된 outnode의 indegree의 개수를 감소시키고, 진출하는 간선을 제거한다.
 * outNode에 대해서 indegree를 감소시킬 때, d[outNode]<d[node]+cost[outNode]를 비교하여 최대값을 갖는 것으로 갱신한다.
 * 이를 큐가 빌때까지 반복
 * dfs, dp를 활용한 방법
 * 이때는 간선의 연결을 역방향으로 설정한다. 그래야 goal부터 dfs를 진행할 수 있다.
 *
 */
public class ACM {
    static int[] cost;
    static ArrayList<Integer>[] adjList;
    static int[] dis;
    /*static int[] indegree = new int[1001];*/

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input/acm.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder bd = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            cost = new int[n + 1];
            adjList = new ArrayList[n + 1];
            dis = new int[n + 1];
            Arrays.fill(dis, -1);
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                cost[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 1; j <= k; j++) {
                st = new StringTokenizer(br.readLine());
                int prev = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                /*
                위상정렬을 통한 방법
                if (adjList[prev] == null) {
                    adjList[prev] = new LinkedList<>();
                }
                adjList[prev].add(to);
                indegree[to]++;*/
                if (adjList[to] == null) {
                    adjList[to] = new ArrayList<>();
                }
                adjList[to].add(prev);
            }
            int goal = Integer.parseInt(br.readLine());
            /*bd.append(topologicalSort(goal, n) + "\n");*/
            System.out.println(findDfs(goal));
        }
        System.out.println(bd.toString());


    }

    private static int findDfs(int x) {
        if (dis[x] != -1) {
            return dis[x];
        } else {
            int res = 0;
            if (adjList[x] != null) {
                for (int adjNode : adjList[x]) {
                    res = Math.max(res, findDfs(adjNode));
                }
            }
            res += cost[x];
            return dis[x] = res;
        }
    }

    /*private static long topologicalSort(int goal, int n) {
        long[] d = new long[1001];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                // 초기 indegree가 0인 node들을 queue에 삽입한다.
                queue.add(i);
                d[i] = cost[i];
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            *//*System.out.print(node + " ");*//*
            if (adjList[node] != null) {
                for (int outNode : adjList[node]) {
                    if (d[outNode] < d[node] + cost[outNode]) {
                        d[outNode] = d[node] + cost[outNode];
                    }
                    indegree[outNode]--;
                    if (indegree[outNode] == 0) {
                        queue.add(outNode);
                    }
                }
            }
            adjList[node] = null;
        }
        return d[goal];
    }*/

}
