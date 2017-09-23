package test.kakao.third;

import java.io.*;
import java.util.Stack;

/**
 * Created by junhyeok on 2017-09-16.
 */

public class P02 {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "10S*10S*10S*";

        System.out.println(solution(str));
    }

    public static int solution(String dartResult) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < dartResult.length(); i++) {
            char ch = dartResult.charAt(i);
            if (ch == 'S') {
                continue;
            } else if (ch == 'D') {
                int top = stack.pop();
                stack.push(top * top);
            } else if (ch == 'T') {
                int top = stack.pop();
                stack.push(top * top * top);
            } else if (ch == '*') {
                if (stack.size() < 2) {
                    int top = stack.pop();
                    stack.push(top * 2);
                } else {
                    int top = stack.pop();
                    int secondTop = Integer.parseInt(stack.pop().toString());
                    stack.push(2 * secondTop);
                    stack.push(2 * top);
                }
            } else if (ch == '#') {
                int top=stack.pop();
                stack.push(-top);
            } else {
                if (ch == '1' && i + 1 < dartResult.length() && dartResult.charAt(i + 1) == '0') {
                    stack.push(10);
                    i++;
                } else {
                    stack.push(ch - 48);
                }
            }
        }
        for (int num : stack
                ) {
            answer += num;
        }
        return answer;
    }

}


 
 
 