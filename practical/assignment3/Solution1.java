package practical.assignment3;

import java.util.Scanner;
import java.util.Stack;

public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack<String> papers = new Stack<>();

        while (in.hasNext()) {
            String choice = in.next().toLowerCase();
            switch (choice) {
                case "menumpuk":
                    String name = in.next();
                    in.nextLine();
                    papers.push(name);
                    System.out.printf("%s telah ditambahkan ke dalam tumpukan", name);
                    break;
                case "teratas":
                    if (papers.empty()) {
                        System.out.print("Tumpukan kosong\n");
                        continue;
                    }
                    System.out.printf("Tumpukan teratas adalah %s", papers.peek());
                    break;
                case "koreksi":
                    if (papers.empty()) {
                        System.out.print("Tumpukan kosong\n");
                        continue;
                    }
                    System.out.printf("Tugas %s telah dikoreksi", papers.pop());
                    break;
                case "lihattumpukan":
                    if (papers.empty()) {
                        System.out.print("Tumpukan kosong\n");
                        continue;
                    }
                    System.out.printf("%s", papers.toString().replaceAll("([\\[\\],])", ""));
                    break;
                default: continue;
            }
            System.out.println();
        }
        in.close();
    }
}
