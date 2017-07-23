package graph;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by junhyeok on 2017-07-23.
 * Problem No: 2567
 * dfs, bfs를 통해 각 cycle의 크기를 출력하는 문제.
 */
public class SectionNumbering {
    public static int[][] map;
    public static boolean[][] visited;
    public static int vertex;
    public static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("sectionNumbering.txt")));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        vertex = 0;
        visited = new boolean[n][n];
        map = new int[n][n];
        list= new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                if (str.charAt(j) == '1') {
                    map[i][j] = 1;
                    vertex++;
                }
            }
        }
        search(n);
        Collections.sort(list);
        bw.write(list.size() + "\n");
        for (Integer item : list
                ) {
            bw.write(item + "\n");
        }
        bw.flush();


    }

    public static void search(int n) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cnt == vertex)
                    break;
                if (map[i][j] == 1 && !visited[i][j]) {
                    int sectionNum = dfs(i, j);
                    list.add(sectionNum);
                    cnt += sectionNum;
                }
            }
        }

    }

    public static int dfs(int r, int c) {
        visited[r][c] = true;
        int cnt = 0;
        if (check(r - 1, c)) {
            cnt += dfs(r - 1, c);
        }
        if (check(r + 1, c)) {
            cnt += dfs(r + 1, c);
        }
        if (check(r, c - 1)) {
            cnt += dfs(r, c - 1);
        }
        if (check(r, c + 1)) {
            cnt += dfs(r, c + 1);
        }
        return cnt + 1;
    }

    private static boolean check(int r, int c) {
        if (r >= 0 && r < map.length && c >= 0 && c < map.length) {
            if (!visited[r][c] && map[r][c] == 1)
                return true;
        }
        return false;
    }

}
