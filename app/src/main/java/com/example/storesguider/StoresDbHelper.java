package com.example.storesguider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class StoresDbHelper extends SQLiteOpenHelper {

    private static final String COLUMN_TYPE = "type";
    private static final String COLUMN_STYLE = "style";
    private static final String COLUMN_LOCATION = "location";
    private static final String COLUMN_MUSIC = "music";
    private static final String COLUMN_AVERAGE_AGE = "average_age";

    private static final String COLUMN_PARKING = "parking";

    private static final String COLUMN_DISABLED_ACCESS = "disabled_access";

    private static final String DATABASE_NAME = "Stores.db";
    private static final String TABLE_STORES = "stores";


    public StoresDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create Table stores(name TEXT primary key, type TEXT, style TEXT, location TEXT, music TEXT, average_age TEXT, parking TEXT, disabled_access TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists stores");
    }

    public Boolean insertStore(String name,String type, String style, String location, String music, String averageAge, boolean parking,boolean disablePeople) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("type", type);
        values.put("style", style);
        values.put("location", location);
        values.put("music", music);
        values.put("average_age", averageAge);
        values.put("parking",parking);
        values.put("disabled_access",disablePeople);
        long result =  db.insert("stores", null, values);
        return result != -1;
    }

    /*public Cursor searchStores(String[] characteristics) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " +
                COLUMN_NAME + " = ? AND " +
                COLUMN_TYPE + " = ? AND " +
                COLUMN_STYLE + " = ? AND " +
                COLUMN_LOCATION + " = ? AND " +
                COLUMN_MUSIC + " = ? AND " +
                COLUMN_AVERAGE_AGE + " = ?";
        return db.rawQuery(query, characteristics);

    }*/

    public void searchStores(String type,String style,String location,String music,String averageAge,boolean parking,boolean disablePeople){
        SQLiteDatabase db=this.getReadableDatabase();
        String query;
        //υλοποίηση της search

        if (parking && !disablePeople)
        {
            query = "SELECT * FROM" + TABLE_STORES +
                    "WHERE" + COLUMN_TYPE + "=" + type +
                    COLUMN_STYLE + "=" + style +
                    COLUMN_LOCATION + "=" + location +
                    COLUMN_MUSIC + "=" + music +
                    COLUMN_AVERAGE_AGE + "=" + averageAge +
                    COLUMN_PARKING + "=" + parking;
        }
        else if (!parking && disablePeople)
        {
            query = "SELECT * FROM" + TABLE_STORES +
                    "WHERE" + COLUMN_TYPE + "=" + type +
                    COLUMN_STYLE + "=" + style +
                    COLUMN_LOCATION + "=" + location +
                    COLUMN_MUSIC + "=" + music +
                    COLUMN_AVERAGE_AGE + "=" + averageAge +
                    COLUMN_DISABLED_ACCESS + "=" + disablePeople;
        }
        else if (!parking && !disablePeople)
        {
            query = "SELECT * FROM" + "stores" +
                    "WHERE" + COLUMN_TYPE + "=" + type +
                    COLUMN_STYLE + "=" + style +
                    COLUMN_LOCATION + "=" + location +
                    COLUMN_MUSIC + "=" + music +
                    COLUMN_AVERAGE_AGE + "=" + averageAge;
        }
        else
        {
            query = "SELECT * FROM" + "stores" +
                    "WHERE" + COLUMN_TYPE + "=" + type +
                    COLUMN_STYLE + "=" + style +
                    COLUMN_LOCATION + "=" + location +
                    COLUMN_MUSIC + "=" + music +
                    COLUMN_AVERAGE_AGE + "=" + averageAge +
                    COLUMN_PARKING + "=" + parking +
                    COLUMN_DISABLED_ACCESS + "=" + disablePeople;
        }

        db.close();

    }
}
