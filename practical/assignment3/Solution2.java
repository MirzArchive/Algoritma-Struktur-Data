package practical.assignment3;

import java.util.Scanner;
import java.util.Stack;

public class Solution2 {
    private static final char[] brackets = {'(', ')', '[', ']', '{', '}'};
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        Scanner in = new Scanner(System.in);
        char openingChar;

        char[] characters = in.nextLine().toCharArray();
        in.close();

        for (char chara : characters) {
            if (isOpeningBracket(chara)) {
                stack.add(chara);
            } else {
                if (stack.empty()) {
                    System.out.println("Salah");
                    return;
                }
                openingChar = stack.pop();
                if (findCorrelatedClosing(openingChar) != chara) {
                    System.out.println("Salah");
                    return;
                }
            }
        }
        System.out.println("Benar");
    }

    private static boolean isOpeningBracket(char chara) {
        for (int i = 0; i < brackets.length; i += 2) {
            if (chara == brackets[i]) {
                return true;
            }
        }
        return false;
    }

    private static char findCorrelatedClosing(char opening) {
        for (int i = 0; i < brackets.length; i += 2) {
            if (opening == brackets[i]) {
                return brackets[i + 1];
            }
        }
        return ' ';
    }
}
