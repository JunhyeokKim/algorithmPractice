package kakao.second;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by acorn on 2017-09-07.
 */
public class P04 {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*int[][] board = {{0, 0, 1, 1}, {1, 1, 1, 1}};*/
        int[][] board = {{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}};
        /*int[][] board = {{0, 0, 1, 1}};*/
        System.out.println(solution(board));
    }

    public static int solution(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        int[][] d = new int[row][col];
        for (int i = 0; i < row; i++) {
            if (board[i][0] != 0) {
                d[i][0] = 1;
            }
        }
        for (int i = 0; i < col; i++) {
            if (board[0][i] != 0) {
                d[0][i] = 1;
            }
        }
        int max = 1;
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (board[i][j] == 0) {
                    d[i][j] = 0;
                } else {
                    d[i][j] = 1;
                    if (d[i - 1][j] == d[i][j - 1] && d[i][j - 1] == d[i - 1][j - 1]) {
                        d[i][j] = d[i - 1][j] + 1;
                        if (max < d[i][j]) {
                            max = d[i][j];
                        }
                    } else if (board[i - 1][j] == board[i][j - 1] && board[i - 1][j] == board[i - 1][j - 1]) {
                        d[i][j] = 2;
                    }
                }
            }
        }

        return max * max;
    }
}
