package graph;

import java.io.*;
import java.util.*;

/**
 * Created by acorn on 2017-08-03.
 */
public class Hacking {
    private static ArrayList<Integer>[] edges;
    private static ArrayList<Integer>[] reversedEdges;
    private static ArrayList<Integer>[] contains;
    private static int[] d;
    private static boolean[] visited;
    private static int[] p;
    private static ArrayList<Integer>[] sccSets;
    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("hacking.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        d = new int[n + 1];
        p = new int[n + 1];
        sccSets = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        edges = new ArrayList[n + 1];
        reversedEdges = new ArrayList[n + 1];

        contains = new ArrayList[n + 1];
        for (int i = 0; i < n; i++) {
            contains[i] = new ArrayList<>();
            p[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken());
            if (edges[prev] == null) {
                edges[prev] = new ArrayList<>();
            }
            edges[prev].add(to);

        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i])
                stackPush(i);
        }
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
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                d[p[i]] = dfs(i);
                if (d[p[i]] > max) {
                    max = d[p[i]];
                }
            }
            visited = new boolean[n + 1];
        }
        ArrayList<Integer> merged = new ArrayList<>();
        for (int i = 0; i < sccSets.length; i++) {
            if (d[i] == max && sccSets[i] != null) {
                merged.addAll(sccSets[i]);
            }
        }
        Collections.sort(merged);
        for (int v : merged) {
            bw.write(v + " ");
        }
        bw.flush();
    }

    private static void scc(int s, int set) {
        if (!visited[s]) {
            visited[s] = true;
            ArrayList<Integer> adjEdges = reversedEdges[s];
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

    private static int dfs(int s) {
        if (d[p[s]] != 0) {
            return d[p[s]];
        } else {
            visited[s] = true;
            ArrayList<Integer> adjEdges = edges[s];
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
