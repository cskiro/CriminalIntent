package com.example.skiroc.criminalintent.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.skiroc.criminalintent.model.Crime;

/**
 * Created by skiroc on 4/28/17.
 */

public class CrimeCursorWrapper extends CursorWrapper {
    public CrimeCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Crime getCrime() {
        String uuidString = getString(getColumnIndex(CrimeDbSchema.CrimeTable.Columns.UUID));
        String title = getString(getColumnIndex(CrimeDbSchema.CrimeTable.Columns.TITLE));
        long date = getLong(getColumnIndex(CrimeDbSchema.CrimeTable.Columns.DATE));
        int isSolved = getInt(getColumnIndex(CrimeDbSchema.CrimeTable.Columns.SOLVED));

        return null;
    }
}
