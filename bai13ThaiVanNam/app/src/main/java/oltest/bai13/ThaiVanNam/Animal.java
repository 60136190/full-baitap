package oltest.bai13.ThaiVanNam;
public class Animal {
    private String tenAnimal;  // Tên Quốc gia
    private int IDanhAnimal;     // ID trong Drawable (anh)
    private String mota;
    private int cannang;
    // Dân số
    // Hàm khởi tạo

    public Animal(String tenAnimal, int IDanhAnimal, String mota , int cannang) {
        this.tenAnimal = tenAnimal;
        this.IDanhAnimal = IDanhAnimal;
        this.mota = mota;
        this.cannang = cannang;
    }


    // Các gettter, setter


    public String getTenAnimal() {
        return tenAnimal;
    }

    public void setTenAnimal(String tenAnimal) {
        this.tenAnimal = tenAnimal;
    }

    public int getIDanhAnimal() {
        return IDanhAnimal;
    }

    public void setIDanhAnimal(int IDanhAnimal) {
        this.IDanhAnimal = IDanhAnimal;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    @Override
    public String toString() {
        return  tenAnimal + " mo ta " + mota;
    }
}
