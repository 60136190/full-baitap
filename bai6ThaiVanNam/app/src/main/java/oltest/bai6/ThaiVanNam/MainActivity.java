package oltest.bai6.ThaiVanNam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import oltest.bai5.ThaiVanNam.R;
import oltest.bai6.ThaiVanNam.Screen;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button login = findViewById(R.id.btnclick);
        login.setOnClickListener(xuly);
    }
    View.OnClickListener xuly = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent1 = new Intent(MainActivity.this, Screen.class);
            startActivity(intent1);
        }
    };
}