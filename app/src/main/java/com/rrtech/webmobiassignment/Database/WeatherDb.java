package com.rrtech.webmobiassignment.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class WeatherDb extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "WeatherHistory";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_WEATHER = "weather";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_CITY = "city_Name";
    private static final String COLUMN_TEMP = "temperature";
    private static final String COLUMN_CLOUD_PERCENT = "cloud_percent";
    private static final String COLUMN_ICON = "temperatureIcon";

    public WeatherDb(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_WEATHER + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_CITY + " TEXT," +
                COLUMN_TEMP + " TEXT," +
                COLUMN_CLOUD_PERCENT + " TEXT," +
                COLUMN_ICON + " TEXT" +
                ")";
        db.execSQL(createTableQuery);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Handle database upgrade if needed
    }

    public void addCityDetails(String cityName, String cityTemp, String cityCloudPercent, String tempIcon) {

        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_CITY, cityName);
        values.put(COLUMN_TEMP, cityTemp);
        values.put(COLUMN_CLOUD_PERCENT, cityCloudPercent);
        values.put(COLUMN_ICON, tempIcon);

        database.insert(TABLE_WEATHER, null, values);

    }

    public void updateCityDetails(WeatherDataDb weatherDetails) {

        SQLiteDatabase database = this.getWritableDatabase();


        ContentValues values = new ContentValues();

        values.put(COLUMN_CITY, weatherDetails.city_Name);
        values.put(COLUMN_TEMP, weatherDetails.temperature);
        values.put(COLUMN_CLOUD_PERCENT, weatherDetails.cloud_percent);
        values.put(COLUMN_ICON, weatherDetails.temperatureIcon);

        database.update(TABLE_WEATHER, values, COLUMN_ID + " = " + weatherDetails.id, null);


    }

    public String[] getData() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] results = null;
        Cursor cursor = db.rawQuery("SELECT * FROM weather LIMIT 1;", null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                results = new String[5];
                int idIndex = cursor.getColumnIndex("id");
                if (idIndex >= 0) {
                    results[0] = cursor.getString(idIndex);
                }
                int nameIndex = cursor.getColumnIndex("city_Name");
                if (nameIndex >= 0) {
                    results[1] = cursor.getString(nameIndex);
                }
                int emailIndex = cursor.getColumnIndex("temperature");
                if (emailIndex >= 0) {
                    results[2] = cursor.getString(emailIndex);
                }
                int phoneIndex = cursor.getColumnIndex("cloud_percent");
                if (phoneIndex >= 0) {
                    results[3] = cursor.getString(phoneIndex);
                }
                int addressIndex = cursor.getColumnIndex("temperatureIcon");
                if (addressIndex >= 0) {
                    results[4] = cursor.getString(addressIndex);
                }
            }
            cursor.close();
        }
        db.close();
        return results;
    }

    public boolean isDatabaseEmpty() {

        SQLiteDatabase database = this.getReadableDatabase();

        String query = "SELECT COUNT(*) FROM " + TABLE_WEATHER;
        Cursor cursor = null;
        int count = 0;

        try {
            cursor = database.rawQuery(query, null);
            if (cursor != null && cursor.moveToFirst()) {
                count = cursor.getInt(0);
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            database.close();
        }

        return count == 0;
    }


}
