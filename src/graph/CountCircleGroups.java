package graph;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by jhKim on 2017-08-10.
 */
public class CountCircleGroups {
    private static boolean[] visited;
    private static Pos[] list;
    private static int[] p;
    private static ArrayList<Integer>[] adjEdges;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input/countCircleGroups.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            visited = new boolean[n];
            p = new int[n];
            list = new Pos[n];
            adjEdges = new ArrayList[n];
            for (int j = 0; j < n; j++) {
                p[j] = j;
            }
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                list[j] = new Pos(x, y, r);
                adjEdges[j] = new ArrayList<>();
            }
            for (int j = 0; j < n; j++) {
                Pos p = list[j];
                for (int k = j + 1; k < n; k++) {
                    Pos q = list[k];
                    int len = (p.x - q.x) * (p.x - q.x) + (p.y - q.y) * (p.y - q.y);
                    if ((p.r + q.r) * (p.r + q.r) >= len) {
                        adjEdges[j].add(k);
                        adjEdges[k].add(j);
                    }
                }
            }
            int size = 0;
            for (int j = 0; j < n; j++) {
                if (!visited[j]) {
                    dfs(j);
                    size++;
                }
            }
            bw.write(size + "\n");
        }
        bw.flush();
    }

    private static void dfs(int idx) {
        visited[idx] = true;
        for (int i : adjEdges[idx]) {
            if (!visited[i] && find(idx) != find(i)) {
                p[i] = p[idx];
                dfs(i);
            }
        }
    }

    private static int find(int idx) {
        if (p[idx] != idx) {
            p[idx] = find(p[idx]);
        }
        return p[idx];
    }


    private static class Pos {
        int x;
        int y;
        int r;

        public Pos(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }
}
