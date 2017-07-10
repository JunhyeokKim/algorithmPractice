package recursion;


/**
 * Created by junhyeok on 2017-07-08.
 */
public class Maze1 {
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
    private static int N = 8;
    private static final int PATHWAY_COLOR = 0;     // unvisited way
    private static final int WALL_COLOR = 1;        // wall
    private static final int BLOCKED_COLOR = 2;     // blocked way
    private static final int PATH_COLOR = 3;        // right way (visited)

    public static void main(String[] args) {
        int x = 0, y = 0;
        System.out.println(findPath(y, x));
        for (int i = 0; i <N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean findPath(int y, int x) {
        if (x == N - 1 && y == N - 1) {
            grid[y][x] = PATH_COLOR;
            // when exist
            return true;
        } else if (x < 0 || y < 0 || x > N - 1 || y > N - 1) {
            // out of index
            return false;
        } else if (grid[y][x] !=PATHWAY_COLOR) {
            // wall or visited cell
            return false;
        } else {
            grid[y][x]=PATH_COLOR;
            int[] xPos = {x - 1, x, x, x + 1};
            int[] yPos = {y, y - 1, y + 1, y};
            for (int i = 0; i < 4; i++) {
                if (findPath(yPos[i], xPos[i])) {
                    return true;
                }
            }
            grid[y][x] = BLOCKED_COLOR;
            return false;
        }
    }

}
