package com.example.storesguider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StoresDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Stores.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "stores";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_TYPE = "type";
    private static final String COLUMN_STYLE = "style";
    private static final String COLUMN_LOCATION = "location";
    private static final String COLUMN_MUSIC = "music";
    private static final String COLUMN_AVERAGE_AGE = "average_age";

    private static final String CREATE_TABLE_QUERY = "CREATE TABLE " + TABLE_NAME + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_NAME + " TEXT, " +
            COLUMN_TYPE + " TEXT, " +
            COLUMN_STYLE + " TEXT, " +
            COLUMN_LOCATION + " TEXT, " +
            COLUMN_MUSIC + " TEXT, " +
            COLUMN_AVERAGE_AGE + " TEXT" +
            ")";

    public StoresDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    /*public long insertStore(String type, String style, String location, String music, String averageAge) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_TYPE, type);
        values.put(COLUMN_STYLE, style);
        values.put(COLUMN_LOCATION, location);
        values.put(COLUMN_MUSIC, music);
        values.put(COLUMN_AVERAGE_AGE, averageAge);
        return db.insert(TABLE_NAME, null, values);
    }

    public Cursor searchStores(String[] characteristics) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " +
                COLUMN_TYPE + " = ? AND " +
                COLUMN_STYLE + " = ? AND " +
                COLUMN_LOCATION + " = ? AND " +
                COLUMN_MUSIC + " = ? AND " +
                COLUMN_AVERAGE_AGE + " = ?";
        return db.rawQuery(query, characteristics);
    }*/

    public void searchStores(String type,String style,String location,String music,String averageAge,boolean parking,boolean disablePeople){
        SQLiteDatabase db=this.getReadableDatabase();
        //υλοποίηση της search
    }
}
