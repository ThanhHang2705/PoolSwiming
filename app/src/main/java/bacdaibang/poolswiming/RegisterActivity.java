package bacdaibang.poolswiming;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    TextView txt_name1, txt_pass1, txt_pass2;
    EditText edt_namedk , edt_passdk1, edt_passdk2;
    Button bt_dki;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        txt_name1 = (TextView) findViewById(R.id.txt_name1);
        txt_pass1 = (TextView) findViewById(R.id.txt_pass1);
        txt_pass2= (TextView) findViewById(R.id.txt_pass2);
        edt_namedk = (EditText) findViewById(R.id.edt_namedk);
        edt_passdk1 = (EditText) findViewById(R.id.edt_pass_dk1);
        edt_passdk2 = (EditText) findViewById(R.id.edt_pass2);

        bt_dki= (Button) findViewById(R.id.btn_dki2);
        bt_dki.setOnClickListener(CLickDki);
    }


    public View.OnClickListener CLickDki = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            Toast.makeText(RegisterActivity.this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();

            Thread bamgio = new Thread() {
                public void run() {
                    try {
                        sleep(2000);
                    } catch (Exception e) {

                    } finally {
                        String name = edt_namedk.getText().toString();
                        String pass1 = edt_passdk1.getText().toString();

                        Intent intent =new Intent(RegisterActivity.this, Activity_SignIn.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("1",name);
                        bundle.putString("2",pass1);
                        intent.putExtra("taikhoan",bundle);
                        startActivity(intent);
                        finish();
                    }
                }
            };
            bamgio.start();


        }

    };
}
