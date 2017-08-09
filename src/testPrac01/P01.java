package testPrac01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Created by junhyeok on 2017-08-04.
 */
public class P01 {
    private static ArrayList<Order> list;
    private static StringBuilder bd;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("testPrac01_input/p01.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        bd = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            if (st.countTokens() == 3) {
                // order
                st.nextToken();
                int table = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                list.add(new Order(table, time));

            } else if (st.countTokens() == 2) {
                // complete
                st.nextToken();
                int table = Integer.parseInt(st.nextToken());
                int removeIdx = -1;
                for (int j = 0; j < list.size(); j++) {
                    if (table == list.get(j).table) {
                        removeIdx = j;
                    }
                }
                if (removeIdx != -1)
                    list.remove(removeIdx);
            } else {
                // sort
                Collections.sort(list);
            }
            print();
        }
        System.out.println(bd.toString());


    }

    private static void print() {
        if (list.size() == 0) {
            bd.append("sleep\n");
        } else {
            for (Order item :
                    list) {
                bd.append(item.table + " ");
            }
            bd.append("\n");
        }
    }

    private static class Order implements Comparable<Order> {
        int table;
        int time;

        public Order(int table, int time) {
            this.table = table;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Order{" +
                    "table=" + table +
                    ", time=" + time +
                    '}';
        }

        @Override
        public int compareTo(Order o) {
            if (this.time > o.time) {
                return 1;
            } else if (this.time == o.time) {
                if (this.table > o.table) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }

        }
    }
}
