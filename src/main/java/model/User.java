package model;

public abstract class User {
    private String nama;
    private String alamat;
    private String TTL;
    private String telepon;

    public User(String nama, String alamat, String TTL, String telepon) {
        this.nama = nama;
        this.alamat = alamat;
        this.TTL = TTL;
        this.telepon = telepon;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTTL() {
        return TTL;
    }

    public void setTTL(String TTL) {
        this.TTL = TTL;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    @Override
    public String toString() {
        return "Nama: " + nama + ", Alamat: " + alamat + ", TTL: " + TTL + ", Telp: " + telepon;
    }
}