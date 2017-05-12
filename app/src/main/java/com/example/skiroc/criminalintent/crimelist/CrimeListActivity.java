package com.example.skiroc.criminalintent.crimelist;

import android.support.v4.app.Fragment;

import com.example.skiroc.criminalintent.SingleFragmentActivity;
import com.example.skiroc.criminialintent.R;

/**
 * Created by skiroc on 2/6/17.
 */

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_twopane;
    }
}
