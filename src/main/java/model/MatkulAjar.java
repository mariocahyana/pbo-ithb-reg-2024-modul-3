package model;
import java.util.List;

public class MatkulAjar {
    private Matkul matkul;
    private List<PresensiStaff> listPresensiStaff;

    public MatkulAjar(Matkul matkul, List<PresensiStaff> listPresensiStaff) {
        this.matkul = matkul;
        this.listPresensiStaff = listPresensiStaff;
    }

    public Matkul getMatkul() {
        return matkul;
    }

    public void setMatkul(Matkul matkul) {
        this.matkul = matkul;
    }

    public List<PresensiStaff> getlistPresensiStaff() {
        return listPresensiStaff;
    }

    public void setlistPresensiStaff(List<PresensiStaff> listPresensiStaff) {
        this.listPresensiStaff = listPresensiStaff;
    }

    @Override
    public String toString() {
        return "Matkul Diajar: " + matkul + ", Presensi Staff: " + listPresensiStaff;
    }
}