package com.bansal.minorproject.data.database;

import android.graphics.Bitmap;

public class Musician {
    // fields needed by a musician only
    int _mID;
    String mName;
    String stageName;
    String address;
    String currentLocation;
    String phNo;
    String eMail;
    String sMedia1;     //for instagram
    String sMedia2;     //for twitter
    Bitmap profilePicture;
    Bitmap backPicture;
    int rating;
    String[] speciality;
    String desc;        //any description provided by musician

    public Musician(int _mID, String mName, String stageName, String address, String currentLocation, String phNo, String eMail, String sMedia1, String sMedia2, Bitmap profilePicture, Bitmap backPicture, int rating, String[] speciality, String desc) {
        this._mID = _mID;
        this.mName = mName;
        this.stageName = stageName;
        this.address = address;
        this.currentLocation = currentLocation;
        this.phNo = phNo;
        this.eMail = eMail;
        this.sMedia1 = sMedia1;
        this.sMedia2 = sMedia2;
        this.profilePicture = profilePicture;
        this.backPicture = backPicture;
        this.rating = rating;
        this.speciality = speciality;
        this.desc = desc;
    }

    public int get_mID() {
        return _mID;
    }

    public String getmName() {
        return mName;
    }

    public String getStageName() {
        return stageName;
    }

    public String getAddress() {
        return address;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public String getPhNo() {
        return phNo;
    }

    public String geteMail() {
        return eMail;
    }

    public String getsMedia1() {
        return sMedia1;
    }

    public String getsMedia2() {
        return sMedia2;
    }

    public Bitmap getProfilePicture() {
        return profilePicture;
    }

    public Bitmap getBackPicture() {
        return backPicture;
    }

    public int getRating() {
        return rating;
    }

    public String[] getSpeciality() {
        return speciality;
    }

    public String getDesc() {
        return desc;
    }
}
