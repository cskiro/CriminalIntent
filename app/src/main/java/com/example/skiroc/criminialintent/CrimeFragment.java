package com.example.skiroc.criminialintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by skiroc on 1/27/17.
 */

/**
 * Controller that interacts with model and view objects
 * Presents and updates the details of a specific crime
 */

public class CrimeFragment extends Fragment {

    /**
     * Instance (member) variables
     */
    private Crime mCrime;
    private EditText mTitleField;

    /**
     * Fragment lifecycle methods must be public
     * because they will be called by the activity
     * hosting the fragment
     */

    /**
     * Configuring the fragment instance
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCrime = new Crime();
    }

    /**
     * Inflates the layout of the fragment's view
     *
     * @param inflater passes the layout resource ID
     * @param container view's parent; needed to configure the widgets properly
     * @param savedInstanceState tells layout inflater whether to add the
     *                           inflated view to the view's parent
     * @return View
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime, container, false);

        mTitleField = (EditText)view.findViewById(R.id.crime_title);
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // intentionally left blank
            }

            /**
             * Sets the crime's title
             *
             * @param charSequence
             * @param i
             * @param i1
             * @param i2
             */
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mCrime.setTitle(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // intentionally left blank
            }
        });

        return view;
    }
}
