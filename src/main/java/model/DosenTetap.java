package model;
import java.util.List;

public class DosenTetap extends Dosen {
    private double salary;

    public DosenTetap(String nama, String alamat, String TTL, String telepon, String NIK, String departemen, List<MatkulAjar> matkulAjarList, double salary) {
        super(nama, alamat, TTL, telepon, NIK, departemen, matkulAjarList);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() + ", Salary: " + salary;
    }
}