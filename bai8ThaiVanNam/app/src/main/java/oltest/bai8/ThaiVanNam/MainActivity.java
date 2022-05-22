package oltest.bai8.ThaiVanNam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnAdd, btnShow;
    void getWidgets(){
        btnAdd = (Button) findViewById(R.id.btnadd);
        btnShow = (Button) findViewById(R.id.btnsee);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWidgets();
        btnAdd.setOnClickListener(procScrAdd);
        btnShow.setOnClickListener(procScrShow);
    }

    View.OnClickListener procScrAdd = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent iAdd = new Intent(MainActivity.this,Main2.class);
            startActivity(iAdd);
        }
    };
    View.OnClickListener procScrShow = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent iShow = new Intent(MainActivity.this,Main3.class);
            startActivity(iShow);
        }
    };
}