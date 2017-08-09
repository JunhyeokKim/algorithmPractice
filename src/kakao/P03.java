package kakao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by junhyeok on 2017-08-05.
 */
public class P03 {
    public static void main(String[] args) {
        String sentence = "SaIaGaOaNaGJpOpA";
        System.out.println(solution(sentence));
    }

    public static String solution(String sentence) {
        StringBuilder bd = new StringBuilder();
        Set<Character> set = new HashSet<>();
        char[] charArr = sentence.toCharArray();
        int[] startPoint = new int[26];
        int[] endPoint = new int[26];
        int[] symCnt = new int[26];
        ArrayList<String> words = new ArrayList<>();
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] >= 65 && charArr[i] <= 90) {
                // 대문자

            } else {
                if (!set.contains(charArr[i])) {
                    set.add(charArr[i]);
                    startPoint[charArr[i] - 97] = i;
                } else {
                    endPoint[charArr[i] - 97] = i;
                }
                symCnt[charArr[i] - 97]++;
            }
        }
        ArrayList<String> finalWord = new ArrayList<>();

        for (char symbol : set) {
            int idx = symbol - 97;
            if (!(symCnt[idx] > 2 || endPoint[idx] - startPoint[idx] <= 2)) {
                sentence = sentence.replaceAll(String.valueOf(symbol), " ");
                for (String word : sentence.trim().split(" ")) {
                    words.add(word);
                }
            }
        }
        for (char symbol : set) {
            if (words.size() == 0) {
                int idx = symbol - 97;
                if (symCnt[idx] > 2 || endPoint[idx] - startPoint[idx] <= 2) {
                    sentence = sentence.replaceAll(String.valueOf(symbol), "");
                    finalWord.add(sentence);
                }
            } else {
                for (String word : words) {
                    String filtered = word.replaceAll(String.valueOf(symbol), "");
                    finalWord.add(filtered);
                    set.remove(symbol);
                }
            }
        }
        if (finalWord.size() == 0) {
            for (String word : words) {
                bd.append(word + " ");
            }
        } else {
            for (String word : finalWord) {
                bd.append(word + " ");
            }
        }
        return bd.toString().trim();
    }
}
