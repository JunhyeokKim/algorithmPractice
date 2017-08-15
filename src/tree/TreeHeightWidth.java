package tree;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by junhyeok on 2017-08-14.
 */

public class TreeHeightWidth {
    static int[] rad;
    static int[][] trees;
    static int level = 1;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input/treeHeightWidth.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder bd = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        trees = new int[n + 1][2];
        rad = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int ld = Integer.parseInt(st.nextToken());
            int rd = Integer.parseInt(st.nextToken());
            if (ld != -1) {
                trees[parent][0] = ld;
            }
            if (rd != -1) {
                trees[parent][1] = rd;
            }
        }
    }

    private static int bfs(int s) {
        int level = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int p = queue.remove();
            }
            ++level;
        }
        return 0;
    }

    private static int dfs(int s, int level, int lr, int p) {
        int sum = 0;
        if (lr == 0) {
            // left side
            if (trees[s][1] != 0) {
            }
            if (trees[s][0] != 0) {

            }
        } else {
            // right side

        }
        return sum;
    }

}


 
 
 