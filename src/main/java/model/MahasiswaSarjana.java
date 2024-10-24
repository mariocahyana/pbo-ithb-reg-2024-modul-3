package model;
import java.util.List;

public class MahasiswaSarjana extends Mahasiswa {
    private List<MatkulAmbil> daftarMatkulAmbil;

    public MahasiswaSarjana(String nama, String alamat, String TTL, String telepon, String NIM, String jurusan, List<MatkulAmbil> daftarMatkulAmbil) {
        super(nama, alamat, TTL, telepon, NIM, jurusan);
        this.daftarMatkulAmbil = daftarMatkulAmbil;
    }

    public List<MatkulAmbil> getdaftarMatkulAmbil() {
        return daftarMatkulAmbil;
    }

    public void setdaftarMatkulAmbil(List<MatkulAmbil> daftarMatkulAmbil) {
        this.daftarMatkulAmbil = daftarMatkulAmbil;
    }

    @Override
    public String toString() {
        return super.toString() + ", Matkul yg Diambil: " + daftarMatkulAmbil;
    }
}
