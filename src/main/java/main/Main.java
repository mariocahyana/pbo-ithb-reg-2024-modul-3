package main;

import java.util.ArrayList;
import java.util.List;
import model.*;
import controller.APKController;
import view.viewAll;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        List<Matkul> matkuls = new ArrayList<>();

        // Dummy Matkul
        Matkul matkul1 = new Matkul("0001", 3, "PBO");
        MatkulPilihan matkulPilihan1 = new MatkulPilihan("1002", 3, "KAPSEL", 18);
        
        matkuls.add(matkul1);
        matkuls.add(matkulPilihan1);

        // Dummy Presensi mhs
        List<Presensi> presensiMhs1 = new ArrayList<>();
        List<Presensi> presensiMhs2 = new ArrayList<>();
        presensiMhs1.add(new Presensi("2028-08-8", StatusKehadiran.HADIR));
        presensiMhs1.add(new Presensi("2028-08-9", StatusKehadiran.HADIR));
        presensiMhs2.add(new Presensi("2088-08-8", StatusKehadiran.HADIR));
        presensiMhs2.add(new Presensi("2088-08-9", StatusKehadiran.ALPHA));

        // Dummy Ambil Matkul
        MatkulAmbil matkulAmbil1 = new MatkulAmbil(matkul1, presensiMhs1, 88, 81, 98);
        MatkulAmbil matkulAmbil2 = new MatkulAmbil(matkulPilihan1, presensiMhs2, 50, 45, 40);
        List<MatkulAmbil> matkulAmbilList1 = new ArrayList<>();
        matkulAmbilList1.add(matkulAmbil1);
        matkulAmbilList1.add(matkulAmbil2);

        // Dummy Sarjana
        MahasiswaSarjana mhs1 = new MahasiswaSarjana("Messi", "US", "2888-8-8", "0888", "888", "Informatika", matkulAmbilList1);
        
        // Dummy Magister
        MahasiswaMagister mhs2 = new MahasiswaMagister("Ronaldo", "Arab", "1888-8-8", "088", "88", "SI", matkulAmbilList1, "Analisis Data Pemilu dengan AI");

        // Dummy Doktor
        MahasiswaDoktor mhs3 = new MahasiswaDoktor("Neymar", "Arab", "2008-8-8", "88", "8", "MIT", "Data Mining", 88, 88, 88);

        users.add(mhs1);
        users.add(mhs2);
        users.add(mhs3);

        List<PresensiStaff> presensiStaffList1 = new ArrayList<>();
        presensiStaffList1.add(new PresensiStaff("2028-08-8", StatusKehadiran.HADIR, "07:00"));
        presensiStaffList1.add(new PresensiStaff("2028-08-9", StatusKehadiran.HADIR, "07:00"));
        presensiStaffList1.add(new PresensiStaff("2028-08-10", StatusKehadiran.ALPHA, "10.00"));

        MatkulAjar matkulAjar1 = new MatkulAjar(matkul1, presensiStaffList1);
        List<MatkulAjar> matkulAjarList1 = new ArrayList<>();
        matkulAjarList1.add(matkulAjar1);

        // Dummy Dosen Tetap
        DosenTetap dosenTetap1 = new DosenTetap("Mr Sam", "Malang", "1915-8-8", "11111", "111", "Informatika", matkulAjarList1, 180000);

        // Dummy Dosen Honorer
        DosenHonorer dosenHonorer1 = new DosenHonorer("Mr Ventje", "Semarang", "1908-8-8", "111111", "11", "MIT", matkulAjarList1, 88000);

        users.add(dosenTetap1);
        users.add(dosenHonorer1);

        // Dummy Data Karyawan
        Karyawan karyawan1 = new Karyawan("Baban", "Bandung", "1998-8-8", "222", "22", 4000000, presensiStaffList1);
        
        users.add(karyawan1);

        APKController controller = new APKController(users, matkuls);
        viewAll view = new viewAll(controller);

        view.tampilMenu();
    }
}