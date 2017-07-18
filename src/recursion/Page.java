package recursion;

import java.util.Scanner;

/**
 * Created by junhyeok on 2017-07-14.
 * Problem NO: 1019
 */
public class Page {
    public static int[] cnts;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 27;
        cnts = new int[10];
        StringBuilder builder = new StringBuilder();
        getTotPage(0, n);
        for (int i = 0; i < 10; i++)
            builder.append(cnts[i] + " ");
        System.out.println(builder.toString().trim());
    }

    public static void getTotPage(int start, int end) {
        int multiply = 1;
        while (start <= end) {
            while ((start % 10 != 0) || (end % 10 != 9)) {
                if (start == end) {
                    calc(start++, multiply);
                    return;
                } else {
                    if (start % 10 != 0)
                        calc(start++,multiply);
                    if (end % 10 != 9 && start!=end)
                        calc(end--,multiply);
                }
            }
            int sDiv = start / 10;
            int eDiv = end / 10;
            int pages = (int) ((eDiv - sDiv + 1) * (Math.pow(10, multiply++ - 1)));
            for (int i = 0; i < 10; i++)
                cnts[i] += pages;
            start /= 10;
            end /= 10;
        }
    }

    public static void calc(int p, int multiply) {
        while (p > 0) {
            cnts[p % 10] += Math.pow(10,multiply-1);
            p /= 10;
        }
    }

}
