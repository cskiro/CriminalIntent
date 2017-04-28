package com.example.skiroc.criminalintent.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.skiroc.criminalintent.database.CrimeBaseHelper;
import com.example.skiroc.criminalintent.database.CrimeDbSchema;

import java.util.UUID;

/**
 * Created by skiroc on 2/4/17.
 */

public class CrimeLab {
    private static CrimeLab sCrimeLab;

    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static CrimeLab getCrimeLab(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new CrimeBaseHelper(mContext).getWritableDatabase();
    }

    public void addCrime(Crime crime) {

    }

    public void deleteCrime(Crime crime) {
    }


    public Crime getCrime(UUID id) {
        return null;
    }

    private static ContentValues getContentValues(Crime crime) {
        ContentValues values = new ContentValues();
        values.put(CrimeDbSchema.CrimeTable.Columns.UUID, crime.getId().toString());
        values.put(CrimeDbSchema.CrimeTable.Columns.TITLE, crime.getTitle());
        values.put(CrimeDbSchema.CrimeTable.Columns.DATE, crime.getDate().getTime());
        values.put(CrimeDbSchema.CrimeTable.Columns.SOLVED, crime.isSolved() ? 1 : 0);
    }
}
