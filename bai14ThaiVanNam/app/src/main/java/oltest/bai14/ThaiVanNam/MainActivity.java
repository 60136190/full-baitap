package oltest.bai14.ThaiVanNam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText ipad1;
    EditText ipad2;
    EditText ipad3;
    EditText ipad4;
    EditText sm1;
    EditText sm2;
    EditText sm3;
    EditText sm4;
    Button submit;
    EditText na;
    EditText startip;
    EditText endip;
    EditText host;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ipad1 = findViewById(R.id.edta1);
        ipad2 = findViewById(R.id.edta2);
        ipad3 = findViewById(R.id.edta3);
        ipad4 = findViewById(R.id.edta4);
        sm1 = findViewById(R.id.edtb1);
        sm2 = findViewById(R.id.edtb2);
        sm3= findViewById(R.id.edtb3);
        sm4 = findViewById(R.id.edtb4);
        submit = findViewById(R.id.btnsm);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nhost,s1,s2,s3,s4;
                na= findViewById(R.id.edtnwad);
                startip = findViewById(R.id.edtstartip);
                endip = findViewById(R.id.edtendip);
                host = findViewById(R.id.edthost);
                int a1 = Integer.parseInt(ipad1.getText().toString());
                int a2 = Integer.parseInt(ipad2.getText().toString());
                int a3 = Integer.parseInt(ipad3.getText().toString());
                int a4 = Integer.parseInt(ipad4.getText().toString());
                int b1 = Integer.parseInt(sm1.getText().toString());
                int b2 = Integer.parseInt(sm2.getText().toString());
                int b3 = Integer.parseInt(sm3.getText().toString());
                int b4 = Integer.parseInt(sm4.getText().toString());
                int net1 =  a1 & b1;
                int net2 = a2 & b2;
                int net3 = a3 & b3;
                int net4 = a4 & b4;
                String netadd = net1+"."+net2+"."+net3+"."+net4;
                na.setText(String.valueOf(netadd));
                startip.setText(net1 +"."+net2+"."+net3+"."+(net4+1));

                if(b1<255)
                {
                    nhost = (int) (255-b1+1)*256*256*256-2;
                    s3 = nhost/(256*256*256);
                    endip.setText((net1+s3)+"."+"255"+".255."+"254");
                    host.setText(String.valueOf(nhost));
                }else{
                    if(b2<255)
                    {
                        nhost = (int)(255-b2+1)*256*256-2;
                        s3 = nhost/(256*256);
                        endip.setText(net1+"."+(net2+s3)+".255."+"254");
                        host.setText(String.valueOf(nhost));
                    }else{
                        if(b3 <255) {
                            nhost =  (int)(255 - b3+1) * 256-2;
                            s3 = nhost/256;
                            s4 = nhost -256 * s3;
                            endip.setText(net1+"."+net2+"."+(net3+s3)+"."+s4);
                            host.setText(String.valueOf(nhost));
                        }
                        else{
                            if(b4<255)
                            {
                                nhost =(int)(255-b4 +1)-2;
                                endip.setText(net1+"."+net2+"."+net3+"."+(net4+nhost));
                                host.setText(String.valueOf(nhost));
                            }
                            else
                            {
                                nhost =  1;
                                endip.setText(net1+"."+net2+"."+net3+"."+(net4+nhost));
                                host.setText((int) nhost);
                            }
                        }
                    }

                }





            }
        });

    }
}