package com.example.skiroc.criminialintent.crimelist;

import android.support.v4.app.Fragment;

import com.example.skiroc.criminialintent.SingleFragmentActivity;

/**
 * Created by skiroc on 2/6/17.
 */

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
