package bacdaibang.poolswiming;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static bacdaibang.poolswiming.R.id.txt_dangki;

/**
 * Created by Thi on 12/11/2016.
 */
public class Activity_SignIn extends AppCompatActivity implements View.OnClickListener{
    EditText userName,password;
    Button btn_dangNhap;
    TextView txt_dangKi;
    TextView txt_baoloi;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_layout);
        userName = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.passWord);
        btn_dangNhap = (Button) findViewById(R.id.signInBtn);
        txt_dangKi = (TextView) findViewById(txt_dangki);
        btn_dangNhap.setOnClickListener(this);
        txt_dangKi.setOnClickListener(this);
        txt_baoloi = (TextView) findViewById(R.id.txt_baoloi);
        txt_baoloi.setVisibility(View.INVISIBLE);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signInBtn:
                if(userName.getText().toString().equals("tuan") && password.getText().toString().equals("12345")){
                    startActivity(new Intent(Activity_SignIn.this,MainActivity.class));
                }else{
                    txt_baoloi.setVisibility(View.VISIBLE);
                }

                break;
            //
            case  R.id.txt_dangki:
                txt_baoloi.setVisibility(View.INVISIBLE);
                Thread bamgio=new Thread(){
                    public void run()
                    {
                        try {
                            sleep(2000);
                        } catch (Exception e) {

                        }
                        finally
                        {
                            startActivity(new Intent(Activity_SignIn.this,RegisterActivity.class));
                        }
                    }
                };
                bamgio.start();

                break;
        }

    }

    protected void onPause(){
        super.onPause();
        finish();
    }
}
