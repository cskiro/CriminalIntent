package com.example.skiroc.criminalintent.crimelist;

import android.content.Intent;
import android.support.v4.app.Fragment;

import com.example.skiroc.criminalintent.SingleFragmentActivity;
import com.example.skiroc.criminalintent.crime.CrimeFragment;
import com.example.skiroc.criminalintent.crimepager.CrimePagerActivity;
import com.example.skiroc.criminalintent.model.Crime;
import com.example.skiroc.criminialintent.R;

/**
 * Created by skiroc on 2/6/17.
 */

public class CrimeListActivity extends SingleFragmentActivity implements CrimeListFragment.Callbacks {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_masterdetail;
    }

    @Override
    public void onCrimeSelected(Crime crime) {
        if (findViewById(R.id.detail_fragment_container) == null) {
            Intent intent = CrimePagerActivity.newIntent(this, crime.getId());
            startActivity(intent);
        } else {
            Fragment newDetail = CrimeFragment.newInstance(crime.getId());

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_fragment_container, newDetail)
                    .commit();
        }
    }
}
