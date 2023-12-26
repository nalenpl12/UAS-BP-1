import java.time.LocalDate;
import java.util.Scanner;

public class ProgramKasir {

     static final int MAX_BARANG = 22;

     // Fungsi untuk menampilkan menu dengan array 1 dimensi
     static final String[] DaftarMenu = {
          "Black Forest", "Choco Frappe", "Ice Dark Choco", "Ice Matcha Latte", "Mango and Milk",
          "Oreo Frappe", "Red Velvet", "Vanilla Biscoff", "Strawberry and Milk",
          "Lemon Tea", "Lychee Tea", "Peach Tea", "Creamy Orange", "Creamy Pineapple",
          "Creamy Watermelon", "Mango Mint", "Snow White", "Americano", "Cafe Latte",
          "Cappuccino", "Coffee Butter", "Espresso", "Mockaccino"
     };
     static final double[] HargaMenu = {
          15000, 18000, 15000, 15000, 18000, 32000,
          18000, 15000, 20000, 15000,
          15000, 15000, 18000, 20000, 20000,
          22000, 22000, 22000, 12000, 14000,
          15000, 18000, 14000, 15000
     };

     // Fungsi untuk menampilkan menu kasir
     static void tampilkanMenuKasir() {
          System.out.println("==============================");
          System.out.println("| 1. Pilih Menu              |");
          System.out.println("| 2. Cari Barang             |");
          System.out.println("| 3. Pilih Metode Pembayaran |");
          System.out.println("| 4. Tampilkan Daftar Barang |");
          System.out.println("| 5. Keluar                  |");
          System.out.println("==============================");
     }

     // Fungsi untuk menampilkan daftar menu barang
     static void tampilkanDaftarMenu() {
          System.out.println("=============== MENU ==============");
          for (int i = 0; i < DaftarMenu.length; i++) {
               System.out.printf("| %-2d. %-20s %-6.0f |\n", i + 1, DaftarMenu[i], HargaMenu[i]);
          }
          System.out.println("===================================");
     }

     // Fungsi untuk menampilkan barang yang telah diinput
     static void tampilkanBarang(String[] namaBarang, double[] hargaBarang) {
          System.out.println("========== DAFTAR BARANG ==========");
          System.out.printf("%-20s %-10s\n", "Nama Barang", "\t  Harga");
          for (int i = 0; i < namaBarang.length; i++) {
               if (namaBarang[i] != null) {
                    System.out.printf("-> %-20s @ %-10.2f\n", namaBarang[i], hargaBarang[i]);
               }
          }
          System.out.println("===================================");
     }

     // Fungsi untuk menghitung total harga
     static double hitungTotalHarga(double[] hargaBarang) {
          double totalHarga = 0;
          for (double harga : hargaBarang) {
               totalHarga += harga;
          }
          return totalHarga;
     }

     // Fungsi untuk mencetak struk
     static void cetakStruk(String[] namaBarang, double[] hargaBarang, String namaPelanggan) {
          LocalDate tanggalPembelian = LocalDate.now(); // Mengambil tanggal saat ini
          System.out.println("========= STRUK PEMBELIAN =========");
          System.out.printf("Tanggal Pembelian : %s\n", tanggalPembelian);
          System.out.printf("Nama Pelanggan    : %s\n", namaPelanggan);
          System.out.println("===================================");
          System.out.printf("%-20s %-10s\n", "Nama Barang", "\t  Harga");
          for (int i = 0; i < namaBarang.length; i++) {
               if (namaBarang[i] != null) {
                    System.out.printf("> %-20s @ %-10.2f\n", namaBarang[i], hargaBarang[i]);
               }
          }
          System.out.println("===================================");
          System.out.printf("%-20s \t@ %-10.2f\n", "Total Harga", hitungTotalHarga(hargaBarang));
          System.out.println("===================================");
     }

     // Fungsi untuk mencari barang
     static int cariBarang(String[] namaBarang, String barangDicari) {
          for (int i = 0; i < namaBarang.length; i++) {
               if (namaBarang[i] != null && namaBarang[i].equalsIgnoreCase(barangDicari)) {
                    return i;
               }
          }
          return -1;
     }

     // Fungsi untuk menampilkan metode pembayaran non-tunai
     static void tampilkanMetodeNonTunai() {
          System.out.println("============ Metode Pembayaran Non-Tunai ============");
          System.out.println("| 1. Kartu Kredit                                   |");
          System.out.println("| 2. Transfer Bank                                  |");
          System.out.println("| 3. E-Wallet (OVO, Dana, Gopay.)                   |");
          System.out.println("=====================================================");
     }

