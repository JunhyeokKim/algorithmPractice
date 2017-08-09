package testPrac01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by junhyeok on 2017-08-04.
 */
public class P05 {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("testPrac01_input/p04.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder bd = new StringBuilder();
        int n= Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());

        }

    }

}
