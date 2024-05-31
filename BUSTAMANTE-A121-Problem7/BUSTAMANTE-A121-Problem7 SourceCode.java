import java.util.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("BUSTAMANTE - PLATE #6 QUESTION 7");
        System.out.println("");

        Scanner scanInput = new Scanner(System.in);
        System.out.println("Input the edges along with the number of times each edge appears (AB 1, AC 1, BA 1...): ");
        System.out.print("User Input: ");
        String[] input = scanInput.nextLine().split(",");
        input = removeSameValues(input);
        System.out.println();
        System.out.println(Arrays.toString(input));

        Character[] verticeNames = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        int highestIndex = 0;
        for (String e : input) {
            String[] pointer = e.split(" ");
            for (char c : pointer[0].toCharArray()) {
                int charIndex = Arrays.asList(verticeNames).indexOf(c);
                if (charIndex > highestIndex) highestIndex = charIndex;
            }
        }
        System.out.println();
        System.out.println("Incidence Matrix: ");
        Character[] visited = Arrays.copyOfRange(verticeNames, 0, highestIndex + 1);
        PrintEdges(input);

        for (char A : visited) {
            Integer[] row = new Integer[input.length];
            Arrays.fill(row, 0);
            int indexPointer = 0;
            for (String e : input) {
                String[] pointer = e.split(" ");
                if (pointer[0].contains(String.valueOf(A))) row[indexPointer] = Integer.valueOf(pointer[1]);
                indexPointer++;
            }
            System.out.print(A + " ");
            System.out.println(Arrays.toString(row));
            indexPointer = 0;
        }
        scanInput.close();
    }
    static String[] removeSameValues(String[] vals) {
        List<String> values = Arrays.asList(vals);
        ArrayList<String> newVList = new ArrayList<>();
        ArrayList<String> wanted = new ArrayList<>();
        for (String v : values) {
            if (wanted.contains(v)) continue;
            String[] pointer = v.split(" ");
            String newWanted = "" + pointer[0].toCharArray()[1] + pointer[0].toCharArray()[0] + " " + pointer[1];
            wanted.add(newWanted);
            newVList.add(v);
        }
        return newVList.toArray(new String[newVList.size()]);
    }
    static void PrintEdges(String[] vals) {
        StringBuilder result = new StringBuilder("  ");
        for (String A : vals) {
            String[] pointer = A.split(" ");
            result.append(pointer[0]).append(" ");
        }
        System.out.println(result);
    }
}
