/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

/**
 *
 * @author agusb
 */
import java.util.Scanner;

public class CatatanManager {
    private Catatan[] catatanList;
    private int jumlahCatatan;

    // Constructor
    public CatatanManager(int ukuran) {
        catatanList = new Catatan[ukuran];
        jumlahCatatan = 0;
    }

    public void tambahCatatan(String isi) {
        if (jumlahCatatan < catatanList.length) {
            catatanList[jumlahCatatan] = new Catatan(jumlahCatatan + 1, isi);
            jumlahCatatan++;
            System.out.println("Catatan berhasil ditambahkan.");
        } else {
            System.out.println("List catatan penuh.");
        }
    }

    public void tampilkanCatatan() {
        for (int i = 0; i < jumlahCatatan; i++) {
            System.out.println(catatanList[i]);
        }
    }

    public boolean ubahCatatan(int id, String isiBaru) {
        for (int i = 0; i < jumlahCatatan; i++) {
            if (catatanList[i].getId() == id) {
                catatanList[i].setIsi(isiBaru);
                return true;
            }
        }
        return false;
    }

    public boolean hapusCatatan(int id) {
        for (int i = 0; i < jumlahCatatan; i++) {
            if (catatanList[i].getId() == id) {
                for (int j = i; j < jumlahCatatan - 1; j++) {
                    catatanList[j] = catatanList[j + 1];
                }
                catatanList[jumlahCatatan - 1] = null;
                jumlahCatatan--;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CatatanManager manager = new CatatanManager(10);
        boolean running = true;

        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Tambah Catatan");
            System.out.println("2. Tampilkan Catatan");
            System.out.println("3. Ubah Catatan");
            System.out.println("4. Hapus Catatan");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan isi catatan: ");
                    String isi = scanner.nextLine();
                    manager.tambahCatatan(isi);
                    break;
                case 2:
                    manager.tampilkanCatatan();
                    break;
                case 3:
                    System.out.print("Masukkan ID catatan yang akan diubah: ");
                    int idUbah = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan isi baru: ");
                    String isiBaru = scanner.nextLine();
                    if (manager.ubahCatatan(idUbah, isiBaru)) {
                        System.out.println("Catatan berhasil diubah.");
                    } else {
                        System.out.println("Catatan tidak ditemukan.");
                    }
                    break;
                case 4:
                    System.out.print("Masukkan ID catatan yang akan dihapus: ");
                    int idHapus = scanner.nextInt();
                    if (manager.hapusCatatan(idHapus)) {
                        System.out.println("Catatan berhasil dihapus.");
                    } else {
                        System.out.println("Catatan tidak ditemukan.");
                    }
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }

        scanner.close();
    }
}
