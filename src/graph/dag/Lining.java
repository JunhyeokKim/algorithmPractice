package graph.dag;

import java.io.*;
import java.util.*;

/**
 * Created by junhyeok on 2017-07-25.
 * Problem No: 2522
 */
public class Lining {
    public static boolean[] visited;
    public static int n;
    public static int[] indegree;
    // 정점, 간선을 이으는 자료구조로 map을 쓰면 좋을듯
    public static HashMap<Integer, LinkedList<Integer>> map;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("lining.txt")));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        indegree = new int[n + 1];
        int m = Integer.parseInt(nm[1]);
        visited = new boolean[n + 1];
        map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String[] str = br.readLine().split(" ");
            if (!map.containsKey(Integer.parseInt(str[0]))) {
                map.put(Integer.parseInt(str[0]), new LinkedList<>());
            }
            map.get(Integer.parseInt(str[0])).add(Integer.parseInt(str[1]));
            indegree[Integer.parseInt(str[1])]++;
        }
        sort2();
    }
    // dfs를 통한 위상 정렬 방식.
    public static void sort() throws IOException {
        List<Integer> list = new LinkedList<>();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i, list);
            }
        }
        for (int v : list
                ) {
            bw.write(v + " ");
        }
        bw.flush();
    }
    // indegree 검사를 통한 위상정렬 방식. bfs와 유사하다.
    public static void sort2() {
        LinkedList<Integer> list = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int v = queue.remove();
            list.add(v);
            LinkedList<Integer> adjacentList = map.get(v);
            if (adjacentList != null) {
                for (int item : adjacentList) {
                    indegree[item]--;
                    if (indegree[item] == 0) {
                        queue.add(item);
                    }
                }
            }
            map.remove(v);
        }
        for (int item : list) {
            System.out.print(item + " ");
        }
    }

    public static void dfs(int v, List list) {
        visited[v] = true;
        LinkedList<Integer> adjacentList = map.get(v);
        // 인접한 정점들에 한해서 만 수행한다.
        if (adjacentList != null) {
            for (int item : adjacentList) {
                if (!visited[item]) {
                    dfs(item, list);
                }
            }
        }
        list.add(0, v);
    }

}
