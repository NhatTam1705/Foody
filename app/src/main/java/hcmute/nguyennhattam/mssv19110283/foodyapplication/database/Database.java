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
    public static final String DATABASE_NAME = "foody5.db";

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
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE if exists user");
    }

    public boolean checkUserName(String userName) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("Select * from user where name = ?", new String[]{userName});
        if (cursor.getCount() > 0)
            return true;
        else return false;
    }

    public boolean checkEmailAndPassword(String email, String password) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("Select * from user where email = ? and password = ?", new String[]{email, password});
        if (cursor.getCount() > 0)
            return true;
        else return false;
    }
}
