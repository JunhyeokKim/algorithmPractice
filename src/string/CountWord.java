package string;

import java.io.*;

/**
 * Created by junhyeok on 2017-07-23.
 * Problem No:1152
 */
public class CountWord {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("countWord.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str= "The Curious Case of Benjamin Button";
        //String str = br.readLine().trim();
        boolean flag = false;
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ' && !flag) {
                cnt++;
                flag = true;
            } else if (str.charAt(i) == ' ' && flag) {
                flag = false;
            }
        }
        System.out.println(cnt);
    }
}
