package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private String age,weight,height,bsugar,pressureL,cholestrolL;

    public static final String DATABASE_NAME = "Medidoc.db";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_HEALTH =
                "CREATE TABLE " +
                        UserMaster.Health.TABLE_NAME + " (" +
                        UserMaster.Health._ID + " INTEGER PRIMARY KEY," +
                        UserMaster.Health.COLUMN_1 + " TEXT, " +
                        UserMaster.Health.COLUMN_2 + " TEXT, " +
                        UserMaster.Health.COLUMN_3 + " TEXT, " +
                        UserMaster.Health.COLUMN_4 + " TEXT, " +
                        UserMaster.Health.COLUMN_5 + " TEXT, " +
                        UserMaster.Health.COLUMN_6 + " TEXT) ";


        db.execSQL(SQL_CREATE_HEALTH);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public boolean addHealthStatus(String age, String weight, String height, String bsuger, String bpressure, String cholesterol) {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();


        values.put(UserMaster.Health.COLUMN_1, age);
        values.put(UserMaster.Health.COLUMN_2, weight);
        values.put(UserMaster.Health.COLUMN_3, height);
        values.put(UserMaster.Health.COLUMN_4, bsuger);
        values.put(UserMaster.Health.COLUMN_5, bpressure);
        values.put(UserMaster.Health.COLUMN_6, cholesterol);


        long newRowId = db.insert(UserMaster.Health.TABLE_NAME, null, values);

        if (newRowId > 0) {
            return true;

        } else {

            return false;


        }


    }




    public void retriveHealthStatus() {

        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {

                UserMaster.Health.COLUMN_1,
                UserMaster.Health.COLUMN_2,
                UserMaster.Health.COLUMN_3,
                UserMaster.Health.COLUMN_4,
                UserMaster.Health.COLUMN_5,
                UserMaster.Health.COLUMN_6

        };


        Cursor cursor = db.query(
                UserMaster.Health.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);




        while(cursor.moveToNext()){

            age = cursor.getString(cursor.getColumnIndexOrThrow(UserMaster.Health.COLUMN_1));
            weight = cursor.getString(cursor.getColumnIndexOrThrow(UserMaster.Health.COLUMN_2));

            height = cursor.getString(cursor.getColumnIndexOrThrow(UserMaster.Health.COLUMN_3));

            bsugar = cursor.getString(cursor.getColumnIndexOrThrow(UserMaster.Health.COLUMN_4));

            pressureL = cursor.getString(cursor.getColumnIndexOrThrow(UserMaster.Health.COLUMN_5));

            cholestrolL = cursor.getString(cursor.getColumnIndexOrThrow(UserMaster.Health.COLUMN_6));



        }


        cursor.close();







    }

    public String getAge() {
        return age;
    }

    public String getWeight() {
        return weight;
    }

    public String getHeight() {
        return height;
    }

    public String getBsugar() {
        return bsugar;
    }

    public String getPressureL() {
        return pressureL;
    }

    public String getCholestrolL() {
        return cholestrolL;
    }




    public int updateHealthStatus(String age,String weight,String height,String bsugar,String pressureL,String cholestrolL) {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(UserMaster.Health.COLUMN_1, age);
        values.put(UserMaster.Health.COLUMN_2, weight);
        values.put(UserMaster.Health.COLUMN_3, height);
        values.put(UserMaster.Health.COLUMN_4, bsugar);
        values.put(UserMaster.Health.COLUMN_5, pressureL);
        values.put(UserMaster.Health.COLUMN_6, cholestrolL);


        String selection = UserMaster.Health.TABLE_NAME;


        int i = db.update(UserMaster.Health.TABLE_NAME,
                values,
                null,
                null
        );


        return i;


    }



    public void deleteHealthstatus(){

        SQLiteDatabase db = getReadableDatabase();



        db.delete(UserMaster.Health.TABLE_NAME,
                null,
                null






        );


    }


}







