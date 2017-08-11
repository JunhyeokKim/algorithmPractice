package graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by acorn on 2017-08-11.
 */
public class Jump {
    private static int[][] map;
    private static int n;
    private static long[][] d;


    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input/jump.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        d = new long[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();
        System.out.println(dfs(0, 0));
        /*System.out.println(bfs());*/
    }

    private static long dfs(int r, int c) {
        if (r == n - 1 && c == n - 1) {
            return 1;
        } else if (map[r][c] == 0) {
            return 0;
        } else if (d[r][c] != 0) {
            return d[r][c];
        } else {
            long way = 0L;
            int len = map[r][c];
            int[] rWay = {0, len};
            int[] cWay = {len, 0};
            for (int i = 0; i < 2; i++) {
                int adjR = r + rWay[i];
                int adjC = c + cWay[i];
                if (adjR < n && adjC < n) {
                    way += dfs(adjR, adjC);
                }
            }
            d[r][c] = way;
            return way;
        }
    }

    /*bfs로 접근시 200C100의 경우의 수에 대해 메모리 오버플로우*/
    private static long bfs() {
        Queue<Pos> queue = new LinkedList<>();
        long way = 0;
        queue.add(new Pos(0, 0));
        while (!queue.isEmpty()) {
            Pos p = queue.remove();
            if (p.r == n - 1 && p.c == n - 1) {
                way++;
                continue;
            }
            int len = map[p.r][p.c];
            if (len == 0) {
                continue;
            }
            if (p.c + len < n) {
                queue.add(new Pos(p.r, p.c + len));
            }
            if (p.r + len < n) {
                queue.add(new Pos(p.r + len, p.c));
            }
        }
        return way;

    }

    private static class Pos {
        int r;
        int c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}
