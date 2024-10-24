package model;

public class MatkulPilihan extends Matkul {
    private int minMahasiswa;

    public MatkulPilihan(String kode, int SKS, String nama, int minMahasiswa) {
        super(kode, SKS, nama);
        this.minMahasiswa = minMahasiswa;
    }

    public int getMinMahasiswa() {
        return minMahasiswa;
    }

    public void setMinMahasiswa(int minMahasiswa) {
        this.minMahasiswa = minMahasiswa;
    }

    @Override
    public String toString() {
        return super.toString() + ", Minimal Mahasiswa Harus: " + minMahasiswa;
    }
}