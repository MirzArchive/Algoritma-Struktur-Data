package practical.utp;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> rangkaian = new LinkedList<>();

        int size = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < size; i++) {
            String carriage = scanner.nextLine();
            switch (carriage.toLowerCase()) {
                case "lokomotif":
                    rangkaian.addFirst(carriage);
                    break;
                case "bagasi":
                    rangkaian.addLast(carriage);
                    break;
                case "restorasi":
                    rangkaian.add(rangkaian.lastIndexOf("Lokomotif") + 1, carriage);
                    break;
                default:
                    rangkaian.add(rangkaian.lastIndexOf("Restorasi") + 1, carriage);
                    break;
            }
        }

        System.out.println(rangkaian);
    }
}
