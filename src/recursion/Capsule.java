package recursion;

/**
 * Created by acorn on 2017-07-12.
 */
public class Capsule {
    public static void main(String[] args) {
        int n = 6;

    }
}

    public static int gogo(int n) {
        n = n * 2;
        return eat(n, 2) + eat(n, 1);
    }

    public static int eat(int n, int type) {
        if (n <= 2) {
            if (type == 2 || type == 1) {
                return 1;
            }
        } else {
            return eat(n - type, 2) + eat(n - type, 1);
        }
    }
