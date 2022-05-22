package oltest.bai9.ThaiVanNam;

public class Book {
    int maSach;
    String tenSach;
    int soTrang;
    float giaBan;
    String moTa;
    //xay dung  cac phuong thuc khoi tao gia tri cho cac thuoc tinh

    //xay dung cac phuong thuc lay gia tri cac thuoc tinh(cac getter)

    //xay dung cac phuong thuc gan gia tri cac thuoc tinh(cac setter)

    //su dung ho tro cua android studio de sinh ra

    public Book(int maSach, String tenSach, int soTrang, float giaBan, String moTa) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.soTrang = soTrang;
        this.giaBan = giaBan;
        this.moTa = moTa;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public int getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}