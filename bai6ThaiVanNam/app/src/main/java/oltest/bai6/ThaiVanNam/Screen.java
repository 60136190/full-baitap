package oltest.bai6.ThaiVanNam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import oltest.bai5.ThaiVanNam.R;

public class Screen  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen);

        Button xacnhan = findViewById(R.id.btnxn);
        xacnhan.setOnClickListener(xuly1);
    }

    View.OnClickListener xuly1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText edt1 = findViewById(R.id.edtun);
            EditText edt2 = findViewById(R.id.edtpw);
            EditText edt3 = findViewById(R.id.edtem);

            String s1 =edt1.getText().toString();
            String s2 = edt2.getText().toString();
            String s3 = edt3.getText().toString();

            if(s1.equals("thainam") && s2.equals("123")&& s3.equals("thaivannam123")){
                Intent intent1 = new Intent(Screen.this, Screen3.class);
                intent1.putExtra("key1",s1);
                intent1.putExtra("key2",s2);
                intent1.putExtra("key3",s3);

                startActivity(intent1);
            }else{
                Toast.makeText(getApplicationContext(),
                        "Username and Password is Wrong",Toast.LENGTH_LONG).show();
            }

        }
    };
}