package oltest.bai18.ThaiVanNam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ip;
    EditText sub;
    EditText dcm;
    EditText dcqb;
    EditText slip;
    Button tinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ip = findViewById(R.id.edtip);
        sub = findViewById(R.id.edtn);
        dcm = findViewById(R.id.edtdcm);
        dcqb = findViewById(R.id.edtdcqb);
        slip = findViewById(R.id.edtslip);
        tinh = findViewById(R.id.btntinh);

        tinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x, y, A;
                String dcip = ip.getText().toString();
                String[] a1 = dcip.split("\\.");
                int nw1 = Integer.parseInt(a1[0]);
                int nw2 = Integer.parseInt(a1[1]);
                int nw3 = Integer.parseInt(a1[2]);
                int nw4 = Integer.parseInt(a1[3]);
                int n = Integer.parseInt(sub.getText().toString());



                if (n <= 8) {
                    y = (int) Math.pow(2, 8 - n);
                    x = 266 - y;
                    A = y * 256 * 256 * 256-2;
                    slip.setText(String.valueOf(A));
                    int s1  = nw1 & x;
                    int s2  = nw2 & 0;
                    int s3  = nw3 & 0;
                    int s4  = nw4 & 0;
                    String netadd = s1 +"."+s2+"."+s3+"."+s4;
                    dcqb.setText((s1+y)+"."+"255"+".255."+"255");
                    dcm.setText(String.valueOf(netadd));


                } else {
                    if (n <= 16) {
                        y = (int) Math.pow(2, 16 - n);
                        x = 266 - y;
                        A = y * 256 * 256-2;
                        slip.setText(String.valueOf(A));
                        int s1  = nw1 ;
                        int s2  = nw2 & x;
                        int s3  = nw3 & 0;
                        int s4  = nw4 & 0;
                        String netadd = s1 +"."+s2+"."+s3+"."+s4;
                        dcqb.setText((s1)+"."+(s2+y)+".255."+"255");
                        dcm.setText(String.valueOf(netadd));
                    } else {
                        if (n <= 24) {
                            y = (int) Math.pow(2, 24 - n);
                            x = 266 - y;
                            A = y * 256-2;
                            slip.setText(String.valueOf(A));
                            int s1  = nw1 ;
                            int s2  = nw2 ;
                            int s3  = nw3 & x;
                            int s4  = nw4 & 0;
                            String netadd = s1 +"."+s2+"."+s3+"."+s4;
                            dcqb.setText((s1)+"."+(s2)+(s3+y)+"."+"255");
                            dcm.setText(String.valueOf(netadd));
                        } else {
                            if (n > 32) {
                                Toast.makeText(getApplicationContext(), "Số Subnet Sai rồi!!!", Toast.LENGTH_LONG).show();
                            } else {
                                y = (int) Math.pow(2, 32 - n);
                                x = 266 - y;
                                A = y -2;
                                slip.setText(String.valueOf(A));
                                int s1  = nw1 ;
                                int s2  = nw2 ;
                                int s3  = nw3 ;
                                int s4  = nw4 & x;
                                String netadd = s1 +"."+s2+"."+s3+"."+s4;
                                dcqb.setText((s1)+"."+(s2)+s3+"."+(s4+y+1));
                                dcm.setText(String.valueOf(netadd));

                            }
                        }


                    }
                }
            }
        });

    }
}
