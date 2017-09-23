package prac1;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by junhyeok on 2017-09-17.
 */

public class P01 {
    static Stack<Pos> stack = new Stack<>();
    final static int[] rWay = {-1, -1, -1, 0, 0, 1, 1, 1};
    final static int[] cWay = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input/prac_p01.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder bd = new StringBuilder();
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] == '1') {
                    stack.add(new Pos(i, j));
                }
            }
        }
        System.out.println(bfs(m, n, map));

    }

    private static int bfs(int m, int n, char[][] map) {
        boolean[][] visited = new boolean[m][n];
        int ans = 0;
        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                Pos p = stack.pop();
                if (!visited[p.r][p.c]) {
                    for (int j = 0; j < 8; j++) {
                        int adjR = p.r + rWay[j];
                        int adjC = p.c + cWay[j];
                        if (check(m, n, adjR, adjC, map, visited)) {
                            stack.add(new Pos(adjR, adjC));
                            System.out.println(adjR+" "+adjC);
                            visited[adjR][adjC] = true;
                        }
                    }
                }
            }
            ans++;
        }
        return ans;
    }

    private static boolean check(int m, int n, int r, int c, char[][] map, boolean[][] visited) {
        if (r > m - 1 || r < 0 || c > n - 1 || c < 0) {
            return false;
        } else if (map[r][c] == '1' && !visited[r][c]) {
            return true;
        }
        return false;
    }

    static class Pos {
        int r;
        int c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}


 
 
 