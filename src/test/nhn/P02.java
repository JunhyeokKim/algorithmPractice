package test.nhn;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by junhyeok on 2017-09-23.
 */

public class P02 {
    final static int PIVOT = 97;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "encrypt sec 1 he";
        StringTokenizer st = new StringTokenizer(input);
        String result = "";
        String cmd = st.nextToken();
        String key = st.nextToken();
        int rot = Integer.parseInt(st.nextToken());
        String str = st.nextToken();

        if (cmd.equals("encrypt")) {
            String encrypted = encrypt(str, key);
            result = rotate(encrypted, rot);
        } else if (cmd.equals("decrypt")) {
            result = rotate(str, -rot);
            result = decrypt(result, key);

        }
        System.out.println(result);

    }

    private static String decrypt(String str, String key) {
        char[] chars = str.toCharArray();
        int len = 0;
        while (len < str.length()) {
            for (int i = 0; i < key.length(); i++) {
                char res = (char) ((int) key.charAt(i) - PIVOT);
                if (chars[len] - res < PIVOT) {
                    chars[len] = (char) (123-(PIVOT - (chars[len] - res)));
                } else {
                    chars[len] = (char) (chars[len] - res);
                }
                len++;
                if (len >= str.length()) {
                    break;
                }
            }
        }
        return String.valueOf(chars);
    }

    private static String rotate(String encrypted, int rot) {
        if (rot == 0) {
            return encrypted;
        } else if (rot > 0) {
            String subStr = encrypted.substring(0, rot);
            encrypted = encrypted.substring(rot);
            encrypted += subStr;
        } else {
            rot=-rot;
            int st=encrypted.length()-rot;
            String subStr = encrypted.substring(st);
            encrypted = encrypted.substring(0, st);
            encrypted = subStr + encrypted;
        }
        return encrypted;
    }

    private static String encrypt(String str, String key) {
        char[] chars = str.toCharArray();
        int len = 0;
        while (len < str.length()) {
            for (int i = 0; i < key.length(); i++) {
                char res = (char) ((int) key.charAt(i) - PIVOT);
                if (res + chars[len] > 122) {
                    chars[len] = (char) (PIVOT + res + chars[len] - 123);
                } else {
                    chars[len] = (char) (chars[len] + res);
                }
                len++;
                if (len >= str.length()) {
                    break;
                }
            }
        }
        return String.valueOf(chars);
    }

}


 
 
 