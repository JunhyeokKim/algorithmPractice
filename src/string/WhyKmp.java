package string;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by junhyeok on 2017-08-14.
 */

public class WhyKmp {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input/whyKmp.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        StringBuilder bd = new StringBuilder();
        while (st.hasMoreTokens()) {
            bd.append(st.nextToken().charAt(0));
        }
        System.out.println(bd.toString());

    }

}


 
 
 