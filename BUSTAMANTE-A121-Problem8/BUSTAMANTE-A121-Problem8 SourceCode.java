import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanInput = new Scanner(System.in);
        System.out.println("BUSTAMANTE - PLATE #6 QUESTION 8\n");
        System.out.print("Enter number of vertices of the first Graph: ");
        int verticesA = scanInput.nextInt();
        scanInput.nextLine();  

        System.out.print("Enter number of vertices of the second Graph: ");
        int verticesB = scanInput.nextInt();
        scanInput.nextLine();  

        Graph A = new Graph(verticesA);
        Graph B = new Graph(verticesB);

        System.out.println("Enter edges of the first Graph (A,B). Enter \"end\" once all edges are entered:");
        while (true) {
            System.out.print("Edge: ");
            String input = scanInput.nextLine();
            if (input.equals("end")) break;
            String[] edge = input.split(",");
            A.addEdge(edge[0].charAt(0), edge[1].charAt(0));
        }
        System.out.println("Enter edges of the second Graph (A,B). Enter \"end\" once all edges are entered:");
        while (true) {
            System.out.print("Edge: ");
            String input = scanInput.nextLine();
            if (input.equals("end")) break;
            String[] edge = input.split(",");
            B.addEdge(edge[0].charAt(0), edge[1].charAt(0));
        }
        System.out.println();
        if (checkIsomorphism(A, B)) {
            System.out.println("The given graphs are isomorphic");
        } else {
            System.out.println("The given graphs are not isomorphic");
        }
    }
    public static boolean checkIsomorphism(Graph A, Graph B) {
        if (A.getVertexCount() != B.getVertexCount()) {
            return false;
        }
        if (A.getEdgeCount() != B.getEdgeCount()) {
            return false;
        }
        int[] degreesA = A.getDegrees();
        int[] degreesB = B.getDegrees();
        Arrays.sort(degreesA);
        Arrays.sort(degreesB);

        return Arrays.equals(degreesA, degreesB);
    }
}
class Graph {
    private int vertexCount;
    private Map<Character, List<Character>> adjList;
    private List<Vertex> vertices;

    public Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        this.adjList = new HashMap<>();
        this.vertices = new ArrayList<>();
        for (char i = 'A'; i < 'A' + vertexCount; i++) {
            adjList.put(i, new ArrayList<>());
            vertices.add(new Vertex(i));
        }
    }
    public void addEdge(char v1, char v2) {
        adjList.get(v1).add(v2);
        adjList.get(v2).add(v1);
        for (Vertex v : vertices) {
            if (v.label == v1 || v.label == v2) {
                v.degree++;
            }
        }
    }
    public int getVertexCount() {
        return vertexCount;
    }
    public int getEdgeCount() {
        int edgeCount = 0;
        for (List<Character> edges : adjList.values()) {
            edgeCount += edges.size();
        }
        return edgeCount / 2; 
    }
    public int[] getDegrees() {
        int[] degrees = new int[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            degrees[i] = vertices.get(i).degree;
        }
        return degrees;
    }
    class Vertex {
        char label;
        int degree;

        Vertex(char label) {
            this.label = label;
            this.degree = 0;
        }
    }
}
