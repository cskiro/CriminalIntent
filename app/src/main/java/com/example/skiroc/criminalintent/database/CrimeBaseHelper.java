package com.example.skiroc.criminalintent.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.skiroc.criminalintent.database.CrimeDbSchema.CrimeTable;

/**
 * Created by skiroc on 4/8/17.
 */

public class CrimeBaseHelper extends SQLiteOpenHelper {
    private static int VERSION = 1;
    private static final String DATABASE_NAME = "crimeBase.db";

    public CrimeBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + CrimeTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                CrimeTable.Columns.UUID + ", " +
                CrimeTable.Columns.TITLE + ", " +
                CrimeTable.Columns.DATE + ", " +
                CrimeTable.Columns.SOLVED +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
