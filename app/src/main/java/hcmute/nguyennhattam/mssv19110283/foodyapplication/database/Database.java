/**
 * Create by: IntelliJ IDEA
 * User     : NhatTam
 * Date     : Fri, 4/29/2022
 * Time     : 1:11 PM
 * Filename : Database
 */

package hcmute.nguyennhattam.mssv19110283.foodyapplication.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class Database extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "foody6.db";

    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public void queryData(String sql) {
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public Cursor getData(String sql) {
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table if not exists user (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name varchar(255)," +
                "email varchar(255) unique," +
                "phone varchar(10) ," +
                "password varchar(20)," +
                "address varchar(255)," +
                "avatar blob)");

        sqLiteDatabase.execSQL("create table if not exists restaurant (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name varchar(255)," +
                "phone varchar(10) ," +
                "address varchar(255)," +
                "imagerestaurant blob)");

        sqLiteDatabase.execSQL("create table if not exists food (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name varchar(255)," +
                "description varchar(255)," +
                "price varchar(255)," +
                "restaurant INTEGER," +
                "type varchar(255)," +
                "imagefood blob)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE if exists user");
        sqLiteDatabase.execSQL("DROP TABLE if exists restaurant");
        sqLiteDatabase.execSQL("DROP TABLE if exists food");
    }
}
