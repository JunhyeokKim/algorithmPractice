package graph;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by jhKim on 2017-08-03.
 * Problem No: 2150
 * 가중치가 없는 방향그래프에서의 SCC(강연결요소)를 검출하기 위한 알고리즘이다.
 * SCC를 수행하게 되면 같은 SCC 내에서의 정점에 대하여 같은 도달 가능한 정점의 개수를 가지게 되기 때문에 중복 계산을 피할 수 있다.
 * 1. dfs를 통해 그래프를 탐색하며 깊이가 깊은 것 먼저 스택에 push한다
 * 2. 그래프 G의 각 에지의 역방향으로 연결된 G'를 생성
 * 3. stack의 정점들을 하나씩 꺼내어서 마찬가지로 dfs를 수행한다. 이 때 스택에서 꺼낸 값 s에 대해 dfs를 수행하게 되면 dfs가 종료되기 까지의 모든 정점들은
 * s와 같은 SCC이다.
 */
public class SCC {
    private static ArrayList<Integer>[] edges;
    private static ArrayList<Integer>[] reverseEdges;
    private static Stack<Integer> stack = new Stack<>();
    private static boolean[] visited;
    private static ArrayList<ArrayList<Integer>> p;
    private static int[] min;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("scc.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        edges = new ArrayList[n + 1];
        reverseEdges = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        p = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int prev = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            if (edges[prev] == null) {
                edges[prev] = new ArrayList<>();
            }
            edges[prev].add(to);
        }
        // dfs를 수행하며 stack에 값을 push한다.
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (edges[i] != null) {
                for (int to : edges[i]) {
                    if (reverseEdges[to] == null) {
                        reverseEdges[to] = new ArrayList<>();
                    }
                    reverseEdges[to].add(i);
                }
            }
        }
        int set = 0;
        min = new int[n + 1];
        Arrays.fill(min, Integer.MAX_VALUE);
        while (!stack.isEmpty()) {
            int index = stack.pop();
            if (!visited[index]) {
                p.add(new ArrayList<>());
                unionScc(set, index);
                set++;
            }
        }
        for (ArrayList<Integer> list : p) {
            Collections.sort(list);
        }
        Collections.sort(p, (o1, o2) -> {
            if (o1.get(0) > o2.get(0)) {
                return 1;
            } else {
                return -1;
            }
        });

        bw.write(set + "\n");
        for (ArrayList<Integer> list : p) {
            for (int v : list) {
                bw.write(v + " ");
            }
            bw.write(-1 + "\n");
        }
        bw.flush();
    }

    private static void unionScc(int set, int v) {
        ArrayList<Integer> adjEdges = reverseEdges[v];
        if (!visited[v]) {
            visited[v] = true;
            if (adjEdges != null) {
                for (int adjNode : adjEdges) {
                    if (!visited[adjNode]) {
                        unionScc(set, adjNode);
                    }
                }
            }
            if (p.get(set) == null) {
                p.add(set, new ArrayList<>());
            }
            p.get(set).add(v);
            if (min[set] > v) {
                min[set] = v;
            }
        }
    }

    private static void dfs(int v) {
        ArrayList<Integer> adjEdges = edges[v];
        if (!visited[v]) {
            visited[v] = true;
            if (adjEdges != null) {
                for (int adjNode : adjEdges) {
                    dfs(adjNode);
                }
            }
            stack.push(v);
        }
    }
}
