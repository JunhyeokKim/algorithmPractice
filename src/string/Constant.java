package string;


import java.io.*;

/**
 * Created by junhyeok on 2017-07-23.
 * Problem No: 2908
 */
public class Constant {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("constant.txt")));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = br.readLine().split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numbers[0].length(); i++) {
            builder.append(numbers[0].charAt(numbers[0].length()-i-1));
        }
        int n = Integer.parseInt(builder.toString());
        builder = new StringBuilder();
        for (int i = 0; i < numbers[1].length(); i++) {
            builder.append(numbers[1].charAt(numbers[1].length()-i-1));
        }
        int m = Integer.parseInt(builder.toString());
        System.out.println((n > m) ? n : m);

    }

}
