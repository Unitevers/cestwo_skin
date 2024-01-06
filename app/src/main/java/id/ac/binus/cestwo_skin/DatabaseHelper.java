package id.ac.binus.cestwo_skin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context){
        super(context, "cestwo", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE user (" +
                "email text PRIMARY KEY," +
                "name text," +
                "password text)");

        db.execSQL("CREATE TABLE orders (" +
                "orderid integer PRIMARY KEY AUTOINCREMENT," +
                "ordername text," +
                "orderprice text," +
                "ordertype text," +
                "poster text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean isInsertUser(String name, String email, String password){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues content= new ContentValues();
        content.put("email", email);
        content.put("name", name);
        content.put("password", password);

        long result =db.insert("user", null, content);
        if(result == -1){
            return false;
        }
        return true;
    }

    public boolean isInsertOrder(String itemName, String itemPrice, String ordertype, String poster){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("ordername", itemName);
        content.put("orderprice", itemPrice);
        content.put("ordertype", ordertype);
        content.put("poster", poster);

        long result = db.insert("orders", null, content);
        if(result == -1){
            return false;
        }
        return true;
    }
    public boolean checkemail(String email){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM user WHERE email = ?", new String[]{email});
        if(cursor.getCount() > 0){
            return true;
        }
        return false;
    }

    public boolean checkemailpassword(String email, String password){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM user WHERE email = ? AND password = ?", new String[]{email, password});
        if(cursor.getCount() > 0){
            return true;
        }
        return false;
    }

    public Cursor getOrdersByType(String ordertype){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM orders WHERE ordertype = ?", new String[]{ordertype});
        return cursor;
    }
}
