package com.daawa.ipc.example;

import android.os.Parcel;
import android.os.Parcelable;

public class MarshallObject implements Parcelable {

    private String mPath;

    public MarshallObject(Parcel source) {
        mPath = source.readString();
    }

    public MarshallObject(String path) {
        mPath = path;
    }

    public String getPath() {
        return mPath;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mPath);
    }

    public static final Parcelable.Creator<MarshallObject> CREATOR = new Parcelable.Creator<MarshallObject>() {
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
