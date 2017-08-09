package graph;

import java.io.*;
import java.util.*;

/**
 * Created by acorn on 2017-08-03.
 */
public class Hacking {
    // 인접 리스트
    private static ArrayList<Integer>[] edges;
    // 역방향으로 연걸된 인접 리스트
    private static ArrayList<Integer>[] reversedEdges;
    // 각 SCC 그룹이 갖는 최대 전파 횟수
    private static int[] d;
    // 방문 node check
    private static boolean[] visited;
    // 각 node의 scc set 번호를 저장
    private static int[] p;
    // 각 scc set에 포함된 node의 번호들을 저장
    private static ArrayList<Integer>[] sccSets;
    // scc 검출을 위한 stack
    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("hacking.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder bd = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        d = new int[n + 1];
        p = new int[n + 1];
        sccSets = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        edges = new ArrayList[n + 1];
        reversedEdges = new ArrayList[n + 1];

        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        // 인접 리스트 초기화
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken());
            if (edges[prev] == null) {
                edges[prev] = new ArrayList<>();
            }
            edges[prev].add(to);
        }
        // dfs를 따라서 stack에 삽입
        for (int i = 1; i <= n; i++) {
            if (!visited[i])
                stackPush(i);
        }
        // 역방향 연결리스트에 대하여 초기화
        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> list = edges[i];
            if (list != null) {
                for (int to : list) {
                    if (reversedEdges[to] == null) {
                        reversedEdges[to] = new ArrayList<>();
                    }
                    reversedEdges[to].add(i);
                }
            }
        }
        // 1번부터 scc 그룹을 찾아나섬. stack의 pop 순서에 따라 그룹을 나누게 된다.
        int set = 1;
        visited = new boolean[n + 1];
        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                scc(v, set);
                set++;
            }
        }

        visited = new boolean[n + 1];
        int max = 0;    // 모든 scc set 중 최대 전파 횟수를 기록한다.
        for (int i = 1; i <= n; i++) {
            d[p[i]] = dfs(i);
            if (d[p[i]] > max) {
                max = d[p[i]];
            }
            // visited를 초기화
            visited = new boolean[n + 1];
        }
        // 각 sccSet을 검사하여 최대 값을 갖는 경우 merged에 추가.
        ArrayList<Integer> merged = new ArrayList<>();
        for (int i = 1; i < sccSets.length; i++) {
            if (d[i] == max) {
                merged.addAll(sccSets[i]);
            }
        }
        // 정렬
        Collections.sort(merged);
        for (int v : merged) {
            bd.append(v + " ");
        }
        System.out.println(bd.toString().trim());

    }

    private static void scc(int s, int set) {
        if (!visited[s]) {
            visited[s] = true;
            ArrayList<Integer> adjEdges = reversedEdges[s];
            // 인접 노드를 방문함.
            if (adjEdges != null) {
                for (int adjNode : adjEdges) {
                    if (!visited[adjNode]) {
                        scc(adjNode, set);
                    }
                }
            }
            p[s] = set;
            if (sccSets[set] == null) {
                sccSets[set] = new ArrayList<>();
            }
            sccSets[set].add(s);

        }
    }

    private static void stackPush(int s) {
        if (!visited[s]) {
            visited[s] = true;
            ArrayList<Integer> adjEdges = edges[s];
            if (adjEdges != null) {
                for (int adjNode : adjEdges) {
                    if (!visited[adjNode]) {
                        stackPush(adjNode);
                    }
                }
            }
            stack.push(s);
        }
    }

    private static int dfs(int v) {
        // 이미 노드 v가 속한 scc (p[v])에 대하여 dfs를 수행한 경우 동일한 값을 갖기 때문에 바로 return
        if (d[p[v]] != 0) {
            return d[p[v]];
        } else {
            visited[v] = true;
            ArrayList<Integer> adjEdges = edges[v];
            int sum = 1;
            if (adjEdges != null) {
                for (int adjNode : adjEdges) {
                    if (!visited[adjNode]) {
                        sum += dfs(adjNode);
                    }
                }
            }
            return sum;
        }
    }
}
