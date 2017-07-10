package recursion;

/**
 * Created by junhyeok on 2017-07-09.
 */
public class PowerSet {
    public static final char[] CHAR_SET = {'a', 'b', 'c', 'd', 'e','f','g'};
    public static final int N = CHAR_SET.length;
    public static boolean[] include = new boolean[N];

    public static void main(String[] args) {
        printPowerSet(0);
    }

    public static void printPowerSet(int k) {
        if (k == N) {
            // subset이 더이상 남아있지 않은 경우
            for (int i = 0; i < N; i++) {
                if(include[i])
                    System.out.print(CHAR_SET[i]+" ");
            }
            System.out.println();
        } else {
            // CHAR_SET[k]를 제외한 subset을 구함
            include[k] = false;
            printPowerSet(k + 1);
            // CHAR_SET[k]를 포함하는 subset을 구함
            include[k] = true;
            printPowerSet(k + 1);
        }
    }

}
