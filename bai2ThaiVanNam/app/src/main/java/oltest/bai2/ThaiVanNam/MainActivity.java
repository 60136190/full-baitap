package oltest.bai2.ThaiVanNam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button cong;
Button tru;
Button nhan;
Button chia;
EditText soa;
EditText sob;
TextView kq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         cong = findViewById(R.id.btncong);
         tru = findViewById(R.id.btntru);
         nhan = findViewById(R.id.btnnhan);
         chia = findViewById(R.id.btnchia);
         soa = findViewById(R.id.edta);
         sob = findViewById(R.id.edtb);
         kq = findViewById(R.id.tvketqua);

        cong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double a = Double.parseDouble(soa.getText().toString());
                Double b = Double.parseDouble(sob.getText().toString());
                Double c = a + b;
                kq.setText(String.valueOf(c));

            }
        });
        tru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double a = Double.parseDouble(soa.getText().toString());
                Double b = Double.parseDouble(sob.getText().toString());
                Double c = a - b;
                kq.setText(String.valueOf(c));

            }
        });
        nhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double a = Double.parseDouble(soa.getText().toString());
                Double b = Double.parseDouble(sob.getText().toString());
                Double c = a * b;
                kq.setText(String.valueOf(c));

            }
        });
        chia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double a = Double.parseDouble(soa.getText().toString());
                Double b = Double.parseDouble(sob.getText().toString());
                Double c = a / b;
                kq.setText(String.valueOf(c));

            }
        });
    }
}