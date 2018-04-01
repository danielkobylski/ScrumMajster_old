package com.ciastkaipiwo.android.scrummajster;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Daniel on 30.03.2018.
 */

public class Project implements Parcelable {

    private String mTitle;
    private GregorianCalendar mStartDate;
    private GregorianCalendar mEndDate;

    Project(String title, GregorianCalendar startDate, GregorianCalendar endDate) {
        mTitle = title;
        mStartDate = startDate;
        mEndDate = endDate;
    }

    protected Project(Parcel in) {
        mTitle = in.readString();
        mStartDate = (GregorianCalendar) in.readSerializable();
        mEndDate = (GregorianCalendar) in.readSerializable();
    }

    public static final Creator<Project> CREATOR = new Creator<Project>() {
        @Override
        public Project createFromParcel(Parcel in) {
            return new Project(in);
        }

        @Override
        public Project[] newArray(int size) {
            return new Project[size];
        }
    };

    public String getTitle() {
        return mTitle;
    }
    public void setTitle(String title) {mTitle = title;}
    public GregorianCalendar getStartDate() {
        return mStartDate;
    }
    public void setStartDate(GregorianCalendar startDate) {
        mStartDate = startDate;
    }
    public GregorianCalendar getEndDate() {
        return mEndDate;
    }
    public void setEndDate(GregorianCalendar endDate) {
        mEndDate = endDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mTitle);
        parcel.writeSerializable(mStartDate);
        parcel.writeSerializable(mEndDate);
    }
}
