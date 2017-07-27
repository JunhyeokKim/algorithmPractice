package graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jhKim on 2017-07-20.
 */
public class Tomato {
    public static int n;        // row
    public static int m;        // column
    public static int[][] map;  // tomato 상태맵
    public static LinkedList<Pos> tg;
    public static int tomatoCnt = 0;    // 총 토마토의 갯수
    public final static int VISITED = 2;
    public final static int UNVISITED = 0;
    public final static int TG = 1;     //익은 토마토임을 나타냄
    public final static int BLOCKED = -1;   //토마토가 없음


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("tomato.txt")));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[1]);
        m = Integer.parseInt(nm[0]);
        tg = new LinkedList<>();
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < str.length; j++) {
                map[i][j] = Integer.parseInt(str[j]);
                if (map[i][j] != BLOCKED) {
                    if (map[i][j] == TG) {
                        tg.add(new Pos(i, j));      // 익은 토마토를 LIST에 추가한다
                    }
                    tomatoCnt++;
                }
            }
        }
        System.out.println(findBfs());
    }

    public static int findBfs() {
        Queue<Pos> queue = new LinkedList<>();
        int totDay = -1;
        int sum = 0;
        // 토마토 index 기준으로 인접 cell의 위치
        int[] nPos = {-1, 0, 1, 0};
        int[] mPos = {0, 1, 0, -1};
        // 모두 익은 토마토인 경우
        if (tg.size() == tomatoCnt) {
            return 0;
        }
        // 익은 토마토들을 queue에 삽입한다. 익어가는 과정은 동시에 일어나기 때문에 한번에 처리함.
        while (!tg.isEmpty()) {
            Pos v = tg.remove();
            queue.add(v);
            map[v.n][v.m] = VISITED;
            sum++;
        }
        // bfs
        while (!queue.isEmpty()) {
            int size = queue.size();    // 인접 노드를 추가하기 전 queue의 크기이다.
            for (int k = 0; k < size; k++) {
                Pos v = queue.remove();
                for (int i = 0; i < 4; i++) {
                    // index가 범위 내인지 , 또 방문했는지 확인
                    if (check(v.n + nPos[i], v.m + mPos[i])) {
                        queue.add(new Pos(v.n + nPos[i], v.m + mPos[i]));
                        map[v.n + nPos[i]][v.m + mPos[i]] = VISITED;
                        sum++;  // 익은 토마토 개수 추가
                    }
                }
            }
            totDay++;   // 소요된 일. size에 있던 노드 만큼 수행되면 1단계가 수행된 것이므로 1일 추가.
        }
        if (sum != tomatoCnt) {
            return -1;
        } else {
            return totDay;
        }

    }

    private static boolean check(int r, int c) {
        if (r >= 0 && r < n && c >= 0 && c < m) {
            if (map[r][c] == UNVISITED)
                return true;
        }
        return false;
    }

    private static class Pos {
        int n;
        int m;

        public Pos(int n, int m) {
            this.n = n;
            this.m = m;
        }

        @Override
        public String toString() {
            return "Pos{" +
                    "n=" + n +
                    ", m=" + m +
                    '}';
        }
    }
}


