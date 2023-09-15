/*
 * Mirza Hilmi Shodiq
 * 225150707111067
 */

package theory.lk2;

import java.util.LinkedList;

public class MirzaHilmiShodiq {
    public static void main(String[] args) {
        // Mendeklarasi serta Instansiasi LinkedList dengan
        // class elemennya adalah Mahasiswa
        LinkedList<String> list = new LinkedList<>();

        // Menampilkan elemen yang ada pada list
        System.out.println(list); // Output: []

        // Menambahkan string "Mirza" pada list
        list.add("Mirza");
        System.out.println(list); // Output: [Mirza]

        // Menambahkan string "Shodiq" sebagai elemen pada indeks ke 1 dari list
        list.add(1, "Shodiq");
        System.out.println(list); // Output: [Mirza, Shodiq]

        // Menambahkan string "Hilmi" sebagai elemen pada indeks ke 1 dari list.
        // Elemen ini akan menggeser elemen sebelumnya ("Shodiq")
        // pada posisi setelahnya
        list.add(1, "Hilmi");
        System.out.println(list); // Output: [Mirza, Hilmi, Shodiq]

        // Menambahkan string "Mahasiswa" sebagai elemen diawal list, sehingga
        // elemen lainnya akan tergeser 1 indeks setelahnya.
        // Method ini memiliki fungsi yang sama dengan .add(0, "Mahasiswa")
        list.addFirst("Mahasiswa");
        System.out.println(list); // Output: [Mahasiswa, Mirza, Hilmi, Shodiq]

        // Menambahkan string "FILKOM" sebagai elemen diakhir list
        list.addLast("FILKOM");
        System.out.println(list); // Output: [Mahasiswa, Mirza, Hilmi, Shodiq, FILKOM]

        // Menghapus elemen ke-0 dari list, operasi ini akan mengakibatkan
        // elemen-elemen setelahnya untuk bergeser
        list.remove(0);
        System.out.println(list); // Output: [Mirza, Hilmi, Shodiq, FILKOM]

        // Meghapus elemen berdasarkan object tersebut, disini saya
        // menghapus elemen string "FILKOM" dengan cara mencantumkannya pada parameter
        list.remove("FILKOM");
        System.out.println(list); // Output: [Mirza, Hilmi, Shodiq]

        // Menghapus seluruh elemen yang ada pada list
        list.clear();
        System.out.println(list); // Output: []

        // Menambahkan kembali elemen-elemen pada list agar tidak kosong
        list.add("Go");
        list.add("Rust");
        list.add("Ruby");
        list.add("Docker");
        System.out.println(list); // Output: ["Go", "Rust", "Ruby", "Docker"]

        // Menghapus elemen pertama dari sebuah list. Method ini memiliki fungsi
        // yang sama dengan .remove(0)
        list.removeFirst();
        System.out.println(list); // Output: ["Rust", "Ruby", "Docker"]

        // Menghapus elemen terakhir dari list
        list.removeLast();
        System.out.println(list); // Output: ["Rust", "Ruby"]

        list.add("Kafka");
        list.add("Ruby");
        System.out.println(list); // Output: ["Rust", "Ruby", "Kafka", "Ruby"]

        // Menghapus elemen pertama yang ditemukan
        list.removeFirstOccurrence("Rust");
        System.out.println(list); // Output: ["Ruby", "Kafka", "Ruby"]

        // Menghapus elemen terakhir yang ditemukan
        list.removeLastOccurrence("Ruby");
        System.out.println(list); // Output: ["Ruby", "Kafka"]

        // Memeriksa apakah suatu elemen ada pada list
        System.out.println(list.contains("Kafka")); // Output: true

        // Mengembalikan indeks dari suatu elemen, jika tidak ditemukan
        // maka akan mengembalikan nilai -1
        System.out.println(list.indexOf("Kafka")); // Output: 1

        // Mengembalikan indeks dari suatu elemen terakhir yang ditemukan,
        // jika tidak ditemukan maka akan mengembalikan nilai -1
        System.out.println(list.indexOf("Ruby")); // Output: 0

        // Mengembalikan elemen sesuai index yang diberikan
        System.out.println(list.get(1)); // Output: Kafka

        // Mengembalikan elemen pertama
        System.out.println(list.getFirst()); // Output: Ruby

        // Mengembalikan elemen terakhir
        System.out.println(list.getLast()); // Output: Kafka

        // Mengubah elemen dengan elemen lain menggunakan indeks
        list.set(0, "Docker");
        System.out.println(list.getFirst()); // Output: Docker

        // Mengembalikan jumlah elemen dari list
        System.out.println(list.size()); // Output: 2

        // Memeriksa apakah sebuah list kosong (tidak memiliki elemen) atau tidak
        System.out.println(list.isEmpty()); // Output: false

        // Mengubah LinkedList menjadi array of object
        Object[] arr = list.toArray();
        System.out.println(arr.getClass().getSimpleName()); // Output: Object[]
    }
}
