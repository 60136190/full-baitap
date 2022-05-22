package oltest.bai5.ThaiVanNam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Screen2  extends AppCompatActivity {
    private Button quaylai;
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_2);
        quaylai = (Button)findViewById(R.id.btnback);

        quaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Screen2.this,MainActivity.class);

                startActivity(intent);
            }
        });


    }
}
