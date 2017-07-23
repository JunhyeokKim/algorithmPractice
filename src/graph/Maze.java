package graph;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by junhyeok on 2017-07-23.
 * Problem No:2178
 * n,m까지의 최단 경로의 길이를 구하는 문제. dfs를 사용한다면 worst case로 빠지는 경우가 있기 때문에 최단 경로의 길이를 구하고자 할 때는 bfs를 활용한다.
 */
public class Maze {
    public static int[][] map;
    public static int n, m;
    public static int way;
    public final static int VISITED = 2;
    public final static int UNVISITED = 1;
    public final static int BLOCKED = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("maze.txt")));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        map = new int[n][m];
        way = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                if (str.charAt(j) == '1') {
                    map[i][j] = UNVISITED;
                }
            }
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        // queue의 기본 capacity는 1000이다. input인 n,m은 2 이상 100 이하이므로 최대 10000개의 노드가 큐에 들어갈 것이다.
        Queue<Pos> queue = new ArrayDeque<>(100000);
        queue.add(new Pos(0, 0));
        int cnt = 0;
        // 큐에 정점을 넣기 전에 방문했다고 표시를 해야 중복된 값이 다시 큐에 등록되지 않는다.
        map[0][0] = VISITED;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pos vertex = queue.remove();
                if (vertex.r == n - 1 && vertex.c == m - 1)
                    return cnt + 1;
                if (check(vertex.r - 1, vertex.c)) {
                    queue.add(new Pos(vertex.r - 1, vertex.c));
                    map[vertex.r - 1][vertex.c] = VISITED;
                }
                if (check(vertex.r + 1, vertex.c)) {
                    queue.add(new Pos(vertex.r + 1, vertex.c));
                    map[vertex.r + 1][vertex.c] = VISITED;
                }
                if (check(vertex.r, vertex.c - 1)) {
                    queue.add(new Pos(vertex.r, vertex.c - 1));
                    map[vertex.r][vertex.c - 1] = VISITED;
                }
                if (check(vertex.r, vertex.c + 1)) {
                    queue.add(new Pos(vertex.r, vertex.c + 1));
                    map[vertex.r][vertex.c + 1] = VISITED;
                }
            }
            cnt++;
        }
        return cnt;
    }


    // 시간 초과남.
    private static int dfs(int r, int c, int sum) {
        if (r == n - 1 && c == m - 1) {
            if (way > sum + 1) {
                way = sum + 1;
            }
            map[r][c] = UNVISITED;
            System.out.println("sum: " + (sum + 1));
            return 1;
        }
        int cnt = 1;
        map[r][c] = VISITED;
        if (check(r - 1, c)) {
            cnt += dfs(r - 1, c, sum + 1);
        }
        if (check(r + 1, c)) {
            cnt += dfs(r + 1, c, sum + 1);
        }
        if (check(r, c - 1)) {
            cnt += dfs(r, c - 1, sum + 1);
        }
        if (check(r, c + 1)) {
            cnt += dfs(r, c + 1, sum + 1);
        }
        map[r][c] = UNVISITED;
        return cnt;
    }

    private static boolean check(int r, int c) {
        if (r >= 0 && r < n && c >= 0 && c < m) {
            if (map[r][c] == UNVISITED) {
                return true;
            }
        }
        return false;
    }

    private static class Pos {
        int r, c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
