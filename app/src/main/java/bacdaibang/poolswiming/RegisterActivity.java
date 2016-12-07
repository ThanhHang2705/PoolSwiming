package bacdaibang.poolswiming;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    Button bt_dki;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        bt_dki= (Button) findViewById(R.id.btn_dki2);
        bt_dki.setOnClickListener(Click_đki);
    }

    public View.OnClickListener Click_đki = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(RegisterActivity.this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();
            Thread bamgio=new Thread(){
                public void run()
                {
                    try {
                        sleep(2000);
                    } catch (Exception e) {

                    }
                    finally
                    {
                        startActivity(new Intent(RegisterActivity.this,Activity_SignIn.class));
                        finish();
                    }
                }
            };
            bamgio.start();

        }
    };
}
