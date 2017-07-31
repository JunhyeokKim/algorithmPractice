package graph.shortestPath;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by junhyeok on 2017-07-29.
 * Problem No: 11657
 * 음수 가중치를 갖는 그래프의 최단경로의 길이를 구하는 문제이다.
 * 음수 가중치에서의 최단경로 문제는  벨만포드 알고리즘을 사용하여 구할 수 있다.
 * 1. 모든 d값을 무한대로 설정
 * 2. d[0](시작점까지의 거리)를 0으로 설정
 * n-1번동안 모든 에지들을 relax해준다.
 * 마지막 n번째에서 모든 에지들을 릴렉스 할 때, 이때 한번이라도 d값이 작아지는 경우가 있다면 음수 사이클이 존재하는 것이다.
 */
public class TimeMachine {
    public final static int MAX = 987654321;        // INF
    public static int[] d;  //최소 거리
    public static HashMap<Integer, ArrayList<Edge>> edges;      // adjVertexs

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("timeMachine.txt")));
        StringBuilder bd = new StringBuilder();
        String str[] = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        edges = new HashMap<>();
        d = new int[n + 1];
        Arrays.fill(d, MAX);
        for (int i = 0; i < m; i++) {
            String[] params = br.readLine().split(" ");
            if (!edges.containsKey(Integer.valueOf(params[0]))) {
                edges.put(Integer.valueOf(params[0]), new ArrayList<>());
            }
            edges.get(Integer.parseInt(params[0])).add(new Edge(Integer.parseInt(params[1]), Integer.parseInt(params[2])));
        }
        d[1] = 0;
        // 음수 사이클 여부
        boolean checkCycle = false;
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                ArrayList<Edge> adj = edges.get(i);
                if (adj != null) {
                    for (Edge edge : adj) {
                        if (d[edge.v] > d[i] + edge.w) {
                            d[edge.v] = d[i] + edge.w;
                            if (k == n) {
                                checkCycle = true;
                            }
                        }
                    }
                }
            }
        }
        if (checkCycle) {
            bd.append(-1);
        } else {
            for (int i = 2; i <= n; i++) {
                bd.append(((d[i] == MAX) ? -1 : d[i])+"\n");
            }
        }
        System.out.println(bd.toString());
    }

    private static class Edge {
        int v;
        int w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
