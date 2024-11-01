package controller;

import model.*;
import java.util.List;

public class APKController {
    private List<User> users;
    private List<Matkul> matkuls;

    public APKController(List<User> users, List<Matkul> matkuls) {
        this.users = users;
        this.matkuls = matkuls;
    }

    // menu 1
    public String getUserData(String nama) {
        for (User user : users) {
            if (user.getNama().equalsIgnoreCase(nama)) {
                String status = "";
                if (user instanceof MahasiswaSarjana) {
                    status = "Mahasiswa Sarjana";
                } else if (user instanceof MahasiswaMagister) {
                    status = "Mahasiswa Magister";
                } else if (user instanceof MahasiswaDoktor) {
                    status = "Mahasiswa Doktor";
                } else if (user instanceof DosenTetap) {
                    status = "Dosen Tetap";
                } else if (user instanceof DosenHonorer) {
                    status = "Dosen Honorer";
                } else if (user instanceof Karyawan) {
                    status = "Karyawan";
                }
                return user.toString() + "\nStatus: " + status;
            }
        }
        return "User tidak ditemukan";
    }

    // menu 2
    public String getNilaiAkhir(String NIM, String kodeMK) {
        for (User user : users) {
            if (user instanceof Mahasiswa && ((Mahasiswa) user).getNIM().equals(NIM)) {
                if (user instanceof MahasiswaDoktor) {
                    MahasiswaDoktor mhs = (MahasiswaDoktor) user;
                    double NA = (mhs.getNilaiSidang1() + mhs.getNilaiSidang2() + mhs.getNilaiSidang3()) / 3;
                    return String.format("Nilai Akhir: %.2f", NA);
                } else if (user instanceof MahasiswaSarjana || user instanceof MahasiswaMagister) {
                    List<MatkulAmbil> matkulList;
                    if (user instanceof MahasiswaSarjana) {
                        matkulList = ((MahasiswaSarjana) user).getdaftarMatkulAmbil();
                    } else {
                        matkulList = ((MahasiswaMagister) user).getdaftarMatkulAmbil();
                    }

                    for (MatkulAmbil mk : matkulList) {
                        if (mk.getMatkul().getKode().equals(kodeMK)) {
                            double NA = (mk.getN1() + mk.getN2() + mk.getN3()) / 3;
                            return String.format("Nilai Akhir: %.2f", NA);
                        }
                    }
                    return "Mata kuliah tidak ditemukan";
                }
            }
        }
        return "Mahasiswa tidak ditemukan";
    }

    // menu 3
    public String getRataRataNilaiAkhir(String kodeMK) {
        double total = 0;
        int count = 0;

        for (User user : users) {
            if (user instanceof MahasiswaSarjana || user instanceof MahasiswaMagister) {
                List<MatkulAmbil> matkulList;
                if (user instanceof MahasiswaSarjana) {
                    matkulList = ((MahasiswaSarjana) user).getdaftarMatkulAmbil();
                } else {
                    matkulList = ((MahasiswaMagister) user).getdaftarMatkulAmbil();
                }

                for (MatkulAmbil mk : matkulList) {
                    if (mk.getMatkul().getKode().equals(kodeMK)) {
                        double NA = (mk.getN1() + mk.getN2() + mk.getN3()) / 3;
                        total += NA;
                        count++;
                    }
                }
            }
        }

        if (count > 0) {
            return String.format("Rata-rata Nilai Akhir: %.2f", total / count);
        }
        return "Tidak ada data nilai untuk mata kuliah tersebut";
    }

    // menu 4
    public String getJumlahTidakLulus(String kodeMK) {
        int totalMhs = 0;
        int tidakLulus = 0;
        String namaMK = "";

        for (User user : users) {
            if (user instanceof MahasiswaSarjana || user instanceof MahasiswaMagister) {
                List<MatkulAmbil> matkulList;
                if (user instanceof MahasiswaSarjana) {
                    matkulList = ((MahasiswaSarjana) user).getdaftarMatkulAmbil();
                } else {
                    matkulList = ((MahasiswaMagister) user).getdaftarMatkulAmbil();
                }

                for (MatkulAmbil mk : matkulList) {
                    if (mk.getMatkul().getKode().equals(kodeMK)) {
                        namaMK = mk.getMatkul().getNama();
                        double NA = (mk.getN1() + mk.getN2() + mk.getN3()) / 3;
                        totalMhs++;
                        if (NA < 56) {
                            tidakLulus++;
                        }
                    }
                }
            }
        }

        if (totalMhs > 0) {
            return String.format("%d dari %d mahasiswa tidak lulus matakuliah %s",
                    tidakLulus, totalMhs, namaMK);
        }
        return "Tidak ada data untuk mata kuliah tersebut";
    }

