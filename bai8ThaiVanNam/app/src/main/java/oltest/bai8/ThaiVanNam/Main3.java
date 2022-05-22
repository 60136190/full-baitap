package oltest.bai8.ThaiVanNam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main3 extends AppCompatActivity {
    Button btnSLyrc , btnNextA;
    EditText edtSNSong,edtSLyrc,edtNoa1;
    void getWidgets (){
        btnSLyrc = findViewById(R.id.btnshow);
        btnNextA = findViewById(R.id.btnback);
        edtSNSong = findViewById(R.id.edtnos1);
        edtSLyrc = findViewById(R.id.edtlr1);
        edtNoa1 = findViewById(R.id.edtnos1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout3);
        getWidgets();
        btnNextA.setOnClickListener(procToAdd);
        btnSLyrc.setOnClickListener(procShowLyrc);

    }

    View.OnClickListener procToAdd = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent iNextAdd = new Intent(Main3.this,MainActivity.class);
            startActivity(iNextAdd);
        }
    };
    View.OnClickListener procShowLyrc =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String nameSong = edtSNSong.getText().toString();

            FileInputStream f = null;
            try{
                f = openFileInput(nameSong);
                byte arrByte[] = new byte[2048];
                String contnt = "";
                int numOfByte = f.read(arrByte);
                contnt = new String(arrByte);
                edtSLyrc.setText(contnt);
                edtNoa1.setText(contnt);
                Toast.makeText(Main3.this,"Đọc hoàn tất",Toast.LENGTH_LONG).show();
                f.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(Main3.this,"Đọc hoàn không tất",Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(Main3.this,"Đọc không hoàn tất",Toast.LENGTH_LONG).show();
            }
        }
    };
}
