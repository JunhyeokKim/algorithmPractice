package kakao.second;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by acorn on 2017-09-07.
 */
public class P05 {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};
        System.out.println(solution(arr));
    }

    static int solution(int[][] land) {
        boolean[] visited = new boolean[4];
        int answer = dfs(-1, land, visited);
        return answer;
    }

    private static int dfs(int lv, int[][] land, boolean[] visited) {
        int max = 0;
        if (lv == land.length - 1) {
            for (int i = 0; i < 4; i++) {
                if (!visited[i]) {
                    int res = land[lv][i];
                    if (res > max) {
                        max = res;
                    }
                }
            }
            return max;
        }

        for (int i = 0; i < 4; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int res = dfs(lv + 1, land, visited);
                visited[i] = false;
            }
        }
        return max;
    }
}
