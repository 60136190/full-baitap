package oltest.bai16.ThaiVanNam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ip;
    Button xd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ip = findViewById(R.id.edtip);
        xd= findViewById(R.id.btnclass);

        xd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String adip = ip.getText().toString();
                String[] a1 = adip.split("\\.");

                int nw1= Integer.parseInt(a1[0]);


                if(nw1>=0 && nw1 <=126 ){
                    Toast.makeText(MainActivity.this,"Đây là địa chỉ IP lớp A",Toast.LENGTH_LONG).show();
                }
                if(nw1 >=128 && nw1 <=191){
                    Toast.makeText(MainActivity.this,"Đây là địa chỉ IP lớp B",Toast.LENGTH_LONG).show();
                }
                if(nw1 >=192 && nw1 <=223){
                    Toast.makeText(MainActivity.this,"Đây là địa chỉ IP lớp C",Toast.LENGTH_LONG).show();
                }
                if(nw1 >=224 && nw1 <=239){
                    Toast.makeText(MainActivity.this,"Đây là địa chỉ IP lớp D",Toast.LENGTH_LONG).show();
                }
                if(nw1 >=240 && nw1 <=255){
                    Toast.makeText(MainActivity.this,"Đây là địa chỉ IP lớp E",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}