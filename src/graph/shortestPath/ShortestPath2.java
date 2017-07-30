package graph.shortestPath;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by junhyeok on 2017-07-30.
 * Problem No:1504
 */
public class ShortestPath2 {
    public final static long MAX = 987654321;
    private static long[] d;
    private static int n;
    private static int e;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("shortestPath2.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(map[i], -1);
            map[i][i] = 0;
        }
        d = new long[n + 1];
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int prev = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            map[prev][to] = w;
            map[to][prev] = w;
        }

        st = new StringTokenizer(br.readLine(), " ");
        int e1 = Integer.parseInt(st.nextToken());
        int e2 = Integer.parseInt(st.nextToken());
        boolean check1 = true;
        boolean check2 = true;
        long dist1 = 0;
        long dist2 = 0;
        int[] starts1 = {1, e1, e2};
        int[] ends1 = {e1, e2, n};
        int[] starts2 = {1, e2, e1};
        int[] ends2 = {e2, e1, n};
        for (int i = 0; i < 3; i++) {
            dist1 += dijkstra(starts1[i], ends1[i], check1);
            if (!check1) {
                check1 = false;
                break;
            }
        }
        for (int i = 0; i < 3; i++) {
            dist2 += dijkstra(starts2[i], ends2[i], check2);
            if (!check2) {
                check2 = false;
                break;
            }
        }
        if (!check1 && !check2) {
            System.out.println(-1);
        } else if (check1 && !check2) {
            System.out.println(dist1);
        } else if (!check1 && check2) {
            System.out.println(dist2);
        } else {
            System.out.println(Math.min(dist1, dist2));
        }
    }


    public static long dijkstra(int start, int end, boolean check) {
        Arrays.fill(d, MAX);
        d[start] = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (int i = 1; i <= n; i++) {
                if (map[v][i] != -1 && d[i] > d[v] + map[v][i]) {
                    d[i] = d[v] + map[v][i];
                    queue.add(i);
                }
            }
        }
        if (d[end] == MAX) {
            check = false;
        }
        return d[end];
    }
}
