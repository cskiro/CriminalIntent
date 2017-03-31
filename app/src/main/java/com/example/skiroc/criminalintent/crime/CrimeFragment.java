package com.example.skiroc.criminalintent.crime;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.example.skiroc.criminalintent.datepicker.DatePickerFragment;
import com.example.skiroc.criminalintent.model.Crime;
import com.example.skiroc.criminalintent.model.CrimeLab;
import com.example.skiroc.criminialintent.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by skiroc on 1/27/17.
 */

/**
 * Controller that interacts with model and view objects
 * Presents and updates the details of a specific crime
 */

public class CrimeFragment extends Fragment {

    private static final String ARG_CRIME_ID = "crime_id";
    private static final String DIALOG_DATE = "DialogDate";

    /**
     * Instance (member) variables
     */
    private Crime mCrime;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;

    public static CrimeFragment newInstance(UUID crimeId) {
        // Creating a Bundle object
        Bundle args = new Bundle();
        // Adding arguments to the Bundle
        args.putSerializable(ARG_CRIME_ID, crimeId);
        // Creating a CrimeFragment object
        CrimeFragment crimeFragment = new CrimeFragment();
        // Attaching arguments bundle to a fragment
        crimeFragment.setArguments(args);

        return crimeFragment;
    }

    /**
     * Fragment lifecycle methods must be public
     * because they will be called by the activity
     * hosting the fragment
     * <p>
     * Configuring the fragment instance
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * getArguments() allows a fragment to access its arguments
         * along with a type-specific "get" method of Bundle
         */
        UUID crimeId = (UUID) getArguments().getSerializable(ARG_CRIME_ID);
        mCrime = CrimeLab.getCrimeLab(getActivity()).getCrime(crimeId);
    }

    /**
     * Inflates the layout of the fragment's view
     *
     * @param inflater           passes the layout resource ID
     * @param container          view's parent; needed to configure the widgets properly
     * @param savedInstanceState tells layout inflater whether to add the
     *                           inflated view to the view's parent
     * @return View
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime, container, false);

        mTitleField = (EditText) view.findViewById(R.id.crime_title);
        mTitleField.setText(mCrime.getTitle());
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // intentionally left blank
            }

            // Sets the crime's title
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mCrime.setTitle(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // intentionally left blank
            }
        });

        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
        Date date = new Date();
        String dateString = dateFormat.format(date);

        mDateButton = (Button) view.findViewById(R.id.crime_date_button);
        mDateButton.setText(dateString);
        mDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                DatePickerFragment dialog = new DatePickerFragment();
                dialog.show(fragmentManager, DIALOG_DATE);
            }
        });
        mSolvedCheckBox = (CheckBox) view.findViewById(R.id.crime_solved_checkbox);
        mSolvedCheckBox.setChecked(mCrime.isSolved());
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                // Set the crime's solved property
                mCrime.setSolved(isChecked);
            }
        });

        return view;
    }
}
