package test.nhn;

import test.kakao.first.P01;

import java.io.*;
import java.util.*;

/**
 * Created by junhyeok on 2017-09-23.
 */

public class P04 {
    static char[][] arr;
    static boolean[][] visited;
    static int n;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input/nhn1.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder bd = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        arr = new char[n][n];
        visited = new boolean[n][n];
        ArrayList<Integer> sorted= new ArrayList<>();
        int numberOfArea = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = st.nextToken().charAt(0);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0 && !visited[i][j]) {
                    numberOfArea++;
                    int temp=bfs(i, j, visited, arr);
                    if(temp!=0){
                        sorted.add(temp);
                    }
                }
            }
        }
        Collections.sort(sorted);
        System.out.println(numberOfArea);
        for (int i = 0; i < sorted.size(); i++) {
            bd.append(sorted.get(i)+" ");
        }
        System.out.println(bd.toString().trim());
    }

    private static int bfs(int r, int c, boolean[][] visited, char[][] picture) {
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
                if (check(adjR, adjC, visited, arr)) {
                    queue.add(new Pos(adjR, adjC));
                    visited[adjR][adjC] = true;
                    size++;
                }
            }
        }
        return size;
    }

    private static boolean check(int r, int c, boolean[][] visited, char[][] picture) {
        if (r >= 0 && r < n && c >= 0 && c < n && !visited[r][c] && picture[r][c]=='1') {
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



 
 
 