package oltest.bai9.ThaiVanNam;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> dsSach;
    ArrayAdapter<String> boNap;
    ListView listV;
    int vitri=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bookDBCreate4FisrtTime();
//        addNewBook(2, "Lap trinh Java", 90, 27000,"Sach Java viet boi MC");
        // Hiện listview
        dsSach = getAllNameBook();
        boNap = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                dsSach
        );
        ListView lv = (ListView) findViewById(R.id.lvTenSach);
        lv.setAdapter(boNap);

        Button butThem = (Button) findViewById(R.id.btnThem);

        butThem.setOnClickListener(XLThemSach);
        lv.setAdapter(boNap);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                vitri=i;
                Toast.makeText(MainActivity.this,dsSach.get(vitri),Toast.LENGTH_SHORT).show();
            }
        });
    }

    View.OnClickListener XLThemSach = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            EditText maSach=(EditText)findViewById(R.id.editMaSach);
            EditText tenSach=(EditText)findViewById(R.id.editTen);
            EditText Gia=(EditText)findViewById(R.id.editGia);
            EditText moTa=(EditText)findViewById(R.id.editMoTa);
            EditText soTrang=(EditText)findViewById(R.id.editSoTrang);
            int maS=Integer.parseInt(maSach.getText().toString());
            String tenS=tenSach.getText().toString();
            float gia=Integer.parseInt(Gia.getText().toString());
            String mota=moTa.getText().toString();
            int sotrang=Integer.parseInt(soTrang.getText().toString());

            try {
                Book s = new Book(maS, tenS, sotrang, gia,mota);
                addNewBook(s);

            }catch (Exception ex)
            {
                Toast.makeText(MainActivity.this, "Trùng khóa rồi", Toast.LENGTH_LONG).show();
            }
            boNap.notifyDataSetChanged();

        }
    };

    void bookDBCreate4FisrtTime() {
        String sqlCreateTable ="CREATE TABLE IF NOT EXISTS BOOKS( MaSach integer PRIMARY KEY, " +
                "TenSach text," +
                "SoTrang integer," +
                "GiaBan Float," +
                "Mota text);";
        SQLiteDatabase db = openOrCreateDatabase("CSDLsach.db", MODE_PRIVATE,null);
        db.execSQL(sqlCreateTable);
        db.close();
    }
    // Ham them moi mot quyen sach
    //vd: addNewBook(1, "Lap trinh Android", 80, 20000,"Sach danh rieng cho lop MMT")
    void addNewBook(int maso, String tenSach, int soTrang, float giaBan, String mota)
    {
        SQLiteDatabase db = openOrCreateDatabase("CSDLsach.db", MODE_PRIVATE,null);
        String sqlThem="INSERT INTO BOOKS VALUES("
                + maso + ","
                + " ' " + tenSach + " ',"    // 'Sach gi do'
                + soTrang+ ","
                + giaBan+","
                + " ' " + mota +" ')";      // 'Mo ta o day'
        // "INSERT INTO BOOKS VALUES(3, 'Học làm giàu', 120, 0.99, 'sách đọc cho vui');
        db.execSQL(sqlThem);
        db.close();
    }
    // Ví dụ sử dụng
    //  Book s = new Book(1,"Lap trinh Androi",80,20000,"Day la sach cua toi");
    // addNewBook(s)
    void  addNewBook(Book sach)
    {
        SQLiteDatabase db = openOrCreateDatabase("CSDLsach.db", MODE_PRIVATE,null);
        String sqlThem="INSERT INTO BOOKS VALUES("
                + sach.getMaSach() + ","
                + " ' " + sach.getTenSach() + " ',"    // 'Sach gi do'
                + sach.getSoTrang()+ ","
                + sach.getGiaBan()+","
                + " ' " + sach.getMoTa() +" ')";      // 'Mo ta o day'
        // "INSERT INTO BOOKS VALUES(3, 'Học làm giàu', 120, 0.99, 'sách đọc cho vui');

        db.execSQL(sqlThem);

        db.close();

    }
    // Lấy danh sách các sách, cái này đưa vào Custom Listview
    ArrayList<Book> getAllBook()
    {
        //Mở
        SQLiteDatabase db = openOrCreateDatabase("CSDLsach.db", MODE_PRIVATE,null);
        // Thực thi truy vấn
        String sqlChonHet ="SELECT * FROM BOOKS";
        Cursor dataSet = db.rawQuery(sqlChonHet, null);

        // Xử lý kết quả lấy được, đưa vào sanh sách sách
        ArrayList<Book> dsTam = new ArrayList<Book>();
        // duyệt dataset, để thêm vào dsTam
        while (true)
        {
            // Lấy cac thong tin sach
            int ms = dataSet.getInt(0);   // Lay du lieu o cot 0
            String ten = dataSet.getString(1);   // Lay du lieu o cot 0
            int trang = dataSet.getInt(2);   // Lay du lieu o cot 0
            float gia = dataSet.getFloat(3);   // Lay du lieu o cot 0
            String mota =dataSet.getString(4);
            // Gói lại
            Book b = new Book(ms, ten,trang, gia,mota);
            // Thêm vào danh sách
            dsTam.add(b);
            // chuyển đến bản ghi tiếp
            if (dataSet.moveToNext()==false) break;
        }
        //   dataSet.close();
        db.close();
        return  dsTam;  // trả về ds qua tên hàm
    }
    // Hàm này chi lấy mỗi danh sách các tên sách (phục vụ ví dụ đơn giản trên lớp, để đưa vào listview đơn giản)
    ArrayList<String> getAllNameBook() {
        //Mở
        SQLiteDatabase db = openOrCreateDatabase("CSDLsach.db", MODE_PRIVATE, null);
        // Thực thi truy vấn
        String sqlChonHet = "SELECT * FROM BOOKS";
        Cursor dataSet = db.rawQuery(sqlChonHet, null);

        // Xử lý kết quả lấy được, đưa vào sanh sách sách
        ArrayList<String> dsTen = new ArrayList<String>();
        // duyệt dataset, để thêm vào dsTam
        if (dataSet.moveToFirst()) {
            while (true) {
                // Lấy cac thong tin sach
                String ma = dataSet.getString(0);   // Lay du lieu o cot 0
                String ten = dataSet.getString(1);   // Lay du lieu o cot 0
                dsTen.add(ma+ten);
                // chuyển đến bản ghi tiếp
                if (dataSet.moveToNext() == false) break;
            }

        }
        // Đóng
        // dataSet.close();
        db.close();
        return dsTen;  // trả về ds qua tên hàm
    }
}