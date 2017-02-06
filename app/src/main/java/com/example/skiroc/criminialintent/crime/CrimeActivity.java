package com.example.skiroc.criminialintent.crime;

import android.support.v4.app.Fragment;

import com.example.skiroc.criminialintent.SingleFragmentActivity;

public class CrimeActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeFragment();
    }
}
