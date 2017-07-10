package networkFlow;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by junhyeok on 2016-10-21.
 */
public class CowMatching {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("input4.txt"));
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        int height=0;
        List<Vertex>[] cows = new LinkedList[n];

        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            Vertex temp = null;
            cows[i]=new LinkedList<>();
            for (int j = 0; j < k; j++) {
                    cows[i].add( new Vertex(sc.nextInt(), null));
            }
        }
        for (Vertex v:cows[0]
             ) {

            int temp=dfs(v,0);
            if(temp>height)
                height=temp;
        }

    }
    static void createTree(Vertex v,List[] cows){
        int n=cows.length;
        for(int i=1; i<cows.length; i++){

        }
    }

    static int dfs(Vertex v,int sum) {
        v.visited=true;
        Edge e= v.adjacencyList;
        int max=0;
        while(e.next!=null){
            if(e.to.visited && e.to!=null) {
                int temp=dfs(e.to, sum);
                if(temp>max){
                    max=temp;
                }
            }
            e=e.next;
        }
        return sum+1;
    }

    static class Graph{
        Vertex vertices;
        int vertexCount;
        public Graph(){
            this.vertices=null;
            this.vertexCount=0;
        }
        public void addVertex(Vertex v){
            if(vertexCount==0)
                vertices=v;
            else{
                Vertex temp=vertices;
                while(temp.next!=null){
                    temp=temp.next;
                }
                temp.next=v;
            }
            vertexCount++;
        }
        public void addEdge(Vertex v, Edge e){
            if(v.adjacencyList==null)
                v.adjacencyList=e;
            else{
                Edge adjacency=v.adjacencyList;
                while(adjacency.next!=null){
                    adjacency=adjacency.next;
                }
                adjacency.next=e;
            }
        }
    }
    static class Edge {
        Vertex from;
        Vertex to;
        Edge next;
        public Edge(Vertex from, Vertex to){
            this.from=from;
            this.to=to;
        }

    }

    static class Vertex {
        int n;
        Vertex next;
        Edge adjacencyList;
        boolean visited;


        public Vertex() {
            //
            this.n = -1;
        }

        public Vertex(int n, Vertex next) {
            this.n = n;
            this.next = next;
            this.visited=false;
        }

    }

}
