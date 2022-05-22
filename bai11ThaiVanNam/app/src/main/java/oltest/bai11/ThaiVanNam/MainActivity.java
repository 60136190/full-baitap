package oltest.bai11.ThaiVanNam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnclick;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnclick = findViewById(R.id.btnkq);

        btnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText kq = findViewById(R.id.edtkq);
                RadioButton rd1 = findViewById(R.id.rd1);
                RadioButton rd2 = findViewById(R.id.rd2);
                RadioButton rd3 = findViewById(R.id.rd3);


                double H = Double.parseDouble(kq.getText().toString());
                if(rd1.isChecked()){
                    double KQ = H/13;

                    Toast.makeText(getApplicationContext(),
                            "Your tips will be $ " + KQ,Toast.LENGTH_LONG).show();
                }
                if(rd2.isChecked()){
                    double KQ = H/15;
                    Toast.makeText(getApplicationContext(),
                            "Your tips will be $" + KQ,Toast.LENGTH_LONG).show();
                }
                if(rd3.isChecked()){
                    double KQ = H/18;
                    Toast.makeText(getApplicationContext(),
                            "Your tips will be $" + KQ,Toast.LENGTH_LONG).show();
                }




            }
        });



    }
}