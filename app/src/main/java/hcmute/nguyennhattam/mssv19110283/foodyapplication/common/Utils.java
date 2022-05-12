/**
 * Create by: IntelliJ IDEA
 * User     : NhatTam
 * Date     : Fri, 4/29/2022
 * Time     : 10:35 PM
 * Filename : Utils
 */

package hcmute.nguyennhattam.mssv19110283.foodyapplication.common;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.widget.ImageView;

import androidx.fragment.app.FragmentActivity;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.DecimalFormat;

import com.google.gson.Gson;

import hcmute.nguyennhattam.mssv19110283.foodyapplication.signup.User;

public class Utils {
    public static String formatCurrency(float price) {
        String pattern = "###,###,###";
        return new DecimalFormat(pattern).format(price);
    }

    public static void setPreferences(User user, SharedPreferences sharedPreferences) {
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Gson gson = new Gson();
        String json = gson.toJson(user);
        editor.putString("user", json);
        editor.apply();
    }

    public static void getPreferences(SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            Gson gson = new Gson();
            String json = sharedPreferences.getString("user", "");
            Common.currentUser = gson.fromJson(json, User.class);
        }
    }

    public static byte[] convertImageViewToBytes(ImageView imageView) {
        BitmapDrawable bitmapDrawable = (BitmapDrawable) imageView.getDrawable();
        Bitmap bitmap = bitmapDrawable.getBitmap();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
