package graph.dag;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by jhKim on 2017-07-26.
 * Problem No: 1516
 */
public class GameDevelope {
    public static int n;
    public static int[] cost;
    public static boolean[] visited;
    public static HashMap<Integer, LinkedList<Integer>> map;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("gameDevelope.txt")));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        cost = new int[n + 1];
        visited = new boolean[n + 1];
        map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            String[] params = str.substring(0, str.length() - 2).split(" ");
            cost[i] = Integer.parseInt(params[0]);
            for (int j = 1; j < params.length; j++) {
                if (!map.containsKey(i)) {
                    map.put(i, new LinkedList<>());
                }
                map.get(i).add(Integer.parseInt(params[j]));
            }
        }
        /*for (int i = 1; i <= n; i++) {
           System.out.println(findMin(i));
        }*/
        System.out.println(findMin(5));
    }

    private static int findMin(int v) {
        int sum = cost[v];
        LinkedList<Integer> adjacentList = map.get(v);
        if (adjacentList != null) {
            for (int item : adjacentList) {
                if (!visited[item]) {
                    int temp= dfs(item);
                    System.out.println(temp);
                }
            }
        }
        Arrays.fill(visited, false);
        return sum;
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
    }
}
