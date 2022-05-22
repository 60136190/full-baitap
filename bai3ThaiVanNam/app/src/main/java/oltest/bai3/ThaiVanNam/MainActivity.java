package oltest.bai3.ThaiVanNam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        click = findViewById(R.id.btnlg);

        click.setOnClickListener(new View.OnClickListener() {
            int count=0;
            @Override
            public void onClick(View v) {
                EditText username = findViewById(R.id.edtun);
                EditText password = findViewById(R.id.edtpw);
                TextView solansai = findViewById(R.id.tvsls);

                if((username.getText().toString().equals("maicuongtho")) && (password.getText().toString().equals("CNTT60ntu!")))
                {
                    count = 0;
                    Toast.makeText(getApplicationContext(),"Username and Password is Correcct",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(),"Username and Password is Wrong",Toast.LENGTH_LONG).show();
                    count ++;
                }
                solansai.setText(String.valueOf(count));

            }
        });

    }
}