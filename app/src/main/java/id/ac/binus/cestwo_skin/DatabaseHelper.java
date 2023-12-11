package id.ac.binus.cestwo_skin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context){
        super(context, "pengguna", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE user("+
                "username text PRIMARY KEY," +
                "name text," +
                "password text," +
                "age text," +
                "email text," +
                "phone text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean isInsertUser(String username, String name, String password, String age, String email, String phone){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues content= new ContentValues();
        content.put("username", username);
        content.put("name", name);
        content.put("password", password);
        content.put("age", age);
        content.put("email", email);
        content.put("phone", phone);

        long result =db.insert("user", null, content);
        if(result == -1){
            return false;
        }
        return true;
    }

    public Cursor getPengguna(){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM user", null);
        return cursor;
    }

    public boolean updateData(String username, String name, String password, String age, String email, String phone){
        SQLiteDatabase db =this.getWritableDatabase();

        ContentValues contentValues =new ContentValues();
        contentValues.put("username", username);
        contentValues.put("name", name);
        contentValues.put("password", password);
        contentValues.put("age", age);
        contentValues.put("email", email);
        contentValues.put("phone", phone);

        Cursor cursor =db.rawQuery("SELECT * FROM user where username = ?", new String[]{username});
        if(cursor.getCount() > 0){
            long result =db.update("user", contentValues, "username = ?", new String[] {username});
            if(result <= 0)
                return false;
            else
                return true;
        }
        return false;
    }

    public boolean deleteData(String username, String name, String password, String age, String email, String phone){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor =db.rawQuery("SELECT * FROM user where username = ?", new String[]{username});
        if(cursor.getCount() > 0){
            long result = db.delete("user", "username = ?", new String[]{username});
            return result > 0;
        }
        return false;
    }
}
