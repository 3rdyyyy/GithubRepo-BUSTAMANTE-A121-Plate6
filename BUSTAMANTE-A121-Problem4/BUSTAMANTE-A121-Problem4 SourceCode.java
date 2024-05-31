import java.util.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("BUSTAMANTE - PLATE #6 QUESTION 4");
        System.out.println("");

        Scanner scanInput = new Scanner(System.in);
        Set<Character> vertices = new HashSet<>(); 
        Map<Character, Integer> vertexDegrees = new HashMap<>();
        System.out.println("Enter edges using the format (AB, AC, DB....). Enter \"end\" when all edges are given.");

        int edgeCount = 1;
        while (true) {
            System.out.print("Edge " + edgeCount + ": ");
            String input = scanInput.nextLine();
            if (input.equalsIgnoreCase("end")) {
                break; }

            char vertex1 = input.charAt(0);
            char vertex2 = input.charAt(1);

            if (vertex1 < vertex2) {
                vertices.add(vertex1);
                vertices.add(vertex2);
                vertexDegrees.put(vertex1, vertexDegrees.getOrDefault(vertex1, 0) + 1);
                vertexDegrees.put(vertex2, vertexDegrees.getOrDefault(vertex2, 0) + 1); }
            edgeCount++;
        }
        System.out.println("\nDegrees:");
        for (char vertex : vertices) {
            System.out.println("deg(" + vertex + ") = " + vertexDegrees.getOrDefault(vertex, 0));
        }
    }
}
