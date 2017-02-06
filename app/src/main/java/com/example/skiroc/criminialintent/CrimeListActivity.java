package com.example.skiroc.criminialintent;

import android.support.v4.app.Fragment;

/**
 * Created by skiroc on 2/6/17.
 */

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