     public static void main(String[] args) {
          try (Scanner scanner = new Scanner(System.in)) {
               int pilihan;
               int jumlahBarang = 0;
               String[] namaBarang = new String[MAX_BARANG];
               double[] hargaBarang = new double[MAX_BARANG];
               String namaPelanggan = ""; // Menambahkan variable untuk menyimpan nama pelanggan
               do {
                    tampilkanMenuKasir();
                    System.out.print("Pilih menu (1-6): ");
                    pilihan = scanner.nextInt();
                    scanner.nextLine(); // Membuang karakter newline
                    System.out.println("");
                    switch (pilihan) {
                         case 1:
                              do {
                                   tampilkanDaftarMenu();
                                   System.out.print("Pilih nomor menu: ");
                                   int nomorMenu = scanner.nextInt();
                                   scanner.nextLine(); // Membuang karakter newline
                                   if (nomorMenu >= 1 && nomorMenu <= DaftarMenu.length) {
                                        namaBarang[jumlahBarang] = DaftarMenu[nomorMenu - 1];
                                        hargaBarang[jumlahBarang] = HargaMenu[nomorMenu - 1];
                                        jumlahBarang++;
                                   } else {
                                        System.out.println("Nomor menu tidak tersedia.");
                                   }

                                   // Tanya pengguna apakah ingin input barang lagi
                                   System.out.print("Apakah ingin menginput barang lagi? (ya/tidak): ");
                                   String jawaban = scanner.nextLine().toLowerCase();
                                   if (!jawaban.equals("ya")) {
                                        System.out.print("Pesanan ini atas nama: ");
                                        namaPelanggan = scanner.nextLine();
                                        break; // Keluar dari loop jika jawaban bukan "ya"
                                   }
                              } while (true);
                              break;
                         case 2:
                              if (jumlahBarang > 0) {
                                   System.out.print("Masukkan nama barang yang dicari: ");
                                   String barangDicari = scanner.nextLine();
                                   int indexBarang = cariBarang(namaBarang, barangDicari);
                                   if (indexBarang != -1) {
                                        System.out.println("Barang ditemukan! Nama: " + namaBarang[indexBarang] + ", Harga: " + hargaBarang[indexBarang]);
                                   } else {
                                        System.out.println("Barang tidak ditemukan.");
                                   }
                              } else {
                                   System.out.println("Belum ada barang yang dimasukkan.");
                              }
                              break;
                         case 3:
                              if (jumlahBarang > 0) {
                                   System.out.println("===== Metode Pembayaran =====");
                                   System.out.println("| 1. Tunai                  |");
                                   System.out.println("| 2. Non-Tunai              |");
                                   System.out.println("=============================");
                                   System.out.print("Pilih Metode Pembayaran (1/2): ");
                                   int MetodePembayaran = scanner.nextInt();
                                   scanner.nextLine();
                                   if (MetodePembayaran == 1) {
                                        cetakStruk(namaBarang, hargaBarang, namaPelanggan);
                                   } else if (MetodePembayaran == 2) {
                                        tampilkanMetodeNonTunai();
                                        System.out.print("Pilih Meotde Pembayaran (1-3):");
                                        int metodeNonTunai = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println();
                                        switch (metodeNonTunai) {
                                             case 1:
                                                  System.out.println("Anda memilih Kartu Kredit");
                                                  break;
                                             case 2:
                                                  System.out.println("Anda memilih Transfer Bank");
                                                  break;
                                             case 3:
                                                  System.out.println("Anda memilih E-Wallet");
                                                  break;
                                             default:
                                                  System.out.println("Pilihan tidak valid.");
                                                  break;
                                        }
                                   } else {
                                        System.out.println("Pilihan tidak valid.");
                                   }
                              } else {
                                   System.out.println("Belum ada barang yang dipilih. Silahkan pilih menu terlebih dahulu!");
                              }
                              break;
                         case 4:
                              if (jumlahBarang > 0) {
                                   tampilkanBarang(namaBarang, hargaBarang);
                              } else {
                                   System.out.println("Belum ada barang yang dimasukkan.");
                              }
                              break;
                         case 5:
                              System.out.println("Terima kasih...");
                              break;
                         default:
                              System.out.println("Pilihan tidak valid. Masukkan angka 1-6.");
                              break;
                    }
               } while (pilihan != 5);
          }
     }
}
