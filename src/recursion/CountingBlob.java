package recursion;

/**
 * Created by junhyeok on 2017-07-08.
 */
public class CountingBlob {
    private static int[][] grid = {
            {0, 0, 0, 0, 0, 0, 0, 1},
            {0, 1, 1, 0, 1, 1, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {0, 1, 0, 0, 1, 1, 0, 0},
            {0, 1, 1, 1, 0, 0, 1, 1},
            {0, 1, 0, 0, 0, 1, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {0, 1, 1, 1, 0, 1, 0, 0}
    };
    public static final int IMAGE_PIXEL = 1;
    public static final int BACKGROUND_PIXEL = 0;
    public static final int VISITED_PIXEL = 2;
    public static final int N = 8;

    public static void main(String[] args) {
        int x = 6, y = 7;
        printGrid();
        System.out.println(countBlob(x, y));
    }

    public static void printGrid() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int countBlob(int x, int y) {
        if (x < 0 || y < 0 || x > N - 1 || y > N - 1) {
            // out of range
            return 0;
        } else if (grid[x][y] == BACKGROUND_PIXEL || grid[x][y] == VISITED_PIXEL) {
            // visited or background pixel
            return 0;
        } else {
            int count = 1;
            grid[x][y] = VISITED_PIXEL;
            int[] xPos = {x, x + 1, x + 1, x + 1, x, x - 1, x - 1, x - 1};
            int[] yPos = {y + 1, y + 1, y, y - 1, y - 1, y - 1, y, y + 1};
            for (int i = 0; i < 8; i++) {
                count += countBlob(xPos[i], yPos[i]);
            }
            return count;
        }
    }
}
