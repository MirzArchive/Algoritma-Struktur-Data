package practical.utp;

import java.util.Scanner;
import java.util.Stack;

public class Solution3 {
    public static boolean checker (String word1, String word2) {
        Stack<Character> word1Stack = new Stack<>();
        Stack<Character> word2Stack = new Stack<>();

        word1 = word1.replaceAll("\\s", "").toLowerCase();
        word2 = word2.replaceAll("\\s", "").toLowerCase();

        for (char chara : word1.toCharArray()) {
            word1Stack.add(chara);
        }
        for (char chara : word2.toCharArray()) {
            word2Stack.add(chara);
        }
        word1Stack = sortStack(word1Stack);
        word2Stack = sortStack(word2Stack);
        System.out.println(word1Stack);
        System.out.println(word2Stack);

        int len = 0;
        if (word1.length() > word2.length()) {
            len = word1.length();
        } else {
            len = word2.length();
        }

        for (int index = 0; index < len; index++) {
            if (word1Stack.pop() != word2Stack.pop()) {

                return false;
            }
        }

        return true; // Ubah return jika dibutuhkan
    }

    // Gunakan method ini dan jangan diubah kodenya
    private static Stack<Character> sortStack(Stack<Character> stack) {
        Stack<Character> sortedStack = new Stack<>();
        while (!stack.isEmpty()) {
            char temp = stack.pop();
            while (!sortedStack.isEmpty() && temp > sortedStack.peek()) {
                stack.push(sortedStack.pop());
            }
            sortedStack.push(temp);
        }
        return sortedStack;
    }

    // Jangan ubah main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.nextLine();
        String word2 = sc.nextLine();

        if (checker(word1, word2)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
