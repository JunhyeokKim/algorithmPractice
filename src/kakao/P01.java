package kakao;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by junhyeok on 2017-08-05.
 */
public class P01 {
    private static int m;
    private static int n;

    public static void main(String[] args) {
        m = 6;
        n = 4;
        int[][] picture = new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int[] ans = solution(m, n, picture);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] solution(int m, int n, int[][] picture) {
        boolean[][] visited = new boolean[m][n];
        int maxSizeOfOneArea = 0;
        int numberOfArea = 0;
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    numberOfArea++;
                    int temp = bfs(i, j, visited, picture);
                    if (temp > maxSizeOfOneArea) {
                        maxSizeOfOneArea = temp;
                    }
                }
            }
        }


        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private static int bfs(int r, int c, boolean[][] visited, int[][] picture) {
        int[] rWay = {-1, 0, 1, 0};
        int[] cWay = {0, 1, 0, -1};
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(r, c));
        int size = 0;
        while (!queue.isEmpty()) {
            Pos u = queue.remove();
            for (int i = 0; i < 4; i++) {
                int adjR = u.r + rWay[i];
                int adjC = u.c + cWay[i];
                if (check(adjR, adjC, visited, picture[u.r][u.c], picture)) {
                    queue.add(new Pos(adjR, adjC));
                    visited[adjR][adjC] = true;
                    size++;
                }
            }
        }
        return size;
    }

    private static boolean check(int r, int c, boolean[][] visited, int type, int[][] picture) {
        if (r >= 0 && r < m && c >= 0 && c < n && !visited[r][c] && type == picture[r][c]) {
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
    }
}
