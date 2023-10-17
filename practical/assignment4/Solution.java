package practical.assignment4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VaccineQueue queue = new VaccineQueue();

        while (sc.hasNext()) {
            String keyword = sc.next();
            switch (keyword.toLowerCase()) {
                case "mengantri":
                    String name = sc.next();
                    queue.enque(name);
                    System.out.printf("%s telah ditambahkan ke dalam antrian\n", name);
                    break;

                case "antrianselanjutnya":
                    name = queue.peek();
                    if (name == null) {
                        System.out.println("Antrian kosong");
                        break;
                    }

                    System.out.printf("Antrian terdepan adalah %s\n", name);
                    break;

                case "panggil":
                    name = queue.deque();
                    if (name == null) {
                        System.out.println("Antrian kosong");
                        break;
                    }

                    System.out.printf("%s telah meninggalkan antrian\n", name);
                    break;

                case "lihatantrian":
                    String queueStr = queue.toString();
                    if (queueStr.isEmpty()) {
                        System.out.println("Antrian kosong");
                        break;
                    }

                    System.out.println(queueStr);
            }
        }

        sc.close();
    }
}

class VaccineQueue {
    private Queue<String> queue;

    public VaccineQueue() {
        queue = new LinkedList<>();
    }

    public void enque(String name) {
        queue.add(name);
    }

    public String deque() {
        return queue.poll();
    }

    public String peek() {
        return queue.peek();
    }

    @Override
    public String toString() {
        return queue.toString().replaceAll("[\\[\\],]", "");
    }
}
