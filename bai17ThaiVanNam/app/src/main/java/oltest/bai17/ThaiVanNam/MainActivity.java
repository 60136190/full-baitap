package oltest.bai17.ThaiVanNam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    Button doic;
    Button doif;
    EditText c;
    EditText f;
    Button clear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doic = findViewById(R.id.btnC);
        doif = findViewById(R.id.btnF);
        c = findViewById(R.id.edtC);
        f = findViewById(R.id.edtF);
        clear = findViewById(R.id.btnclear);

        doic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double A = Double.parseDouble(f.getText().toString());

                Double kq;
                kq =  (A-32)/1.8;
                c.setText(String.valueOf(kq));


            }
        });

        doif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double A = Double.parseDouble(c.getText().toString());
                Double kq;
                kq = (1.8 * A) + 32;
                f.setText(String.valueOf(kq));


            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                c.setText(String.valueOf(""));
                f.setText(String.valueOf(""));


            }
        });
    }
}