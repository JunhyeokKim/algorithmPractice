package test.nhn;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by junhyeok on 2017-09-23.
 */

public class P01 {
    final static int N_OF_ITEM = 6;
    final static int POCKET_AVAILABLE = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder bd= new StringBuilder();
        while (st.hasMoreTokens()){
            int item = Integer.parseInt(st.nextToken());
            if (queue.size() < POCKET_AVAILABLE) {
                queue.add(item);
            }else{
                if(queue.contains(item)){
                    queue.remove(item);
                    queue.add(item);
                }else{
                    int removed=queue.remove();
                    queue.add(item);
                    bd.append(removed+"\n");
                }
            }
        }
        System.out.println(bd.toString().trim());


    }

}


 
 
 