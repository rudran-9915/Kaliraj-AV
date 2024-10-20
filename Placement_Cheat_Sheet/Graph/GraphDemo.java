package Graph;

import java.util.*;

public class GraphDemo {
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public GraphDemo(int vertices){
        for(int i=0;i<vertices;i++){
            list.add(new ArrayList<>());
        }
    }

    public void addEdge(int u,int v){
        list.get(u).add(v);
        list.get(v).add(u);
    }

    public void print(){
        for(int i=0;i<list.size();i++){
            System.out.println("Adjacency List for the Vertex - "+i);
            for(int j=0;j<list.get(i).size();j++){
                System.out.println(list.get(i).get(j));
            }
        }
    }

    public void bfs(int sv){
        int V = list.size();
        boolean visited[] = new boolean[V];
        visited[sv]=true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(sv);

        while(!queue.isEmpty()){
            int vertex = queue.poll();
            System.out.print(vertex +" ");
            for(int i=0;i<list.get(vertex).size();i++){
                int av =list.get(vertex).get(i);
                if(!visited[av]){
                    queue.add(av);
                    visited[av]=true;
                }
            }
        }
    }

    public void dfs(int v){
        int V = list.size();
        boolean visited[] = new boolean[V];
        dfs2(v,visited);
    }

    public void dfs2(int v,boolean[] visited){
        visited[v]=true;
        System.out.print(v+" ");
        for(int i=0;i<list.get(v).size();i++){
            int av = list.get(v).get(i);
            if(!visited[av]){
                dfs2(av,visited);
            }
        }
    }


}
