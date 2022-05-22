package oltest.bai6.ThaiVanNam;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import oltest.bai5.ThaiVanNam.R;

public class Screen3 extends AppCompatActivity {
    Button back1;
    Button back2;
    TextView welcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        welcome = findViewById(R.id.txtcm);
        Intent intent2 = getIntent();
        Bundle bundle = intent2.getExtras();

        if(bundle!=null){
            String j = (String)bundle.get("key1");
            welcome.setText(j);
        }

    }
}
