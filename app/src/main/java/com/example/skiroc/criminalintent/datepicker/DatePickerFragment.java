package com.example.skiroc.criminalintent.datepicker;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import com.example.skiroc.criminialintent.R;

/**
 * Created by skiroc on 3/31/17.
 */

public class DatePickerFragment extends DialogFragment {
    View mView = LayoutInflater.from(getActivity())
            .inflate(R.layout.dialog_date, null);

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setView(mView)
                .setTitle(R.string.date_picker_title)
                .setPositiveButton(android.R.string.ok, null)
                .create();
    }
}
