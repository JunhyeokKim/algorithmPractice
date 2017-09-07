package kakao.first;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by junhyeok on 2017-08-05.
 */
public class P02 {
    private final static int OPEN = 0;
    private final static int BLOCKED = 1;
    private final static int ONEWAY = 2;
    private static boolean[][] visited;
    private static int m;
    private static int n;
    private static int[][] d;

    public static void main(String[] args) {
        m = 3;
        n = 6;
        visited = new boolean[m][n];
        d = new int[m][n];
        int[][] cityMap = {{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}};
        System.out.println(solution(m, n, cityMap));
    }

    public static int solution(int m, int n, int[][] cityMap) {
        int answer = dfs(0, 0, cityMap, 0);
        return answer;

    }

    private static int dfs(int r, int c, int[][] cityMap, int way) {
        if (r == m - 1 && c == n - 1) {
            return 1;
        } else if (d[r][c]!=0 && cityMap[r][c] == ONEWAY) {
            int adjR = r + ((way == 1) ? 0 : 1);
            int adjC = c + ((way == 1) ? 1 : 0);
            if (check(r, c, adjR, adjC))
                return dfs(adjR, adjC, cityMap, adjC == c ? 2 : 1);
            else return 0;
        }
        // way : 1 왼쪽에서 옴
        // way : 2 위에서 옴
        // way : 0 초기값. 둘다 됨
        else if (!visited[r][c]) {
            int sum = 0;
            visited[r][c] = true;
            ArrayList<Integer> rWay = new ArrayList<>();
            ArrayList<Integer> cWay = new ArrayList<>();
            if (cityMap[r][c] == ONEWAY && way == 1) {
                rWay.add(0);
                cWay.add(1);
            } else if (cityMap[r][c] == ONEWAY && way == 2) {
                rWay.add(1);
                cWay.add(0);
            } else {
                rWay.add(0);
                rWay.add(1);
                cWay.add(1);
                cWay.add(0);
            }

            for (int i = 0; i < rWay.size(); i++) {
                int adjR = r + rWay.get(i);
                int adjC = c + cWay.get(i);
                if (check(r, c, adjR, adjC) && cityMap[adjR][adjC] != BLOCKED) {
                    sum += dfs(adjR, adjC, cityMap, (r == adjR) ? 1 : (c == adjC) ? 2 : 0);
                }
            }
            d[r][c] = sum;
            visited[r][c]=false;
            return sum;
        }
        return 0;
    }

    private static boolean check(int r, int c, int adjR, int adjC) {
        if (adjR >= 0 && adjR < m && adjC >= 0 && adjC < n) {
            return true;
        }
        return false;
    }

}
