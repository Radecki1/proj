package pl.cba.radeckiuczony.mushroomer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLHelper extends SQLiteOpenHelper {
    String selectQuery;
    // Database name
    public static String DATABASE_GRZYBY = "Wszystko";
    // Current version of database
    private static final int DATABASE_VERSION = 1;
    // Database table name
    public static final String TABLE_QUESTION = "Mushrooms";
    // All fields used in database table
    private static final String KEY_ID = "id";
    private static final String GRZYB = "grzyb";
    private static final String KSZTALT = "ksztalt";
    private static final String POCHPIER = "pochpier";
    private static final String BLASZKI = "blaszki";
    private static final String LAS = "las";
    public static SQLiteDatabase db;

    {
        db = this.getReadableDatabase();
    }


    // Question Table Create Query in this string
    private static final String CREATE_TABLE_QUESTION = "CREATE TABLE "
            + TABLE_QUESTION + "(" + KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + GRZYB + " TEXT,"
            + KSZTALT + " TEXT, " + POCHPIER + " TEXT, " + BLASZKI + " TEXT, "
            + LAS + " TEXT);";

    public SQLHelper(Context context) {
        super(context, DATABASE_GRZYBY, null, DATABASE_VERSION);
    }

    /**
     * This method is called by system if the database is accessed but not yet
     * created.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_QUESTION); // create question table
    }

    /**
     * This method is called when any modifications in database are done like
     * version is updated or database schema is changed
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTION); // drop table if exists
        onCreate(db);
    }

    /**
     * This method is used to add question detail in question Table
     */

    public long wstawdane(String grzyb, String ksztalt, String pochpier, String blaszki, String las) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Creating content values
        ContentValues values = new ContentValues();
        values.put(GRZYB, grzyb);
        values.put(KSZTALT, ksztalt);
        values.put(POCHPIER, pochpier);
        values.put(BLASZKI,  blaszki);
        values.put(LAS,  las);
        // insert row in question table
        long insert = db.insert(TABLE_QUESTION, null, values);
        return insert;
    }

    /**
     * To extract data from database and save it Arraylist of data type
     * Question
     */

    /*public Cursor kursor(String m1) {

        //String selectQuery = "SELECT  * FROM " + TABLE_QUESTION + " WHERE KSZTALT LIKE 't1'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(Queries.QUERY_DWA_BLASZ_IG, null);

        return c;
    }*/

    public static Cursor getList(String queryfinal) {

        Cursor c = db.rawQuery(queryfinal, null);
        return c;
    }
}
