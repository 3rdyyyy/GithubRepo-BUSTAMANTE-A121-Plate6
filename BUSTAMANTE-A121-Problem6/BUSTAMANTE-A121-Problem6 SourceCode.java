import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanInput = new Scanner(System.in);
        System.out.println("BUSTAMANTE - PLATE #6 QUESTION 6\n");
        System.out.println("Enter edges using the format (AB, AC, DB, AA, BB...). Enter \"end\" when all edges are given.");

        Set<Character> vertices = new HashSet<>();
        List<String> edges = new ArrayList<>();
        Map<Character, Integer> vertexIndexes = new HashMap<>();

        int edgeCount = 1;
        while (true) {
            System.out.print("Edge " + edgeCount + ": ");
            String input = scanInput.nextLine();
            if (input.equalsIgnoreCase("end")) break;

            char vertex1 = input.charAt(0);
            char vertex2 = input.charAt(1);
            vertices.add(vertex1);
            vertices.add(vertex2);
            edges.add(input);
            edgeCount++;
        }

        int index = 0;
        for (char vertex : vertices) {
            vertexIndexes.put(vertex, index++);
        }

        int[][] adjacencyMatrix = new int[vertices.size()][vertices.size()];
        for (String edge : edges) {
            int index1 = vertexIndexes.get(edge.charAt(0));
            int index2 = vertexIndexes.get(edge.charAt(1));
            adjacencyMatrix[index1][index2]++;
        }

        System.out.println("\nAdjacency Matrix:");
        System.out.print("  ");
        for (char vertex : vertices) {
            System.out.print(vertex + " ");
        }
        System.out.println();
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            System.out.print(vertices.toArray()[i] + " ");
            for (int j : adjacencyMatrix[i]) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
