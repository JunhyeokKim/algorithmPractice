package testPrac01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by junhyeok on 2017-08-04.
 */
public class P03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("testPrac01_input/p03.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        String c = st.nextToken();
        char end = c.charAt(c.length() - 1);
        if (end == '0' || end == '2' || end == '4' || end == '6' || end == '8') {
            System.out.println((a ^ b) ^ b);
        } else {
            System.out.println(a ^ b);
        }
    }
}
