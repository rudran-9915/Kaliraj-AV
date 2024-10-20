package Graph;

public class Main {
    public static void main(String[] args) {
        // GraphDemo graph = new GraphDemo(5);
        // graph.addEdge(0,1);
        // graph.addEdge(0, 4);
        // graph.addEdge(1, 2);
        // graph.addEdge(1, 4);
        // graph.addEdge(2, 3);
        // graph.addEdge(3, 4);

        // graph.print();
        // System.out.println("BFS");
        // graph.bfs(0);
        // System.out.println("");
        // System.out.println("DFS");
        // graph.dfs(0);

        bfs bfsdemo = new bfs(5);
        bfsdemo.addE(0,1);
        bfsdemo.addE(0,4);
        bfsdemo.addE(1,2);
        bfsdemo.addE(1,4);
        bfsdemo.addE(2,3);
        bfsdemo.addE(3,4);

        bfsdemo.bfsFind(0);
        System.out.println();
        bfsdemo.dfsFind(0);
    }
}
