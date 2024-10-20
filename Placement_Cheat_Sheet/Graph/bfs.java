package Graph;

import java.util.*;

public class bfs {
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public bfs(int vertices){
        for(int i=0;i<vertices;i++){

            list.add(new ArrayList<>());
        }
    }

    public void addE(int u,int v){
        list.get(u).add(v);
        list.get(v).add(u);
    }

    public void bfsFind(int sv){
        int V = list.size();
        boolean visited[] = new boolean[V];
        visited[sv]=true;
        Queue<Integer> q = new LinkedList<>();
        q.add(sv);

        while(!q.isEmpty()){
            int vertex = q.poll();
            System.out.print(vertex+" ");
            for(int i=0;i<list.get(vertex).size();i++){
                int av = list.get(vertex).get(i);
                if(!visited[av]){
                    q.add(av);
                    visited[av]=true;
               }
            }
        }
    }

    public void dfsFind(int sv){
        int v = list.size();
        boolean visited[] = new boolean[v];
        dfsHelper(sv,visited);
    }

    public void dfsHelper(int sver,boolean[] visited){
       visited[sver]=true;
       System.out.print(sver+" ");
       for(int i=0;i<list.get(sver).size();i++){
           int av = list.get(sver).get(i);
           if(!visited[av]){
            dfsHelper(av, visited);;
           }
       }
    }
}
