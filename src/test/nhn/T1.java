package test.nhn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by junhyeok on 2017-09-22.
 */
public class T1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Comparator<Integer> order= new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                char[] c1 = o1.toString().toCharArray();
                char[] c2 = o2.toString().toCharArray();
                if(c1.length==c2.length){
                    if(c1.length==1){
                        if(c1[0]>c2[0]){
                            return 1;
                        }
                    }else {
                        if(c1[0]>c2[0]){
                            return 1;
                        }else if(c1[0]==c2[0] && c1[1]>c2[1]){
                            return 1;
                        }
                    }
                }else{
                    for (int i = 0; i < c1.length; i++) {
                        for (int j = 0; j < c2.length; j++) {
                            if(c1[i]>c2[j]){
                                return 1;
                            }else if(c1[i]==c2[j]){
                                continue;
                            }
                        }
                    }
                }

                return -1;
            }
        };
        Comparator<Integer> reverseOrder= new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                char[] c1 = o1.toString().toCharArray();
                char[] c2 = o2.toString().toCharArray();
                if(c1.length==c2.length){
                    if(c1.length==1){
                        if(c1[0]<c2[0]){
                            return 1;
                        }
                    }else {
                        if(c1[0]<c2[0]){
                            return 1;
                        }else if(c1[0]==c2[0] && c1[1]<c2[1]){
                            return 1;
                        }
                    }
                }else{
                    for (int i = 0; i < c1.length; i++) {
                        for (int j = 0; j < c2.length; j++) {
                            if(c1[i]<c2[j]){
                                return 1;
                            }else if(c1[i]==c2[j]){
                                continue;
                            }
                        }
                    }
                }

                return -1;
            }
        };
        PriorityQueue<Integer> orderQueue = new PriorityQueue<>(order);
        PriorityQueue<Integer> reverseQueue = new PriorityQueue<>(reverseOrder);
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            orderQueue.add(num);
            reverseQueue.add(num);
        }
        StringBuilder bd = new StringBuilder();
        while (!orderQueue.isEmpty()) {
            bd.append(orderQueue.remove());
        }
        BigInteger min = new BigInteger(bd.toString());
        bd = new StringBuilder();
        while (!reverseQueue.isEmpty()) {
            bd.append(reverseQueue.remove());
        }
        BigInteger max = new BigInteger(bd.toString());
        System.out.println("min: " + min.toString());
        System.out.println("max: " + max.toString());
        System.out.println(min.add(max).toString());


    }

}
