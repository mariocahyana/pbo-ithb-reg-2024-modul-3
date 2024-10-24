package model;

public class PresensiStaff extends Presensi {
    private String jam;

    public PresensiStaff(String tanggal, StatusKehadiran status, String jam) {
        super(tanggal, status);
        this.jam = jam;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    @Override
    public String toString() {
        return super.toString() + ", Jam: " + jam;
    }
}