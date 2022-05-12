/**
 * Create by: IntelliJ IDEA
 * User     : NhatTam
 * Date     : Sat, 4/30/2022
 * Time     : 4:25 PM
 * Filename : RegisterActivity
 */

package hcmute.nguyennhattam.mssv19110283.foodyapplication.signup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import hcmute.nguyennhattam.mssv19110283.foodyapplication.R;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.activity.LoginActivity;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.activity.SplashActivity;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.common.Constants;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.database.IUserQuery;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.database.UserQuery;

public class RegisterActivity extends AppCompatActivity {
    private EditText edtName, edtEmail, edtPassword, edtConfirmPassword;
    private ImageButton ibShowPass, ibHidePass, ibShowConfirmPass, ibHideConfirmPass;
    private final IUserQuery userQuery = UserQuery.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register);

        bindingView();

    }

    public void buttonRegisterClick(View view) {
        final String name, email, password, confirmPassword;
        name = Objects.requireNonNull(edtName.getText()).toString();
        email = Objects.requireNonNull(edtEmail.getText()).toString();
        password = Objects.requireNonNull(edtPassword.getText()).toString();
        confirmPassword = Objects.requireNonNull(edtConfirmPassword.getText()).toString();

        if (name.isEmpty()) {
            edtName.setError(getString(R.string.enter_name));
            edtName.requestFocus();
        } else if (email.isEmpty()) {
            edtEmail.setError(getString(R.string.enter_email));
            edtEmail.requestFocus();
        } else if (!isValidEmail(email)) {
            edtEmail.setError(getString(R.string.email_invalidate));
            edtEmail.requestFocus();
        } else if (checkEmailExisted(email)) {
            edtEmail.setError(getString(R.string.email_existed));
            edtEmail.requestFocus();
        } else if (password.isEmpty()) {
            edtPassword.setError(getString(R.string.enter_password));
            edtPassword.requestFocus();
        } else if (confirmPassword.isEmpty()) {
            edtConfirmPassword.setError(getString(R.string.enter_confirm_password));
            edtConfirmPassword.requestFocus();
        } else if (!password.equals(confirmPassword)) {
            edtConfirmPassword.setError(getString(R.string.password_mismatch));
            edtConfirmPassword.requestFocus();
        } else {
            try {
                SharedPreferences sharedPreferences = getSharedPreferences(Constants.DATA_LOGIN, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("email", email);
                editor.putString("password", password);
                editor.putBoolean("checked", true);
                editor.commit();
                User user = new User(null, name, email, "", password,"", null);
                userQuery.insert(user);
                Toast.makeText(RegisterActivity.this, getString(R.string.sign_up_successfully), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
            } catch (Exception ex) {
                Toast.makeText(RegisterActivity.this, getString(R.string.sign_up_failed, ex.getMessage()), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void bindingView() {
        edtName = findViewById(R.id.edt_name);
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        edtConfirmPassword = findViewById(R.id.edt_confirm_password);
        ibShowPass = findViewById(R.id.ib_show_pass);
        ibHidePass = findViewById(R.id.ib_hide_pass);
        ibShowConfirmPass = findViewById(R.id.ib_show_confirm_pass);
        ibHideConfirmPass = findViewById(R.id.ib_hide_confirm_pass);
    }

    private boolean isValidEmail(String email) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public void textviewSignInClick(View view) {
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
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

    public void imagebuttonShowConfirmPassClick(View view) {
        edtConfirmPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        ibShowConfirmPass.setVisibility(view.INVISIBLE);
        ibHideConfirmPass.setVisibility(view.VISIBLE);
    }

    public void imagebuttonHideConfirmPassClick(View view) {
        edtConfirmPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
        ibShowConfirmPass.setVisibility(view.VISIBLE);
        ibHideConfirmPass.setVisibility(view.INVISIBLE);
    }

    public void imagebuttonBackClick(View view) {
        startActivity(new Intent(RegisterActivity.this, SplashActivity.class));
    }

    private boolean checkEmailExisted(String email) {
        User user = userQuery.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }
}
