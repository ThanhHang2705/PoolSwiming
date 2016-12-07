package bacdaibang.poolswiming;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by No Bi Ta on 12/2/2016.
 */
public class Activity_SignIn extends AppCompatActivity {
    public static final String EXTRA_ID_USER = "extra.id.user";

    Button signInBtn,registBtn;
    TextView userName,passWord;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_layout);
        signInBtn =(Button)findViewById(R.id.signInBtn);
        userName = (TextView)findViewById(R.id.userName);
        passWord = (TextView)findViewById(R.id.passWord);
        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.putExtra(EXTRA_ID_USER,userName.getText());
                setResult(MainActivity.INTENT_FORRESULT_CODE,intent);
                finish();
            }
        });
        registBtn = (Button)findViewById(R.id.registerBtn);
        registBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