    // menu 5
    public String getMatkulMahasiswa(String NIM) {
        for (User user : users) {
            if (user instanceof Mahasiswa && ((Mahasiswa) user).getNIM().equals(NIM)) {
                if (user instanceof MahasiswaSarjana) {
                    return printMatkulList(((MahasiswaSarjana) user).getdaftarMatkulAmbil());
                } else if (user instanceof MahasiswaMagister) {
                    return printMatkulList(((MahasiswaMagister) user).getdaftarMatkulAmbil());
                }
            }
        }
        return "Mahasiswa tidak ditemukan";
    }

    private String printMatkulList(List<MatkulAmbil> matkulList) {
        StringBuilder result = new StringBuilder("Daftar Mata Kuliah:\n");
        for (MatkulAmbil mk : matkulList) {
            int totalPresensi = 0;
            for (Presensi p : mk.getPresensiList()) {
                if (p.getStatus() == StatusKehadiran.HADIR) {
                    totalPresensi++;
                }
            }
            result.append(String.format("%s - Total Presensi: %d\n",
                    mk.getMatkul().getNama(), totalPresensi));
        }
        return result.toString();
    }

    // menu 6
    public String getTotalJamMengajar(String NIK) {
        for (User user : users) {
            if (user instanceof Dosen && ((Dosen) user).getNIK().equals(NIK)) {
                Dosen dosen = (Dosen) user;
                int totalJam = 0;

                for (MatkulAjar mk : dosen.getdaftarMatkulAjar()) {
                    for (PresensiStaff p : mk.getlistPresensiStaff()) {
                        if (p.getStatus() == StatusKehadiran.HADIR) {
                            totalJam += 1;
                        }
                    }
                }
                return String.format("Total jam mengajar: %d jam", totalJam);
            }
        }
        return "Dosen tidak ditemukan";
    }

    // menu 7
    public String getGajiStaff(String NIK) {
        for (User user : users) {
            if (user instanceof Staff && ((Staff) user).getNIK().equals(NIK)) {
                if (user instanceof Karyawan) {
                    Karyawan k = (Karyawan) user;
                    int totalHadir = 0;
                    for (PresensiStaff p : k.getlistPresensiStaff()) {
                        if (p.getStatus() == StatusKehadiran.HADIR) {
                            totalHadir++;
                        }
                    }
                    double gaji = (totalHadir / 22.0) * k.getSalary();
                    return String.format("Gaji Karyawan: Rp %.2f", gaji);

                } else if (user instanceof DosenTetap) {
                    DosenTetap dt = (DosenTetap) user;
                    int totalUnit = 0;
                    for (MatkulAjar mk : dt.getdaftarMatkulAjar()) {
                        for (PresensiStaff p : mk.getlistPresensiStaff()) {
                            if (p.getStatus() == StatusKehadiran.HADIR) {
                                totalUnit++;
                            }
                        }
                    }
                    double gaji = dt.getSalary() + (totalUnit * 25000);
                    return String.format("Gaji Dosen Tetap: Rp %.2f", gaji);

                } else if (user instanceof DosenHonorer) {
                    DosenHonorer dh = (DosenHonorer) user;
                    int totalUnit = 0;
                    for (MatkulAjar mk : dh.getdaftarMatkulAjar()) {
                        for (PresensiStaff p : mk.getlistPresensiStaff()) {
                            if (p.getStatus() == StatusKehadiran.HADIR) {
                                totalUnit++;
                            }
                        }
                    }
                    double gaji = totalUnit * dh.getHonorPerSKS();
                    return String.format("Gaji Dosen Honorer: Rp %.2f", gaji);
                }
            }
        }
        return "Staff tidak ditemukan";
    }
}
