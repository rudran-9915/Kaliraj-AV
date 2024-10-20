package Graph;

import java.util.*;
public class DFS
{
  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int e = sc.nextInt();
    graph g = new graph(n);
    for(int i=0;i<e;i++){
	int u = sc.nextInt();
    int v = sc.nextInt();
    g.addEdge(u,v);   
  }
   sc.close();
    g.dfs(0);
}
}

class graph{
  private ArrayList<ArrayList<Integer>> list = new ArrayList<>();
  public graph(int v){
	for(int i=0;i<v;i++){
		list.add(new ArrayList<>());
    }
  }
  public  void addEdge(int u,int v){
    list.get(u).add(v);
    list.get(v).add(u);
  }
  
  
 public  void dfs(int v){
	int V = list.size();
    boolean visited[] = new boolean[V];
    dfsHelper(v,visited); 
}
  public  void dfsHelper(int v , boolean[] visited){
	visited[v]=true;
    System.out.print(v+" ");
    for(int i=0;i<list.get(v).size();i++){
		int av = list.get(v).get(i);
        if(!visited[av]){
			dfsHelper(av,visited);
        }
    }
  }
}

