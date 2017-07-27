package graph.dag;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jhKim on 2017-07-26.
 * Problem No: 1516
 */
public class GameDevelope {
    public static int n;
    public static int[] cost;
    public static boolean[] visited;
    public static int[] indegree;
    public static HashMap<Integer, LinkedList<Integer>> map;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("gameDevelope.txt")));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        cost = new int[n + 1];
        visited = new boolean[n + 1];
        indegree = new int[n + 1];
        map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            String[] params = str.substring(0, str.length() - 2).split(" ");
            cost[i] = Integer.parseInt(params[0]);
            for (int j = 1; j < params.length; j++) {
                if (!map.containsKey(i)) {
                    map.put(i, new LinkedList<>());
                }
                map.get(Integer.parseInt(params[j])).add(i);
                indegree[i]++;
            }
        }
        for (int i = 1; i <= n; i++) {
            bw.write(findMin(i) + "\n");
        }
        bw.flush();
    }

    private static int findMin(int v) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {

        }
        return 0;
    }

    /*private static int findMin(int v) {
        int sum = cost[v];
        int max = 0;
        LinkedList<Integer> adjacentList = map.get(v);
        if (adjacentList != null) {
            for (int item : adjacentList) {
                if (!visited[item]) {
                    int temp = dfs(item);
                    if (max < temp) {
                        max = temp;
                    }
                }
                Arrays.fill(visited, false);
            }
        }
        return sum + max;
    }

    public static int dfs(int v) {
        visited[v] = true;
        int sum = cost[v];
        int max = 0;
        LinkedList<Integer> adjacentList = map.get(v);
        if (adjacentList != null) {
            for (int item : adjacentList) {
                if (!visited[item]) {
                    int temp = dfs(item);
                    if (max < temp)
                        max = temp;
                }
            }
        }
        return sum + max;
    }*/
}
