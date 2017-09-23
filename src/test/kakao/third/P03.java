package test.kakao.third;

import java.io.*;
import java.util.*;

/**
 * Created by junhyeok on 2017-09-16.
 */

public class P03 {
    public static void main(String[] args) throws IOException {
        int n = 2;
        String[] cities = {
                "Jeju", "Jeju", "Jeju", "Pangyo", "Pangyo", "Pangyo", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"
        };
        System.out.println(solution(n, cities));
    }

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
        }
        HashMap<String, Record> map = new HashMap<>(cacheSize);
        PriorityQueue<Record> queue = new PriorityQueue<>(new Comparator<Record>() {
            @Override
            public int compare(Record o1, Record o2) {
                if (o1.cnt == o2.cnt) {
                    if (o1.time > o2.time) {
                        return 1;
                    } else return -1;
                }else if(o1.time>o2.time){
                    return 1;
                }else{
                    return -1;
                }
            }
        });
        for (int i = 0; i < cities.length; i++) {
            if (map.containsKey(cities[i])) {
                Record temp = map.get(cities[i]);
                queue.remove(temp);
                temp.time = i;
                temp.cnt++;
                queue.add(temp);
                answer++;
            } else {
                if (cacheSize <= queue.size()) {
                    Record temp = queue.poll();
                    map.remove(temp.city);
                }
                Record temp = new Record(cities[i], i);
                queue.add(temp);
                map.put(cities[i], temp);
                answer += 5;
            }
        }


        return answer;
    }

    static class Record {
        String city;
        int cnt;
        int time;

        public Record(String city, int time) {
            this.cnt = 1;
            this.city = city;
            this.time = time;
        }

    }
}



 
 
 