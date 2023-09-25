import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String input = "Whole Pizza\n";

        Scanner in = new Scanner(input);

        for (int i = 0; in.hasNext(); i++) {
            System.out.println("Iteration: " + (i + 1));
            System.out.println("Input: " + in.next());
        }

        in.close();
    }
}
