package test.kakao.third;

import java.io.*;
import java.util.*;

/**
 * Created by junhyeok on 2017-09-16.
 */

public class P05 {
    public static void main(String[] args) throws IOException {
        String str1="FRANCE";
        String str2="FRENCH";
        System.out.println(solution(str1,str2));
    }

    public static int solution(String str1, String str2) {
        int answer = 0;
        ArrayList<String> set1=new ArrayList<>();
        ArrayList<String> set2=new ArrayList<>();
        HashMap<String, Integer> map1 =new HashMap<>();
        HashMap<String, Integer> map2 =new HashMap<>();
        int common=0;
        int union=0;
        for (int i = 0; i < str1.length()-1; i++) {
            String temp=str1.substring(i,i+2);
            set1.add(temp);
            if(!map1.containsKey(temp)){
                map1.put(temp,1);
            }else{
                map1.put(temp,map1.get(temp)+1);
            }
        }
        for (int i = 0; i < str2.length()-1; i++) {
            String temp=str2.substring(i,i+2);
            set2.add(temp);
            if(!map2.containsKey(temp)){
                map2.put(temp,1);
            }else{
                map2.put(temp,map2.get(temp)+1);
            }
        }
        for (int i = 0; i < set1.size(); i++) {
            if(map1.containsKey(set1.get(i)) && map2.containsKey(set1.get(i))){
                common+=Math.min(map1.get(set1.get(i)),map2.get(set1.get(i)));
                union+=Math.max(map1.get(set1.get(i)),map2.get(set1.get(i)));
                map1.remove(set1.get(i));
                map2.remove(set1.get(i));
            }else{

            }
        }
        for (int i = 0; i < set2.size(); i++) {
            if(map1.containsKey(set2.get(i)) && map2.containsKey(set2.get(i))){
                common+=Math.min(map1.get(set2.get(i)),map2.get(set2.get(i)));
                union+=Math.max(map1.get(set2.get(i)),map2.get(set2.get(i)));
                map1.remove(set2.get(i));
                map2.remove(set2.get(i));
            }

            System.out.println("hi");
        }

        return answer;
    }
}


 
 
 