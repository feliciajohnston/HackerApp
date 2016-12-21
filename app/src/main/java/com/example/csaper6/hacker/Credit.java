package com.example.csaper6.hacker;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by csaper6 on 10/17/16.
 */
public class Credit implements Parcelable {

    private int credits;

    public Credit()
    {
        credits = 0;
    }
    public Credit (int credits)
    {
        this.credits = credits;
    }

    public void addCredits(int i)
    {
        credits += i;
    }
    public void removeCredits(int i)
    {
        credits -= i;
    }
    public int getCredits()
    {
        return credits;
    }
    public void setCredits(int i)
    {
        credits = i;
    }





    protected Credit(Parcel in) {
        credits = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(credits);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Credit> CREATOR = new Parcelable.Creator<Credit>() {
        @Override
        public Credit createFromParcel(Parcel in) {
            return new Credit(in);
        }

        @Override
        public Credit[] newArray(int size) {
            return new Credit[size];
        }
    };
}