package oltest.bai13.ThaiVanNam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hardcode tạo dữ liệu
        List<Animal> list = new ArrayList<Animal>();
        Animal s1 = new Animal("Mèo ", R.drawable.anh2, "Meo ăn chuột",57);
        Animal s2 = new Animal("Chó", R.drawable.cho, "Chó ăn mèo",);
        Animal s3 = new Animal("Chuột", R.drawable.download, "Chuột ăn chó");
        Animal s4 = new Animal("Gấu", R.drawable.images, "Gấu ăn chuột");
        Animal s5 = new Animal("Thỏ", R.drawable.tho, "Thỏ ăn Gấu");

        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        // Tìm listview
        final ListView listView = (ListView) findViewById(R.id.lisV);
        // Bơm dữ liệu vào listview với bộ Adapter của riêng mình đã tạo
        listView.setAdapter(new MyCustomListAdapter(list, this));

        // Xử lý sụ kiện user nhấn lên một mục trên listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = listView.getItemAtPosition(position);
                Animal dongvat = (Animal) o;
                Toast.makeText(MainActivity.this, "Selected :" + " " + dongvat, Toast.LENGTH_SHORT).show();
            }
        });
    }
}