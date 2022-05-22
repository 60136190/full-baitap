package oltest.bai15.ThaiVanNam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText ipad;
    EditText sub;
    EditText net;
    EditText start;
    EditText end;
    EditText host;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ipad = findViewById(R.id.edta);
        sub = findViewById(R.id.edtb);
        net = findViewById(R.id.edtnwad);
        start = findViewById(R.id.edtstartip);
        end = findViewById(R.id.edtendip);
        host = findViewById(R.id.edthost);
        submit =findViewById(R.id.btnsm);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                net = findViewById(R.id.edtnwad);
                start = findViewById(R.id.edtstartip);
                end = findViewById(R.id.edtendip);
                host = findViewById(R.id.edthost);
                String ip = ipad.getText().toString();
                String sm = sub.getText().toString();
                String[] a1 = ip.split("\\.");
                String[]a2 = sm.split("\\.");
                int nw1= Integer.parseInt(a1[0]);
                int nw2= Integer.parseInt(a1[1]);
                int nw3= Integer.parseInt(a1[2]);
                int nw4= Integer.parseInt(a1[3]);

                int sub1 = Integer.parseInt(a2[0]);
                int sub2 = Integer.parseInt(a2[1]);
                int sub3 = Integer.parseInt(a2[2]);
                int sub4 = Integer.parseInt(a2[3]);
                int nhost,s1,s2;
                int net1 =  nw1 & sub1;
                int net2 = nw2 & sub2;
                int net3 = nw3 & sub3;
                int net4 = nw4 & sub4;
                String netadd = net1+"."+net2+"."+net3+"."+net4;
                net.setText(String.valueOf(netadd));
                start.setText(net1 +"."+net2+"."+net3+"."+(net4+1));
                if(sub1<255)
                {
                    nhost = (int) (255-sub1+1)*256*256*256-2;
                    s1 = nhost/(256*256*256);
                    end.setText((net1+s1)+"."+"255"+".255."+"254");
                    host.setText(String.valueOf(nhost));
                }else{
                    if(sub2<255)
                    {
                        nhost = (int)(255-sub2+1)*256*256-2;
                        s1 = nhost/(256*256);
                        end.setText(net1+"."+(net2+s1)+".255."+"254");
                        host.setText(String.valueOf(nhost));
                    }else{
                        if(sub3 <255) {
                            nhost =  (int)(255 - sub3+1) * 256-2;
                            s1 = nhost/256;
                            s2 = nhost -256 * s1;
                            end.setText(net1+"."+net2+"."+(net3+s1)+"."+s2);
                            host.setText(String.valueOf(nhost));
                        }
                        else{
                            if(sub4<255)
                            {
                                nhost =(int)(255-sub4 +1)-2;
                                end.setText(net1+"."+net2+"."+net3+"."+(net4+nhost));
                                host.setText(String.valueOf(nhost));
                            }
                            else
                            {
                                nhost =  1;
                                end.setText(net1+"."+net2+"."+net3+"."+(net4+nhost));
                                host.setText((int) nhost);
                            }
                        }
                    }

                }

            }
        });
    }
}