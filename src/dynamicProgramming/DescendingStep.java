package dynamicProgramming;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by jhKim on 2017-07-31.
 * Problem no:1520
 * 메모라이제이션을 이용한 dfs 문제이다. bfs, bottom up 모두 생각해봤지만 가장 간명한 방법인 것 같다.
 * 재귀식을 짤때는 최대한 단순하게 하자
 */
public class DescendingStep {
    private static int m;
    private static int n;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] rWay = {0, 1, 0, -1};
    private static int[] cWay = {1, 0, -1, 0};
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
        System.out.println(dfs(0, 0));
        //System.out.println(dp());
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
    private static int dp() {
        d[0][0] = 1;
        for (int i = 1; i < n; i++) {
            if (d[0][i] < d[0][i - 1]) {
                d[0][i] += d[0][i - 1];
            }
        }
        for (int i = 1; i < m; i++) {
            if (d[i][0] < d[i - 1][0]) {
                d[i][0] += d[i - 1][0];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 위로 부터 도달하는 경로가 있는 경우
                if (map[i][j] < map[i - 1][j]) {
                    d[i][j] += d[i - 1][j];
                }
                if (map[i][j] < map[i][j - 1]) {
                    d[i][j] += d[i][j - 1];
                }
                if (map[i][j] > map[i - 1][j]) {
                    d[i - 1][j] += d[i][j];
                }
                if (map[i][j] > map[i][j - 1]) {
                    d[i][j - 1] += d[i][j];
                }
            }
        }
        return d[m - 1][n - 1];
    }

    private static int dfs(int r, int c) {
        if (r == m - 1 && c == n - 1) {
            return 1;
        } else if (visited[r][c]) {
            return d[r][c];
        } else {
            visited[r][c] = true;
            int sum = 0;
            for (int i = 0; i < 4; i++) {
                int adjR = r + rWay[i];
                int adjC = c + cWay[i];
                if (check(adjR, adjC)) {
                    if (map[adjR][adjC] < map[r][c])
                        sum += dfs(adjR, adjC);
                }
            }
            d[r][c] = sum;
            return sum;
        }
    }

    private static boolean check(int r, int c) {
        if (r >= 0 && r < m && c >= 0 && c < n) {
            return true;
        }
        return false;
    }

}
