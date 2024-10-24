package model;
import java.util.List;

public class Karyawan extends Staff {
    private double salary;
    private List<PresensiStaff> listPresensiStaff;

    public Karyawan(String nama, String alamat, String TTL, String telepon, String NIK, double salary, List<PresensiStaff> listPresensiStaff) {
        super(nama, alamat, TTL, telepon, NIK);
        this.salary = salary;
        this.listPresensiStaff = listPresensiStaff;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<PresensiStaff> getlistPresensiStaff() {
        return listPresensiStaff;
    }

    public void setlistPresensiStaff(List<PresensiStaff> listPresensiStaff) {
        this.listPresensiStaff = listPresensiStaff;
    }

    @Override
    public String toString() {
        return super.toString() + ", Salary: " + salary + ", Presensi: " + listPresensiStaff;
    }
}