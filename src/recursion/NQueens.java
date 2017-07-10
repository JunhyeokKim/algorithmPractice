package recursion;

/**
 * Created by junhyeok on 2017-07-09.
 */
public class NQueens {
    public static final int N = 6;
    public static int[] cols = new int[N + 1];

    public static void main(String[] args) {
        search(0);
    }

    public static boolean search(int level) {
        if (!checkPromising(level)) {
            return false;
        } else if (level == N) {
            for (int i = 1; i <= N; i++) {
                System.out.println("(" + i + ", " + cols[i] + ")");
            }
            return true;
        } else {
            for (int i = 0; i < N; i++) {
                cols[level + 1] = i;
                if (search(level + 1)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static boolean checkPromising(int level) {
        for (int i = 1; i < level; i++) {
            if (cols[i] == cols[level]) {
                // column 이 일치하는 경우(수직)
                return false;
            } else if (Math.abs(cols[i] - cols[level]) == level - i) {
                // 대각선 상인 경우
                return false;
            }
        }
        return true;
    }
}
