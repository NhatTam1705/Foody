/**
 * Create by: IntelliJ IDEA
 * User     : NhatTam
 * Date     : Fri, 5/13/2022
 * Time     : 11:51 AM
 * Filename : AddRestaurantActivity
 */

package hcmute.nguyennhattam.mssv19110283.foodyapplication.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.io.InputStream;
import java.util.Objects;

import hcmute.nguyennhattam.mssv19110283.foodyapplication.R;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.common.Common;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.common.Constants;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.common.Utils;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.database.FoodQuery;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.database.IFoodQuery;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.database.IRestaurantQuery;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.database.IUserQuery;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.database.RestaurantQuery;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.database.UserQuery;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.domain.Restaurant;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.fragment.manage.ManageFoodFragment;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.fragment.menu.HomeFragment;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.fragment.menu.RestaurantFragment;

public class AddRestaurantActivity extends AppCompatActivity {

    private Button btnSave;
    private ImageButton ibFileUpload;
    private ImageView ivRestaurant;
    private TextInputEditText tietRestaurantName, tietPhone, tietAddress;
    private final IRestaurantQuery restaurantQuery = RestaurantQuery.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_restaurant);

        binding();

        ibFileUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, Constants.REQUEST_CODE_FOLDER);
            }

        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String name = Objects.requireNonNull(tietRestaurantName.getText()).toString();
                final String phone = Objects.requireNonNull(tietPhone.getText()).toString();
                final String address = Objects.requireNonNull(tietAddress.getText()).toString();
                final byte[] imageRestaurant = Utils.convertImageViewToBytes(ivRestaurant);

                if (name.isEmpty() || phone.isEmpty() || address.isEmpty() || imageRestaurant == null) {
                    Toast.makeText(AddRestaurantActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    Restaurant restaurant = new Restaurant();
                    restaurant.setName(name);
                    restaurant.setPhone(phone);
                    restaurant.setAddress(address);
                    restaurant.setImagerestaurant(imageRestaurant);

                    Long insertRestaurant = restaurantQuery.insert(restaurant);

                    if (insertRestaurant != null) {
                        Toast.makeText(AddRestaurantActivity.this, "Add restaurant successfully", Toast.LENGTH_SHORT).show();
                        finish();
//                        Intent intent = new Intent(AddRestaurantActivity.this, ManageFoodFragment.class);
//                        startActivity(intent);
                    } else {
                        Toast.makeText(AddRestaurantActivity.this, "Add restaurant failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == Constants.REQUEST_CODE_FOLDER && resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeStream(inputStream),
                        ivRestaurant.getWidth(), ivRestaurant.getHeight(), true);
                ivRestaurant.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        super.onActivityResult(requestCode, resultCode, data);;
    }

    private void binding() {
        btnSave = findViewById(R.id.btn_save);
        ibFileUpload = findViewById(R.id.ib_file_upload);
        ivRestaurant = findViewById(R.id.iv_image_restaurant);
        tietRestaurantName = findViewById(R.id.tiet_name_restaurant);
        tietPhone = findViewById(R.id.tiet_phone);
        tietAddress = findViewById(R.id.tiet_address);
    }


}
