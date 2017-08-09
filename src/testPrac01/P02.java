package testPrac01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by junhyeok on 2017-08-04.
 */
public class P02 {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("testPrac01_input/p02.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder bd = new StringBuilder();
        int n = 20;
        float winRate = Float.parseFloat(st.nextToken());
        float loseRate = Float.parseFloat(st.nextToken());
        float drawRate = Float.parseFloat(st.nextToken());

    }
}
