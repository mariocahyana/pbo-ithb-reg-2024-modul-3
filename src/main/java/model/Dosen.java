package model;
import java.util.List;

public class Dosen extends Staff {
    private String departemen;
    private List<MatkulAjar> daftarMatkulAjar;

    public Dosen(String nama, String alamat, String TTL, String telepon, String NIK, String departemen, List<MatkulAjar> daftarMatkulAjar) {
        super(nama, alamat, TTL, telepon, NIK);
        this.departemen = departemen;
        this.daftarMatkulAjar = daftarMatkulAjar;
    }

    public String getDepartemen() {
        return departemen;
    }

    public void setDepartemen(String departemen) {
        this.departemen = departemen;
    }

    public List<MatkulAjar> getdaftarMatkulAjar() {
        return daftarMatkulAjar;
    }

    public void setdaftarMatkulAjar(List<MatkulAjar> daftarMatkulAjar) {
        this.daftarMatkulAjar = daftarMatkulAjar;
    }

    @Override
    public String toString() {
        return super.toString() + ", Departemen: " + departemen + ", Mata Kuliah yang Diajar: " + daftarMatkulAjar;
    }
}