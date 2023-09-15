import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc;
        String header, menuList;
        int option, inNum, inSecondNum;
        float total;
        boolean attempt;

        header = "Calculator\n============\nTotal = ";
        menuList = "1. Addition\n2. Substraction\n3. Multiplication";
        attempt = false;
        total = 0F;
        sc = new Scanner(System.in);
        sc.close();

        while (true) {
            System.out.printf("\n%s%s\n", header, total);

            if (!attempt) {
                attempt = true;
                System.out.print("\nInput number : ");
                inNum = sc.nextInt();
            } else {
                inNum = 0;
            }

            System.out.print(menuList);
            System.out.print("\nOperator [1...3]: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("\nInput number : ");
                    inSecondNum = sc.nextInt();
                    total += inNum + inSecondNum;
                break;
                case 2:
                    System.out.print("\nInput number : ");
                    inSecondNum = sc.nextInt();
                    total += inNum - inSecondNum;
            }
            System.out.println("===============");
        }
    }
}
