package oltest.bai4.ThaiVanNam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText chieucao;
EditText cannang;
Button kiemtra;
TextView bmi;
TextView loikhuyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chieucao = findViewById(R.id.edtcc);
        cannang = findViewById(R.id.edtcn);
        kiemtra = findViewById(R.id.btnkt);
        bmi = findViewById(R.id.tvbmi);
        loikhuyen = findViewById(R.id.tvlk);

        kiemtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double H=Double.parseDouble(chieucao.getText().toString());
                double W=Double.parseDouble(cannang.getText().toString());

                double KQ= W/(H*H);
                String tam = null;
                if(KQ<18)
                {
                    tam="Bạn gầy lắm ";
                }
                if(KQ>18 && KQ<25)
                {
                    tam="Chuẩn Model";
                }
                if(KQ>25)
                {
                    tam="Mâp rồi nha";
                }
                bmi.setText(String.valueOf(KQ));
                loikhuyen.setText(String.valueOf(tam));
            }
        });
    }
}