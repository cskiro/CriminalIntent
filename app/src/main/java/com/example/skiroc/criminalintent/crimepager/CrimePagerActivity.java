package com.example.skiroc.criminalintent.crimepager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.skiroc.criminalintent.crime.CrimeFragment;
import com.example.skiroc.criminalintent.model.Crime;
import com.example.skiroc.criminalintent.model.CrimeLab;
import com.example.skiroc.criminialintent.R;

import java.util.List;
import java.util.UUID;

/**
 * Created by skiroc on 2/28/17.
 */

public class CrimePagerActivity extends AppCompatActivity {
    private static final String EXTRA_CRIME_ID =
            "com.example.skiroc.criminalintent.crime_id";

    private ViewPager mViewPager;
    private List<Crime> mCrimes;

    public static Intent newIntent(Context packageContext, UUID crimeId) {
        Intent intent = new Intent(packageContext, CrimePagerActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crimeId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_pager);

        UUID crimeId = (UUID) getIntent()
                .getSerializableExtra(EXTRA_CRIME_ID);

        // Finding ViewPager in the activity's view
        mViewPager = (ViewPager) findViewById(R.id.activity_crime_view_pager);

        // Retrieving list of crimes
        mCrimes = CrimeLab.getCrimeLab(this).getCrimes();

        // Getting the activity's instance of FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();

        // Setting the adapter to be an unnamed instance of FragmentStatePagerAdapter
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                // Fetching the crime instance for the given position in the list
                Crime crime = mCrimes.get(position);

                // Getting ID of the crime to create and return a properly configured CrimeFragment
                return CrimeFragment.newInstance(crime.getId());
            }

            @Override
            public int getCount() {
                // Returns number of crimes in the ArrayList
                return mCrimes.size();
            }
        });

        for (int i=0; i < mCrimes.size(); i++) {
            if (mCrimes.get(i).getId().equals(crimeId)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
