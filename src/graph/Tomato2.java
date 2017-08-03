package graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by jhKim on 2017-08-03.
 * Tomato의 3차원 버전. 배열이 3차원으로 구성되었다는 점을 제외하면 동일한 문제이다.
 */
public class Tomato2 {
    private final static int OPEN = 0;          // 익지 않은 토마토
    private final static int BLOCKED = 1;       // 익은 토마토
    private final static int EMPTY = -1;        // 비어있는 자리
    private static int m;
    private static int n;
    private static int height;
    private static int[][][] arr;
    private static int[] xWay = {0, 0, -1, 1, 0, 0};
    private static int[] yWay = {0, 0, 0, 0, -1, 1};
    private static int[] hWay = {-1, 1, 0, 0, 0, 0};

    private static Queue<Pos> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("tomato2.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        int goal = 0;
        arr = new int[height][n][m];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if (arr[i][j][k] != EMPTY) {
                        goal++;
                        if (arr[i][j][k] == BLOCKED) {
                            queue.add(new Pos(k, j, i));
                        }
                    }
                }
            }
        }
        bfs(goal);
    }

    private static void bfs(int goal) {
        int day = -1;
        int cnt = queue.size();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Pos visit = queue.remove();
                for (int i = 0; i < 6; i++) {
                    int adjX = visit.x + xWay[i];
                    int adjY = visit.y + yWay[i];
                    int adjH = visit.h + hWay[i];
                    if (check(adjX, adjY, adjH)) {
                        arr[adjH][adjY][adjX] = BLOCKED;
                        queue.add(new Pos(adjX, adjY, adjH));
                        cnt++;
                    }
                }
            }
            day++;
        }
        System.out.println(cnt == goal ? day : -1);
    }

    private static boolean check(int x, int y, int h) {
        if (x >= 0 && x < m && y >= 0 && y < n && h >= 0 && h < height && arr[h][y][x] == OPEN) {
            return true;
        }
        return false;
    }


    private static class Pos {
        int x;
        int y;
        int h;

        public Pos(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
}
