package theory.sk2;

import java.util.Scanner;
import java.util.Stack;

/*
 * Anggota 1:
 * Mirza Hilmi Shodiq
 * 225150707111067
 *
 * Anggota 2:
 * Fiego Triwanda Putra
 * 225150700111033
 *
 * Anggota 3:
 * Dwi Rama Prasetiya
 * 225150700111036
 */

public class SK02_3_225150707111067_MirzaHilmiShodiq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StandardInput stdin = new StandardInput();

        System.out.printf("\n%s%s Selamat datang di Aplikasi Rumah Sakit GKM ❤️‍🩹 %s", Color.YELLOW_BG, Color.WHITE, Color.RESET);

        System.out.printf("\n\n%sSilahkan masukkan nama pasien!%s ", Color.CYAN, Color.RESET);
        String name = sc.nextLine();
        Patient patient = new Patient(name);

        app: while (true) {
            System.out.printf("\n%sPasien: %s%s", Color.BLUE, patient.getName(), Color.RESET);
            System.out.print("\n1. Tampilkan riwayat\n2. Ubah riwayat\n3. Exit");
            System.out.print("\n[1/2/3]: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.printf("\n%sRiwayat Pasien%s", Color.YELLOW, Color.RESET);
                    if (patient.getHistoryOfIllness() == null) {
                        System.out.print("\nRiwayat masih kosong...\n");
                    } else {
                        System.out.printf("\n%s\n", patient.getHistoryOfIllness());
                    }
                    break;
                case "2":
                    inputCycle: while (true) {
                        System.out.printf("\n%sKalimat: %s%s", Color.CYAN, stdin, Color.RESET);
                        System.out.print("\nInput: ");
                        String input = sc.nextLine();

                        if (input.isBlank()) {
                            System.out.printf("\n%sInput tidak boleh kosong%s\n", Color.RED_BG, Color.RESET);
                            continue;
                        }

                        switch (input.toLowerCase()) {
                            case "z":
                                stdin.undo();
                                break;
                            case "y":
                                stdin.redo();
                                break;
                            default:
                                try {
                                    for (String word : input.split(" ")) {
                                        stdin.input(word);
                                    }
                                } catch (Exception e) {
                                    System.out.printf("\n%sRiwayat pasien maksimal hanya 6 kata%s\n", Color.RED_BG, Color.RESET);
                                    break inputCycle;
                                }
                        }

                        if (stdin.isFull()) {
                            patient.setHistoryOfIllness(stdin.toString());
                            System.out.printf("\n%sBerhasil menyimpan data riwayat pasien%s\n", Color.GREEN_BG, Color.RESET);
                            break inputCycle;
                        }
                    }
                   break;
                case "3":
                    System.out.printf("\n%s%sTerima Kasih telah menggunakan layanan kami 🥰%s\n", Color.YELLOW_BG, Color.WHITE, Color.RESET);
                    break app;
                default:
                    System.out.printf("\n%sPilih Angka 1-3!%s\n", Color.RED_BG, Color.RESET);
            }
        }

        sc.close();
    }
}

interface Operation {
    public void input(String arg) throws Exception;

    public void undo();

    public void redo();

    public boolean isFull();
}

class StandardInput implements Operation {
    private Stack<String> buffer;
    private Stack<String> history;

    public StandardInput() {
        buffer = new Stack<>();
        history = new Stack<>();
    }

    public void input(String arg) throws Exception {
        if (isFull()) {
            throw new Exception("Riwayat tidak dapat lebih dari 6 kata!");
        }

        if (!history.empty()) {
            history.clear();
        }

        buffer.add(arg);
    }

    public void undo() {
        if (buffer.empty()) {
            return;
        }

        String str = buffer.pop();
        history.add(str);
    }

    public void redo() {
        if (history.empty()) {
            return;
        }

        String str = history.pop();
        buffer.add(str);
    }

    public boolean isFull() {
        if (buffer.size() == 6) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return buffer.toString().replaceAll("([\\[\\],])", "");
    }
}

class Patient {
    private String name;
    private String historyOfIllness;

    public Patient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHistoryOfIllness() {
        return historyOfIllness;
    }

    public void setHistoryOfIllness(String historyOfIllness) {
        this.historyOfIllness = historyOfIllness;
    }
}

enum Color {
    RESET("\033[0m"),
    RED_BG("\033[0;101m"),
    CYAN("\033[0;36m"),
    BLUE("\033[0;34m"),
    YELLOW("\033[0;33m"),
    YELLOW_BG("\033[0;103m"),
    GREEN_BG("\033[42m"),
    WHITE("\033[1;37m");

    private final String ansiCode;

    private Color(String ansiCode) {
        this.ansiCode = ansiCode;
    }

    @Override
    public String toString() {
        return ansiCode;
    }
}
