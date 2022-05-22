package oltest.bai1thaivannam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView hienthi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button touch =findViewById(R.id.btnt);
        hienthi = findViewById(R.id.edthienthi);

        touch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hienthi.setText(String.valueOf("Thái Văn Nam"));
            }
        });

    }
}