package tree;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by junhyeok on 2017-08-13.
 */

public class FindParentNode {
    private static ArrayList<Integer>[] adjLists;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input/findParentNode.txt")));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder bd = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        adjLists = new ArrayList[n + 1];
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            if (adjLists[node1] == null) {
                adjLists[node1] = new ArrayList<>();
            }
            if (adjLists[node2] == null) {
                adjLists[node2] = new ArrayList<>();
            }
            adjLists[node1].add(node2);
            adjLists[node2].add(node1);
        }
        bfs(1, n);
        for (int i = 2; i <= n; i++) {
            bd.append(parent[i] + "\n");
        }
        System.out.println(bd.toString());
    }

    private static void bfs(int s, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.add(s);
        visited[s] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int p = queue.remove();
                for (int node : adjLists[p]) {
                    if (!visited[node]) {
                        queue.add(node);
                        visited[node] = true;
                        parent[node] = p;
                    }
                }
            }
        }
    }


}


 
 
 