package view;

import controller.APKController;
import javax.swing.JOptionPane;

public class viewAll {
    private APKController controller;

    public viewAll(APKController controller) {
        this.controller = controller;
    }

    public void tampilMenu() {
        while (true) {
            String menu = "Pilih Menu:\n" +
                          "1. User Data\n" +
                          "2. Nilai Akhir\n" +
                          "3. Rata-rata Nilai Akhir\n" +
                          "4. Jumlah Mahasiswa Tidak Lulus\n" +
                          "5. Matkul yg Diambil Mahasiswa\n" +
                          "6. Total Jam Mengajar Dosen\n" +
                          "7. Gaji Staff\n" +
                          "8. Exit";

            String input = JOptionPane.showInputDialog(menu);
            if (input == null) {
                System.exit(0);
            }

            int choice = -1;
            if (input.matches("\\d+")) {
                choice = Integer.parseInt(input);
            } else {
                JOptionPane.showMessageDialog(null, "Pilihan tidak valid. Masukkan angka antara 1-8.");
                continue;
            }

            switch (choice) {
                case 1:
                    printUserData();
                    break;
                case 2:
                    printNilaiAkhir();
                    break;
                case 3:
                    printRataRataNilai();
                    break;
                case 4:
                    printJumlahTidakLulus();
                    break;
                case 5:
                    printMatkulMahasiswa();
                    break;
                case 6:
                    printTotalJamMengajar();
                    break;
                case 7:
                    printGajiStaff();
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Pilihan tidak valid. Masukkan angka 1-8.");
                    break;
            }
        }
    }

    private void printUserData() {
        String nama = JOptionPane.showInputDialog("Masukkan nama user:");
        if (nama != null && !nama.isEmpty()) {
            String result = controller.getUserData(nama);
            JOptionPane.showMessageDialog(null, result);
        }
    }

    private void printNilaiAkhir() {
        String NIM = JOptionPane.showInputDialog("Masukkan NIM:");
        if (NIM != null && !NIM.isEmpty()) {
            String kodeMK = JOptionPane.showInputDialog("Masukkan Kode Mata Kuliah:");
            if (kodeMK != null && !kodeMK.isEmpty()) {
                String result = controller.getNilaiAkhir(NIM, kodeMK);
                JOptionPane.showMessageDialog(null, result);
            }
        }
    }

    private void printRataRataNilai() {
        String kodeMK = JOptionPane.showInputDialog("Masukkan Kode Mata Kuliah:");
        if (kodeMK != null && !kodeMK.isEmpty()) {
            String result = controller.getRataRataNilaiAkhir(kodeMK);
            JOptionPane.showMessageDialog(null, result);
        }
    }

    private void printJumlahTidakLulus() {
        String kodeMK = JOptionPane.showInputDialog("Masukkan Kode Mata Kuliah:");
        if (kodeMK != null && !kodeMK.isEmpty()) {
            String result = controller.getJumlahTidakLulus(kodeMK);
            JOptionPane.showMessageDialog(null, result);
        }
    }

    private void printMatkulMahasiswa() {
        String NIM = JOptionPane.showInputDialog("Masukkan NIM:");
        if (NIM != null && !NIM.isEmpty()) {
            String result = controller.getMatkulMahasiswa(NIM);
            JOptionPane.showMessageDialog(null, result);
        }
    }

    private void printTotalJamMengajar() {
        String NIK = JOptionPane.showInputDialog("Masukkan NIK Dosen:");
        if (NIK != null && !NIK.isEmpty()) {
            String result = controller.getTotalJamMengajar(NIK);
            JOptionPane.showMessageDialog(null, result);
        }
    }

    private void printGajiStaff() {
        String NIK = JOptionPane.showInputDialog("Masukkan NIK Staff:");
        if (NIK != null && !NIK.isEmpty()) {
            String result = controller.getGajiStaff(NIK);
            JOptionPane.showMessageDialog(null, result);
        }
    }
}
