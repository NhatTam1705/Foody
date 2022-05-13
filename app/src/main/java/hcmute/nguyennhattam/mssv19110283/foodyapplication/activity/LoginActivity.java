/**
 * Create by: IntelliJ IDEA
 * User     : NhatTam
 * Date     : Sun, 5/1/2022
 * Time     : 11:50 AM
 * Filename : LoginActivity
 */

package hcmute.nguyennhattam.mssv19110283.foodyapplication.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import hcmute.nguyennhattam.mssv19110283.foodyapplication.R;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.common.Common;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.common.Constants;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.common.Utils;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.database.Database;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.database.IUserQuery;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.database.UserQuery;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.signup.RegisterActivity;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.signup.User;

public class LoginActivity extends AppCompatActivity {
    private EditText edtEmail, edtPassword;
    private ImageButton ibShowPass, ibHidePass;
    private CheckBox cbRemember;
    private final IUserQuery userQuery = UserQuery.getInstance();
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        bindingView();

        sharedPreferences = getSharedPreferences(Constants.DATA_LOGIN, MODE_PRIVATE);

        edtEmail.setText(sharedPreferences.getString("email", ""));
        edtPassword.setText(sharedPreferences.getString("password", ""));
        cbRemember.setChecked(sharedPreferences.getBoolean("checked", false));

    }

    public void buttonSignInClick(View view) {
        final String email, password;
        email = Objects.requireNonNull(edtEmail.getText()).toString();
        password = Objects.requireNonNull(edtPassword.getText()).toString();

        if (email.isEmpty()) {
            edtEmail.setError(getString(R.string.enter_email));
            edtEmail.requestFocus();
        } else if (!isValidEmail(email)) {
            edtEmail.setError(getString(R.string.email_invalidate));
            edtEmail.requestFocus();
        } else if (password.isEmpty()) {
            edtPassword.setError(getString(R.string.enter_password));
            edtPassword.requestFocus();
        } else {
            User user = userQuery.findByUserEmailAndPassword(email, password);
            if (email.equals("admin@gmail.com")) {
                Toast.makeText(LoginActivity.this, getString(R.string.login_successfully), Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("email");
                editor.remove("password");
                editor.remove("checked");
                editor.commit();
                Intent intent = new Intent(LoginActivity.this, ManageActivity.class);
                Common.currentUser = user;
                startActivity(intent);
                SharedPreferences sharedPreferences = getSharedPreferences(Constants.SHARED_PREFERENCE_USER_STATE, MODE_PRIVATE);
                Utils.setPreferences(Common.currentUser, sharedPreferences);
                finish();
            } else {
                try {
                    if (user != null) {
                        Toast.makeText(LoginActivity.this, getString(R.string.login_successfully), Toast.LENGTH_SHORT).show();
                        if (cbRemember.isChecked()) {
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("email", email);
                            editor.putString("password", password);
                            editor.putBoolean("checked", true);
                            editor.commit();
                        } else {
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.remove("email");
                            editor.remove("password");
                            editor.remove("checked");
                            editor.commit();
                        }
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        Common.currentUser = user;
                        startActivity(intent);
                        SharedPreferences sharedPreferences = getSharedPreferences(Constants.SHARED_PREFERENCE_USER_STATE, MODE_PRIVATE);
                        Utils.setPreferences(Common.currentUser, sharedPreferences);
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, getString(R.string.email_or_password_incorrect), Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception ex) {
                    Toast.makeText(LoginActivity.this, getString(R.string.server_error, ex.getMessage()), Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences userPreferences = getSharedPreferences(Constants.SHARED_PREFERENCE_USER_STATE, MODE_PRIVATE);
        Utils.getPreferences(userPreferences);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void bindingView() {
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        ibShowPass = findViewById(R.id.ib_show_pass);
        ibHidePass = findViewById(R.id.ib_hide_pass);
        cbRemember = findViewById(R.id.cb_remember);
    }


    private boolean isValidEmail(String email) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public void textviewRegisterClick(View view) {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }

    public void imagebuttonBackClick(View view) {
        startActivity(new Intent(LoginActivity.this, SplashActivity.class));
    }

    public void imagebuttonShowPassClick(View view) {
        edtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        ibShowPass.setVisibility(view.INVISIBLE);
        ibHidePass.setVisibility(view.VISIBLE);
    }

    public void imagebuttonHidePassClick(View view) {
        edtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
        ibShowPass.setVisibility(view.VISIBLE);
        ibHidePass.setVisibility(view.INVISIBLE);
    }
}

