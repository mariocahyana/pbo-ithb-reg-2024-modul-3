package model;
import java.util.List;

public class MahasiswaMagister extends Mahasiswa {
    private List<MatkulAmbil> daftarMatkulAmbil;
    private String judulTesis;

    public MahasiswaMagister(String nama, String alamat, String TTL, String telepon, String NIM, String jurusan, List<MatkulAmbil> daftarMatkulAmbil, String judulTesis) {
        super(nama, alamat, TTL, telepon, NIM, jurusan);
        this.daftarMatkulAmbil = daftarMatkulAmbil;
        this.judulTesis = judulTesis;
    }

    public List<MatkulAmbil> getdaftarMatkulAmbil() {
        return daftarMatkulAmbil;
    }

    public void setdaftarMatkulAmbil(List<MatkulAmbil> daftarMatkulAmbil) {
        this.daftarMatkulAmbil = daftarMatkulAmbil;
    }

    public String getJudulTesis() {
        return judulTesis;
    }

    public void setJudulTesis(String judulTesis) {
        this.judulTesis = judulTesis;
    }

    @Override
    public String toString() {
        return super.toString() + ", Matkul yg Diambil: " + daftarMatkulAmbil + ", Judul Tesis: " + judulTesis;
    }
}
