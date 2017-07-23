package recursion;

/**
 * Created by junhyeok on 2017-07-09.
 */
public class NQueens {
    public static final int N = 10;
    public static int[] cols = new int[N + 1];

    public static void main(String[] args) {
        System.out.println(search(0));
    }

    public static int search(int level) {
        if (!checkPromising(level)) {
            return 0;
        } else if (level == N) {
           /* for (int i = 1; i <= N; i++) {
                System.out.println("(" + i + ", " + cols[i] + ")");
            }*/
            return 1;
        } else {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                cols[level + 1] = i;
                cnt += search(level + 1);

            }
            return cnt;
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
