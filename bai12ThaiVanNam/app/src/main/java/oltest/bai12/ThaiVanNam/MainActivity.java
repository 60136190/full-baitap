package oltest.bai12.ThaiVanNam;

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
    ArrayList<String> ds;
    Button them;
    Button sua;
    Button xoa;
    EditText dl;
    EditText it;
    EditText gt;

    ListView lvds;
    int vitri=-1;

    void Timwidget(){
        them = findViewById(R.id.btnluu);
        sua = findViewById(R.id.btnsua);
        xoa = findViewById(R.id.btnxoa);
        dl = findViewById(R.id.edtdl);
        lvds = findViewById(R.id.lvds);
        it = findViewById(R.id.edtitem);
        gt = findViewById(R.id.edtgt);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Timwidget();
        ds = new ArrayList<String>();
        ArrayAdapter<String> boNap = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                ds
        );
        lvds.setAdapter(boNap);


        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String danhsach = dl.getText().toString();
                ds.add(danhsach);
                boNap.notifyDataSetChanged();


            }
        });
        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String danhsach = dl.getText().toString();
                ds.remove(danhsach);
                boNap.notifyDataSetChanged();
            }
        });
        lvds.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                dl.setText(ds.get(i));
                vitri = i;
                it.setText(String.valueOf(i++));
                String d1 = dl.getText().toString();
                gt.setText(String.valueOf(d1));
            }
        });
        sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ds.set(vitri,dl.getText().toString());
                boNap.notifyDataSetChanged();
            }
        });

    }
}