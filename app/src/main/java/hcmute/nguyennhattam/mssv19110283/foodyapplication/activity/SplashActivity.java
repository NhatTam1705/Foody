/**
 * Create by: IntelliJ IDEA
 * User     : NhatTam
 * Date     : Sat, 4/30/2022
 * Time     : 4:31 PM
 * Filename : SplashActivity
 */

package hcmute.nguyennhattam.mssv19110283.foodyapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import hcmute.nguyennhattam.mssv19110283.foodyapplication.R;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.database.Database;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.signup.RegisterActivity;

public class SplashActivity extends AppCompatActivity {
    private TextView tvSignin;
    private Button btnRegister;

    public static Database database;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        database = new Database(this);

        bindingView();

    }

    private void bindingView() {
        tvSignin = findViewById(R.id.tv_sign_in);
        btnRegister = findViewById(R.id.btn_register);
    }

    public void buttonRegisterClick(View view) {
        startActivity(new Intent(SplashActivity.this, RegisterActivity.class));
    }

    public void textviewSigninClick(View view) {
        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
    }
}
