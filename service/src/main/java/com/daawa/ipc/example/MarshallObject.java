package com.daawa.ipc.example;

import android.os.Parcel;
import android.os.Parcelable;


public class MarshallObject implements Parcelable {

    private String mValue;

    public MarshallObject(Parcel source) {
        mValue = source.readString();
    }

    public MarshallObject(String value) {
        mValue = value;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mValue);
    }

    public static final Creator<MarshallObject> CREATOR = new Creator<MarshallObject>() {
        @Override
        public MarshallObject[] newArray(int size) {
            return new MarshallObject[size];
        }

        @Override
        public MarshallObject createFromParcel(Parcel source) {
            return new MarshallObject(source);
        }
    };
}
