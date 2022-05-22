package oltest.bai10.ThaiVanNam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnclick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnclick = findViewById(R.id.btnlg);

        btnclick.setOnClickListener(new View.OnClickListener() {
            int count=0;
            @Override
            public void onClick(View v) {
                EditText user = findViewById(R.id.edtun);
                EditText password = findViewById(R.id.edtpw);
                EditText attempts = findViewById(R.id.edtat);
                if((user.getText().toString().equals("maicuongtho")) && (password.getText().toString().equals("Cntt60ntu!")))
                {
                    count=0;
                    Toast.makeText(getApplicationContext(),
                            "Username and Password is Correcct!!",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),
                            "Username or Password is Wrong!!",Toast.LENGTH_LONG).show();
                    count++;
                }
                attempts.setText(String.valueOf(count));

            }
        });

    }
}