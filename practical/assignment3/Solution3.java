package practical.assignment3;

import java.util.Scanner;
import java.util.Stack;

public class Solution3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Checker checker = new Checker();
        Stack<Character> stack = new Stack<>();
        StringBuilder str = new StringBuilder();

        char[] sentinelQ = (in.nextLine() + ")").toCharArray();
        stack.add('(');

        for (char chara : sentinelQ) {
            if (checker.isOperand(chara)) {
                str.append(chara);
            } else if (chara == '(') {
                stack.add(chara);
            } else if (chara == ')') {
                while (!stack.empty()) {
                    char stackChara = stack.pop();
                    if (stackChara == '(') {
                        break;
                    }
                    str.append(stackChara);
                }
            } else if (checker.isOperator(chara)) {
                if (!stack.empty() && checker.isOperator(stack.peek())) {
                    char stackChara = stack.pop();
                    str.append(stackChara);
                }
                stack.add(chara);
            }
        }

        System.out.println(str.toString());

        in.close();
    }
}

class Checker {
    public boolean isOperand(char chara) {
        return Character.isLetter(chara);
    }

    public boolean isOperator(char chara) {
        switch (chara) {
            case '+':
            case '-':
            case '/':
            case '*':
            case '^':
                return true;
            default:
                return false;
        }
    }

    public boolean isGreaterOrEquals(char a, char b) {
        if (b == '^') {
            if (a == '^') {
                return true;
            } else {
                return false;
            }
        }

        return a <= b;
    }
}
