package com.example.skiroc.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.skiroc.criminalintent.crime.CrimeFragment;
import com.example.skiroc.criminalintent.model.Crime;
import com.example.skiroc.criminalintent.model.CrimeLab;
import com.example.skiroc.criminialintent.R;

import java.util.List;

/**
 * Created by skiroc on 2/28/17.
 */

public class CrimePagerActivity extends FragmentActivity {

    private ViewPager mViewPager;
    private List<Crime> mCrimes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_pager);

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
    }
}
