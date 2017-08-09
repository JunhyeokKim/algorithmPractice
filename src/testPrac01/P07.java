package testPrac01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by junhyeok on 2017-08-04.
 */
public class P07 {
    private static int[] height;
    private static int[][] map;
    private static int n;
    private static int m;
    private static StringBuilder bd = new StringBuilder();

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("testPrac01_input/p07.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];
        height = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int prev = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map[prev][to] = 1;
            map[to][prev] = 1;
        }
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            bfs(a, k);
        }
        System.out.println(bd.toString());

    }

    private static void bfs(int a, int k) {
        boolean[] visited = new boolean[n + 1];
        int[] minHeight = new int[n + 1];
        minHeight[0] = height[a];
        boolean check = false;
        for (int i = 1; i <= n; i++) {
            if (map[a][i] != 0) {
                check = true;
                break;
            }
        }
        if (check) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(a);
            int lv = 0;
            visited[a] = true;
            while (!queue.isEmpty() && lv < k) {
                int size = queue.size();
                boolean check2 = false;
                for (int j = 0; j < size; j++) {
                    int u = queue.remove();
                    for (int i = 1; i <= n; i++) {
                        if (map[u][i] != 0 && !visited[i]) {
                            queue.add(i);
                            check2 = true;
                            visited[i] = true;
                        }
                    }
                }

                if (check2) lv++;
                else {
                    break;
                }
                int min = Integer.MAX_VALUE;
                for (int node : queue) {
                    if (min > height[node]) {
                        min = height[node];
                    }
                }
                minHeight[lv] = min;
            }
            if (lv == k) {
                bd.append(minHeight[lv] + "\n");
            } else if (lv < k) {
                int min = Integer.MAX_VALUE;
                if (k % 2 == 0) {
                    for (int i = 0; i <= lv; i++) {
                        if (i % 2 == 0) {
                            if (min > minHeight[i]) {
                                min = minHeight[i];
                            }
                        }
                    }
                    bd.append(min + "\n");
                } else {
                    for (int i = 0; i <= lv; i++) {
                        if (i % 2 != 0) {
                            if (min > minHeight[i]) {
                                min = minHeight[i];
                            }
                        }
                    }
                    bd.append(min + "\n");
                }
            }
        } else {
            bd.append("-1\n");
        }
    }
}
