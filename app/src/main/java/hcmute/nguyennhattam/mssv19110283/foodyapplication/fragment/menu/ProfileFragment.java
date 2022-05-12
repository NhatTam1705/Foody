/**
 * Create by: IntelliJ IDEA
 * User     : NhatTam
 * Date     : Fri, 4/29/2022
 * Time     : 12:14 PM
 * Filename : ProfileFragment
 */

package hcmute.nguyennhattam.mssv19110283.foodyapplication.fragment.menu;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;

import java.io.InputStream;
import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.R;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.common.Common;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.common.Constants;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.common.Utils;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.database.IUserQuery;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.database.UserQuery;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.signup.User;

public class ProfileFragment extends Fragment {

    private TextView tvFullName, tvEmail;
    private TextInputEditText tietFullName, tietEmail, tietPhone, tietPassword, tietAddress;
    private Button btnUpdate;
    private ImageButton ibCamera, ibFileUpload;
    private CircleImageView ivProfile;
    private final IUserQuery userQuery = UserQuery.getInstance();
    View root;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_profile, container, false);

        binding();

        setInfoUser();

        btnUpdate.setOnClickListener(root -> {
            final String fullName = Objects.requireNonNull(tietFullName.getText()).toString();
            final String email = Objects.requireNonNull(tietEmail.getText()).toString();
            final String phone = Objects.requireNonNull(tietPhone.getText()).toString();
            final String address = Objects.requireNonNull(tietAddress.getText()).toString();
            final String password = Objects.requireNonNull(tietPassword.getText()).toString();
            final byte[] avatar = Utils.convertImageViewToBytes(ivProfile);
            try {
                User user = userQuery.findById(Common.currentUser.getId());
                if (!user.getName().equals(fullName) ||
                        !user.getEmail().equals(email) ||
                        !user.getPhone().equals(phone) ||
                        !user.getAddress().equals(address) ||
                        !user.getPassword().equals(password)||
                        avatar != null ||
                        user.getAvatar().length != avatar.length) {
                    updateUser(user);
                    setInfoUser();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        ibCamera.setOnClickListener(root -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, Constants.REQUEST_CODE_CAMERA);
        });

        ibFileUpload.setOnClickListener(root -> {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent, Constants.REQUEST_CODE_FOLDER);
        });

        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == Constants.REQUEST_CODE_CAMERA && resultCode == getActivity().RESULT_OK && data != null) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            ivProfile.setImageBitmap(bitmap);
        }
        if (requestCode == Constants.REQUEST_CODE_FOLDER && resultCode == getActivity().RESULT_OK && data != null) {
            Uri uri = data.getData();
            try {
                InputStream inputStream = getActivity().getContentResolver().openInputStream(uri);
                Bitmap bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeStream(inputStream),
                        ivProfile.getWidth(), ivProfile.getHeight(), true);
                ivProfile.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void binding() {
        tvFullName = root.findViewById(R.id.tv_fullname);
        tvEmail = root.findViewById(R.id.tv_email);
        tietFullName = root.findViewById(R.id.tiet_fullname);
        tietEmail = root.findViewById(R.id.tiet_email);
        tietPhone = root.findViewById(R.id.tiet_phone);
        tietPassword = root.findViewById(R.id.tiet_password);
        tietAddress = root.findViewById(R.id.tied_address);
        btnUpdate = root.findViewById(R.id.btn_update);
        ibCamera = root.findViewById(R.id.ib_camera);
        ibFileUpload = root.findViewById(R.id.ib_file_upload);
        ivProfile = root.findViewById(R.id.iv_profile);
    }

    private void setInfoUser() {
        tvFullName.setText(Common.currentUser.getName());
        tvEmail.setText(Common.currentUser.getEmail());
        tietFullName.setText(Common.currentUser.getName());
        tietEmail.setText(Common.currentUser.getEmail());
        tietPhone.setText(Common.currentUser.getPhone());
        tietPassword.setText(Common.currentUser.getPassword());
        tietAddress.setText(Common.currentUser.getAddress());
        byte[] avatar = Common.currentUser.getAvatar();
        if (avatar != null) {
            ivProfile.setImageBitmap(BitmapFactory.decodeByteArray(avatar, 0, avatar.length));
        }
    }

    private void updateUser(User user) {
        final String name = Objects.requireNonNull(tietFullName.getText()).toString();
        final String email = Objects.requireNonNull(tietEmail.getText()).toString();
        final String phone = Objects.requireNonNull(tietPhone.getText()).toString();
        final String password = Objects.requireNonNull(tietPassword.getText()).toString();
        final String address = Objects.requireNonNull(tietAddress.getText()).toString();
        final byte[] avatar = Utils.convertImageViewToBytes(ivProfile);
        if (checkEmailExisted(email) && !user.getEmail().equals(email)) {
            tietEmail.setError(getString(R.string.email_existed));
            tietEmail.requestFocus();
        } else if (checkPhoneExisted(phone) && !user.getPhone().equals(phone)) {
            tietPhone.setError(getString(R.string.phone_existed));
            tietPhone.requestFocus();
        } else {
            try {
                if (user != null) {
                    user.setName(name);
                    user.setEmail(email);
                    user.setPhone(phone);
                    user.setPassword(password);
                    user.setAddress(address);
                    user.setAvatar(avatar);
                    Integer updateUser = userQuery.updateUser(user);
                    if (updateUser > 0) {
                        Common.currentUser.setName(name);
                        Common.currentUser.setEmail(email);
                        Common.currentUser.setPhone(phone);
                        Common.currentUser.setPassword(password);
                        Common.currentUser.setAddress(address);
                        Common.currentUser.setAvatar(avatar);
                        SharedPreferences sharedPreferences = this.requireContext().getSharedPreferences(Constants.SHARED_PREFERENCE_USER_STATE, MODE_PRIVATE);
                        Utils.setPreferences(Common.currentUser, sharedPreferences);
                        Toast.makeText(this.getContext(), R.string.update_profile_successfully, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this.getContext(), R.string.update_profile_failed, Toast.LENGTH_SHORT).show();
                    }
                }
            } catch (Exception ex) {
                Toast.makeText(this.getContext(), getString(R.string.email_or_phone_existed), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean checkEmailExisted(String email) {
        User user = userQuery.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }

    private boolean checkPhoneExisted(String phone) {
        User user = userQuery.findByPhone(phone);
        if (user != null) {
            return true;
        }
        return false;
    }
}
