package com.example.skiroc.criminialintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by skiroc on 1/27/17.
 */

public class CrimeFragment extends Fragment {

    private Crime mCrime;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCrime = new Crime();
    }
}
