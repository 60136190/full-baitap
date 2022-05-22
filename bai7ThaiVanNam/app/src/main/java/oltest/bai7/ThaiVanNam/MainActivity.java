package oltest.bai7.ThaiVanNam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> dsquocgia;
    Button them;
    Button xoa;
    Button sua;
    EditText tenqg;
    ListView lvdsqg;
    int vitri=-1;
    void TimWidget() // tìm tham chiếu đến các điều khiển trên layoutXML
    {
        them = (Button)findViewById(R.id.btnthem);
        xoa = (Button)findViewById(R.id.btnxoa);
        sua=(Button)findViewById(R.id.btnsua);
        tenqg = (EditText)findViewById(R.id.edt1);
        lvdsqg= (ListView)findViewById(R.id.lvds);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimWidget();// Để lập trình thao tác với nó sau
        // khởi tạo nguồn dữ liệu rỗng cho Listvew
        dsquocgia = new ArrayList<String>();
        ArrayAdapter<String> boNap = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                dsquocgia
        );
        //nap len
        lvdsqg.setAdapter(boNap);


        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String quocgia = tenqg.getText().toString();
                dsquocgia.add(quocgia);
                boNap.notifyDataSetChanged();
            }
        });
        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String quocgia = tenqg.getText().toString();
                dsquocgia.remove(quocgia);
                boNap.notifyDataSetChanged();
            }
        });



        lvdsqg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                tenqg.setText(dsquocgia.get(i));
                vitri = i;
            }
        });
        sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dsquocgia.set(vitri,tenqg.getText().toString());
                boNap.notifyDataSetChanged();
            }
        });


    }
}