import java.util.*;
public class Main {

    public static void main(String[] args) {
        System.out.println("BUSTAMANTE - PLATE #6 QUESTION 3");
        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        Map<Integer, List<Integer>> graph = new HashMap<>();

        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < numVertices; i++) {
            graph.put(i, new ArrayList<>()); }

        System.out.println("Enter edges using the format (1,0). Enter \"end\" when all edges are given.");
        System.out.println("");

        while (true) {
            System.out.print("Edge: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("end")) {
                System.out.println();
                break; }

            String[] parts = input.replaceAll("[()]", "").split(",");
            int vertex1 = Integer.parseInt(parts[0].trim());
            int vertex2 = Integer.parseInt(parts[1].trim());

            graph.get(vertex1).add(vertex2);
        }

        if (hasCycle(graph)) {
            System.out.println("The graph has a cycle.");
        } else {
            System.out.println("The graph does not have a cycle."); }
        scanner.close();
    }

    private static boolean hasCycle(Map<Integer, List<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> stack = new HashSet<>();

        for (int vertex : graph.keySet()) {
            if (hasCycleUtil(vertex, graph, visited, stack)) {
                return true; 
            }
        }
        return false;
    }
    private static boolean hasCycleUtil(int vertex, Map<Integer, List<Integer>> graph, Set<Integer> visited, Set<Integer> stack) {
        if (stack.contains(vertex)) {
            return true; 
        }
        if (visited.contains(vertex)) {
            return false; 
        }
        visited.add(vertex);
        stack.add(vertex);

        for (int neighbor : graph.getOrDefault(vertex, Collections.emptyList())) {
            if (hasCycleUtil(neighbor, graph, visited, stack)) {
                return true;
            }
        }
        stack.remove(vertex);
        return false;
    }
}
