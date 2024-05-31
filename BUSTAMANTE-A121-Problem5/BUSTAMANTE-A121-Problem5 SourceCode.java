import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanInput = new Scanner(System.in);
        System.out.println("BUSTAMANTE - PLATE #6 QUESTION 5\n");
        System.out.println("Enter edges using the format (AB, DB....). Enter \"end\" when all edges are given.");

        Set<Character> vertices = new HashSet<>();
        List<String> edges = new ArrayList<>();
        Map<Character, List<Character>> adjacencyList = new HashMap<>();

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

            adjacencyList.putIfAbsent(vertex1, new ArrayList<>());
            adjacencyList.putIfAbsent(vertex2, new ArrayList<>());
            adjacencyList.get(vertex1).add(vertex2);
            adjacencyList.get(vertex2).add(vertex1);

            edgeCount++;
        }
        boolean isBipartite = checkBipartite(adjacencyList, vertices);
        if (isBipartite) {
            System.out.println("\nThe graph is bipartite.");
        } else {
            System.out.println("\nThe graph is not bipartite.");
        }
    }
    static boolean checkBipartite(Map<Character, List<Character>> adjacencyList, Set<Character> vertices) {
        Map<Character, Integer> colors = new HashMap<>();
        for (char vertex : vertices) {
            colors.put(vertex, -1);
        }
        for (char vertex : vertices) {
            if (colors.get(vertex) == -1) {
                if (!bfsCheck(adjacencyList, vertex, colors)) {
                    return false;
                }
            }
        }
        return true;
    }
    static boolean bfsCheck(Map<Character, List<Character>> adjacencyList, char startVertex, Map<Character, Integer> colors) {
        Queue<Character> queue = new LinkedList<>();
        queue.add(startVertex);
        colors.put(startVertex, 0);

        while (!queue.isEmpty()) {
            char current = queue.poll();
            for (char neighbor : adjacencyList.get(current)) {
                if (colors.get(neighbor) == -1) {
                    colors.put(neighbor, 1 - colors.get(current));
                    queue.add(neighbor);
                } else if (colors.get(neighbor).equals(colors.get(current))) {
                    return false;
                }
            }
        }
        return true;
    }
}
