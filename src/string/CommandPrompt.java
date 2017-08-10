package string;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by acorn on 2017-08-09.
 */
public class CommandPrompt {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("filename.txt")));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = br.readLine();
        }
        LinkedList<Character> lcs = new LinkedList<>();
        for (int i = 0; i < strs[0].length(); i++) {
            lcs.add(strs[0].charAt(i));
        }
        ArrayList<Integer> commonIndex = new ArrayList<>();
        commonIndex.add(0);


    }

    private static void bruteForce(String[] strs, int n) {

        String lcs = strs[0];
        StringBuilder bd = new StringBuilder(strs[0]);
        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                if (lcs.charAt(j) != strs[i].charAt(j)) {

                }
            }
        }
    }

}
