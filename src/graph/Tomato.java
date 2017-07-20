package graph;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by acorn on 2017-07-20.
 */
public class Tomato {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("tomato.txt")));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        Pos[] s = new Pos[n * m];
        int[][] arr = new int[n][m];
        int sSize = 0;
        for (int i = 0; i < n; i++) {
            String[] tomatos = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(tomatos[j]);
                if (arr[i][j] == 1) {
                    s[sSize++] = new Pos(n, m);
                }
            }
        }
        System.out.println(tomato(n, arr, s));
    }

    private static int tomato(int n, int[][] arr, Pos[] s) {
        Queue<Pos> queue = new ArrayDeque<>();
        queue.add(s[0]);
        while (!queue.isEmpty()) {
            Pos p = queue.remove();

        }
        return 0;
    }

}

class Pos {
    int n, m;

    public Pos(int n, int m) {
        this.n = n;
        this.m = m;
    }
}
