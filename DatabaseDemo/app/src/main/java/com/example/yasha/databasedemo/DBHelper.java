package com.example.yasha.databasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

import static android.R.attr.id;


public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyDBName.db";
    public static final String CONTACTS_TABLE_NAME ="contacts";
    public static final String CONTACTS_COLUMN_ID ="id";
    public static final String CONTACTS_COLUMN_NAME ="name";
    public static final String CONTACTS_COLUMN_EMAIL ="email";
    public static final String CONTACTS_COLUMN_STREET ="street";
    public static final String CONTACTS_COLUMN_CITY ="place";
    public static final String CONTACTS_COLUMN_PHONE ="phone";
    private HashMap hp;

    public DBHelper (Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(
                "create table contacts " +
                        "(id integer primary key, name text,phone text,email text, street text,place text)"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP LE IF EXISTS contact");
        onCreate(db);
    }

    public boolean insertContact (String name, String phone, String email, String street,String place){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("phone",phone);
        contentValues.put("email",email);
        contentValues.put("street",street);
        contentValues.put("place",place);
        db.insert("contacts", null, contentValues);
        return true;
    }

    public Cursor getData(int d) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from contacts where id="+id+"", null );
        return  res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, CONTACTS_TABLE_NAME);
        return numRows;
    }

    public boolean updateContact (Integer id, String name, String phone, String email, String street,String place){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("phone",phone);
        contentValues.put("email",email);
        contentValues.put("street",street);
        contentValues.put("place",place);
        db.update("contacts", contentValues, "id = ?", new String[] {Integer.toString(id)});
        return true;
    }

    public Integer deleteContact (Integer id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("contacts", "id = ?", new String[] {Integer.toString(id)} );
    }

    public ArrayList<String> getAllContacts() {
        ArrayList<String> array_list = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from contacts", null);
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(CONTACTS_COLUMN_NAME)));
            res.moveToNext();
        }
        return array_list;
    }
}
