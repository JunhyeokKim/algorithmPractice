package graph;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by junhyeok on 2017-08-19.
 */

public class FinalRank {
    static LinkedList<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input/file.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder bd = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            adjList = new LinkedList[n + 1];
            int[] rank = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                rank[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 1; j < rank.length - 1; j++) {
                if (adjList[rank[j]] == null) {
                    adjList[rank[j]] = new LinkedList<>();
                }
                adjList[rank[j]].add(rank[j + 1]);
            }

            int m = Integer.parseInt(br.readLine());
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int prev = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

            }
        }

    }

}


 
 
 