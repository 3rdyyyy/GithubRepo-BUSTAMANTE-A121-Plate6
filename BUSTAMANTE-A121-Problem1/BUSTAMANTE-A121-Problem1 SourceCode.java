import java.util.*;

class Graph {
    private int V;
    private List<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public Graph(int v) {
        V = v;
        adj = new ArrayList[v];
        for (int i = 0; i < v; i++) adj[i] = new ArrayList<>(); }

    public void addEdge(int u, int w) {
        adj[u].add(w);
        adj[w].add(u); }

    private void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        adj[v].forEach(n -> { if (!visited[n]) DFSUtil(n, visited); }); }

    public int countComponents() {
        boolean[] visited = new boolean[V];
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) { DFSUtil(i, visited); count++; }
        }
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("BUSTAMANTE - PLATE #6 QUESTION 1\n");
        Scanner scanInput = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int verticesNum = scanInput.nextInt();
        Graph newGraph = new Graph(verticesNum);
        scanInput.nextLine(); 

        System.out.println("Enter the edges using the format (0,1)");
        System.out.println("Enter \"end\" after all inputs are entered: \n");
        while (true) {
            String input = scanInput.nextLine();
            if (input.equalsIgnoreCase("end")) break;
            String[] edge = input.split(",");
            newGraph.addEdge(Integer.parseInt(edge[0]), Integer.parseInt(edge[1]));
        }
        
        int connectedComponents = newGraph.countComponents();
        System.out.println("\nThe graph is " + (connectedComponents == 1 ? "connected" : "disconnected with " + connectedComponents + " connected components."));
        scanInput.close();
    }
}
