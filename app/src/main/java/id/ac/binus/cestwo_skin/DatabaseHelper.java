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
                "name text PRIMARY KEY," +
                "email text," +
                "password text)");

        sqLiteDatabase.execSQL("CREATE TABLE orderItem("+
                "itemName text PRIMARY KEY," +
                "itemPrice text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean isInsertUser(String name, String email, String password){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues content= new ContentValues();
        content.put("name", name);
        content.put("email", email);
        content.put("password", password);

        long result =db.insert("user", null, content);
        if(result == -1){
            return false;
        }
        return true;
    }

    public boolean isInsertOrder(String itemName, String itemPrice){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("itemName", itemName);
        content.put("itemPrice", itemPrice);

        long result = db.insert("orderItem", null, content);
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

    public boolean updateData(String name, String password, String email){
        SQLiteDatabase db =this.getWritableDatabase();

        ContentValues contentValues =new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("password", password);

        Cursor cursor =db.rawQuery("SELECT * FROM user where name = ?", new String[]{name});
        if(cursor.getCount() > 0){
            long result = db.update("user", contentValues, "name = ?", new String[] {name});
            if(result <= 0)
                return false;
            else
                return true;
        }
        return false;
    }

    public boolean deleteData(String name){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor =db.rawQuery("SELECT * FROM user where name = ?", new String[]{name});
        if(cursor.getCount() > 0){
            long result = db.delete("user", "name = ?", new String[]{name});
            return result > 0;
        }
        return false;
    }
}
