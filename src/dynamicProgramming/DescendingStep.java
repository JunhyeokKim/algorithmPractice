package dynamicProgramming;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by acorn on 2017-07-31.
 */
public class DescendingStep {
    private static int m;
    private static int n;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] rWay = {-1, 0, 1, 0};
    private static int[] cWay = {0, 1, 0, -1};
    private static int[][] d;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("descendingStep.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        d = new int[m][n];
        map = new int[m][n];
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(dfs(0, 0, map[0][0]));
    }

    /*private static int bfs(int r, int c) {
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(r, c));
        d[0][0] = 1;
        while (!queue.isEmpty()) {
            Pos v = queue.remove();
            for (int i = 0; i < 2; i++) {
                int adjR = v.r + rWay[i];
                int adjC = v.c + cWay[i];
                if (check(adjR, adjC)) {
                    visited[adjR][adjC] = true;
                    if (map[v.r][v.c] > map[adjR][adjC]) {
                        d[adjR][adjC] += d[v.r][v.c];
                    } else {
                        d[v.r][v.c] += d[adjR][adjC];
                    }
                    queue.add(new Pos(adjR, adjC));
                }
            }
        }
        return d[m - 1][n - 1];
    }*/

    private static int dfs(int r, int c, int prev) {
        if (prev < map[r][c]) {
            visited[r][c] = false;
            return -1;
        } else if (r == m - 1 && c == n - 1) {
            return 1;
        }
        else {
            visited[r][c] = true;
            int sum = 0;
            for (int i = 0; i < 4; i++) {
                int adjR = r + rWay[i];
                int adjC = c + cWay[i];
                if (check(adjR, adjC)) {
                    int temp = dfs(adjR, adjC, map[r][c]);
                    if (temp != -1) {
                        System.out.println("( " + r + " " + c + " )");
                        sum += temp;
                    }
                }
            }
            //System.out.println(r+", "+c +": "+sum);
            visited[r][c] = false;
            return sum;
        }
    }

    private static boolean check(int r, int c) {
        if (r >= 0 && r < m && c >= 0 && c < n && !visited[r][c]) {
            return true;
        }
        return false;
    }

    private static class Pos {
        int r;
        int c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Pos{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }
}
