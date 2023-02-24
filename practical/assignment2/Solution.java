/*
 * Mirza Hilmi Shodiq
 * 225150707111067
 */

package practical.assignment2;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Train train = new Train();

        while (in.hasNextLine()) {
            String cmd = in.next().toLowerCase();

            try {
                switch (cmd) {
                    case "tambahdepan":
                        train.addFront(in.nextInt());
                        in.nextLine();
                        System.out.println("Berhasil menambahkan gerbong");
                        break;
                    case "tambahbelakang":
                        train.addBehind(in.nextInt());
                        in.nextLine();
                        System.out.println("Berhasil menambahkan gerbong");
                        break;
                    case "tambahtengah":
                        train.addMiddle(in.nextInt(), in.nextInt());
                        in.nextLine();
                        System.out.println("Berhasil menambahkan gerbong");
                        break;
                    case "hapusdepan":
                        train.removeFront();
                        System.out.println("Berhasil menghapus gerbong");
                        break;
                    case "hapusbelakang":
                        train.removeBehind();
                        System.out.println("Berhasil menghapus gerbong");
                        break;
                    case "hapusgerbong":
                        train.remove(in.nextInt());
                        in.nextLine();
                        System.out.println("Berhasil menghapus gerbong");
                        break;
                    case "urutkangerbong":
                        train.sort();
                        System.out.println("Gerbong telah diurutkan");
                        break;
                    case "lihatkereta":
                        String out = train.toString();
                        System.out.println(!out.isEmpty() ? out : "Kereta kosong");
                        break;
                    default: continue;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class Train {
    private LinkedList<Integer> carriages;

    public Train() {
        this.carriages = new LinkedList<>();
    }

    public void addFront(int number) throws Exception {
        if (carriages.contains(number)) {
            throw new Exception("Gagal menambahkan gerbong");
        }

        carriages.addFirst(number);
    }

    public void addBehind(int number) throws Exception {
        if (carriages.contains(number)) {
            throw new Exception("Gagal menambahkan gerbong");
        }

        carriages.addLast(number);
    }

    public void addMiddle(int cursor, int number) throws Exception {
        if (carriages.contains(number)) {
            throw new Exception("Gagal menambahkan gerbong");
        }

        int cursorIndex = carriages.indexOf(cursor);
        if (cursorIndex == -1) {
            throw new Exception("Gagal menambahkan gerbong");
        }

        carriages.add(cursorIndex + 1, number);
    }

    public void removeFront() throws Exception {
        try {
            carriages.removeFirst();
        } catch (Exception e) {
            throw new Exception("Gagal menghapus gerbong");
        }
    }

    public void removeBehind() throws Exception {
        try {
            carriages.removeLast();
        } catch (Exception e) {
            throw new Exception("Gagal menghapus gerbong");
        }
    }

    public void remove(int number) throws Exception {
        int carriageIndex = carriages.indexOf(number);
        if (carriageIndex == -1) {
            throw new Exception("Gagal menghapus gerbong");
        }

        carriages.remove(carriageIndex);
    }

    public void sort() {
        carriages.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });
    }

    @Override
    public String toString() {
        return carriages.toString().replaceAll("([\\[\\],])", "");
    }
}
