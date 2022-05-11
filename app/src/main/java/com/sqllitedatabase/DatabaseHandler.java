package com.sqllitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "SQLiteDatabase.db";
    public static final String TABLE_NAME = "PEOPLE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_FIRST_NAME = "FIRST_NAME";
    public static final String COLUMN_LAST_NAME = "LAST_NAME";
    private SQLiteDatabase database;

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            //create table im onCreate method
        db.execSQL("create table "+ TABLE_NAME +
                " ( " + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
        + COLUMN_FIRST_NAME + "VARCHAR , "
                + COLUMN_LAST_NAME + " VARCHAR);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
    }
    public void insertRecord(DetailModel detailModel){
            database  = this.getReadableDatabase();
        ContentValues contentValues  =  new ContentValues();
        contentValues.put(COLUMN_FIRST_NAME,detailModel.getFirstName());
        contentValues.put(COLUMN_LAST_NAME,detailModel.getLastName());
        database.insert(TABLE_NAME,null,contentValues);
        database.close();
    }
    public void insertRecordAlternate(DetailModel detailModel){
        database = this.getReadableDatabase();
        database.execSQL("INSERT INTO "+ TABLE_NAME+
                "("+COLUMN_FIRST_NAME+","+
                COLUMN_LAST_NAME+") VAlUES ('"+ detailModel.getFirstName()+"," +detailModel.getLastName()
                +"')");
        database.close();
    }
    public ArrayList<DetailModel> getAllRecords() {
        database = this.getReadableDatabase();
        Cursor cursor = database.query(TABLE_NAME, null, null, null,
                null, null, null);
            ArrayList<DetailModel> detail = new ArrayList<DetailModel>();
            DetailModel detailModel;
            if(cursor.getCount() > 0){
                for(int i =0;i< cursor.getCount();i++){
                    cursor.moveToNext();
                    detailModel = new DetailModel();
                    detailModel.setId((cursor.getString(0)));
                    detailModel.setFirstName(cursor.getString(1));
                    detailModel.setLastName(cursor.getString(2));
                    detail.add(detailModel);

                }
            }
            cursor.close();
            database.close();
         return detail;
    }


    public void updateRecord(DetailModel detailModel){
        database = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_FIRST_NAME, detailModel.getFirstName());
        contentValues.put(COLUMN_LAST_NAME,detailModel.getLastName());
        database.update(TABLE_NAME, contentValues, COLUMN_ID + " = ?",
                new String[]{detailModel.getId()});
        database.close();
    }

    public void deleteRecord(DetailModel detailModel){
        database = this.getReadableDatabase();
        database.delete(TABLE_NAME,COLUMN_ID + " = ?", new String[]{detailModel.getId()});
        database.close();

    }
    public  void deleteRecordAlternate(DetailModel detailModel){
        database = this.getReadableDatabase();
        database.execSQL("delete from "+ TABLE_NAME+"where "+ COLUMN_ID + "= '" + detailModel.getId() + "'");
        database.close();
    }
}
