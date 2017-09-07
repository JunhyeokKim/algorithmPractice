package kakao.second;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by acorn on 2017-09-07.
 */
public class P01 {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("kakao_second/p01.txt")));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        System.out.println(solution(987));
    }

    public static int solution(int n) {
        int answer = 0;
        while (n > 0) {
            answer += n % 10;
            n /= 10;
        }
        return answer;
    }
}
