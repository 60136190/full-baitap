package oltest.bai8.ThaiVanNam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main2 extends AppCompatActivity {
    Button btnSave, btnNext;
    EditText edtnos, edtnoa, edtlr;
    String fileName;
    String fileName1;
    void getWidgets(){
        btnSave = findViewById(R.id.btnsave);
        btnNext = findViewById(R.id.btnnext);
        edtnos = findViewById(R.id.edtnos);
        edtnoa = findViewById(R.id.edtnoa);
        edtlr= findViewById(R.id.edtlr);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layou2);
        getWidgets();
        btnNext.setOnClickListener(Next);
        btnSave.setOnClickListener(Save);
    }

    View.OnClickListener Next = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent iNext = new Intent(Main2.this,MainActivity.class);
            startActivity(iNext);
        }
    };
    View.OnClickListener Save = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String nameSong = edtnos.getText().toString();
            String lyrc = edtlr.getText().toString();
            String nameAr = edtnoa.getText().toString();
            FileOutputStream f = null;
            try{
                f = openFileOutput(nameSong,MODE_PRIVATE);
                f.write(lyrc.getBytes());
                f.write(nameAr.getBytes());
                f.close();
                Toast.makeText(Main2.this,"Lưu thành công",Toast.LENGTH_LONG).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(Main2.this,"Lưu khônng thành công",Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(Main2.this,"Lưu không thành công",Toast.LENGTH_LONG).show();
            }
        }
    };
}

