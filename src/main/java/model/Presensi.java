package model;

public class Presensi {
    private String tanggal;
    private StatusKehadiran status;

    public Presensi(String tanggal, StatusKehadiran status) {
        this.tanggal = tanggal;
        this.status = status;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public StatusKehadiran getStatus() {
        return status;
    }

    public void setStatus(StatusKehadiran status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Tanggal: " + tanggal + ", Status Khadiran: " + status;
    }
}