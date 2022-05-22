package oltest.bai19.ThaiVanNam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    EditText a;
    EditText b;
    TextView c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btncong);
        btn2 = findViewById(R.id.btntru);
        btn3 = findViewById(R.id.btnnhan);
        btn4 = findViewById(R.id.btnchia);
        btn5 = findViewById(R.id.btnuoc);
        a = findViewById(R.id.edta);
        b = findViewById(R.id.edtb);
        c = findViewById(R.id.tvkq);
        btn6 = findViewById(R.id.btnthoat);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double A = Double.parseDouble(a.getText().toString());
                double B = Double.parseDouble(b.getText().toString());
                double kq;
                kq = A + B;
                c.setText(String.valueOf(kq));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double A = Double.parseDouble(a.getText().toString());
                double B = Double.parseDouble(b.getText().toString());
                double kq;
                kq = A - B;
                c.setText(String.valueOf(kq));
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double A = Double.parseDouble(a.getText().toString());
                double B = Double.parseDouble(b.getText().toString());
                double kq;
                kq = A * B;
                c.setText(String.valueOf(kq));
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double A = Double.parseDouble(a.getText().toString());
                double B = Double.parseDouble(b.getText().toString());
                double kq;
                kq = A / B;
                c.setText(String.valueOf(kq));
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double A = Double.parseDouble(a.getText().toString());
                double B = Double.parseDouble(b.getText().toString());
                double kq;

                int gcd = 1;
                for(int i = 1; i <= A && i <= B; i++)
                {
                    if(A%i==0 && B%i==0)
                        gcd = i;
                }
                kq = gcd;
                c.setText(String.valueOf(kq));
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();
            }
        });

    }
}