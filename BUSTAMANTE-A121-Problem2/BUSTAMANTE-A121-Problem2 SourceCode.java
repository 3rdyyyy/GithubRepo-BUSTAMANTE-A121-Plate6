import java.util.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("BUSTAMANTE - PLATE #6 QUESTION 2");
        System.out.println("");
        Scanner scanInput = new Scanner(System.in);
        List<String> edges = new ArrayList<>();
        List<Integer> edgeCounts = new ArrayList<>();
        String[] verticeNames = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        
        System.out.println("Input each row of the adjacency matrix by following the format (1,0,0,1). Type \"end\" when all rows are given.");
        
        int rowCount = 0;
        int expectedColumns = -1;

        while (true) {
            System.out.print("Enter row " + (rowCount + 1) + ": ");
            String input = scanInput.nextLine();
            if (input.equalsIgnoreCase("end")) break;
            
            String[] row = input.split(",");
            if (expectedColumns == -1) {
                expectedColumns = row.length;
            } else if (row.length != expectedColumns) {
                System.out.println("Invalid row length. Please enter a row with " + expectedColumns + " columns.");
                continue; }

            for (int i = 0; i < row.length; i++) {
                int count;
                try {
                    count = Integer.parseInt(row[i]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format. Please enter integers.");
                    continue;
                }
                if (count > 0) {
                    edges.add(verticeNames[rowCount] + verticeNames[i]);
                    edgeCounts.add(count); }
            }
            rowCount++; }

        System.out.println("Edges = " + edges);
        System.out.println();
        for (int i = 0; i < edges.size(); i++) {
            System.out.println("Edge " + edges.get(i) + " appeared " + edgeCounts.get(i) + " times."); }
       
        scanInput.close();
    }
}
