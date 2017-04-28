package com.example.skiroc.criminalintent.model;

import java.util.Date;
import java.util.UUID;

/**
 * Created by skiroc on 1/26/17.
 */

public class Crime {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    /**
     * Constructor
     */
    public Crime() {
        this(UUID.randomUUID());
    }

    public Crime(UUID id) {
        // Generate unique identifier
        mId = id;
        mDate = new Date();
    }

    /**
     * Getters and Setters
     */
    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }
}
