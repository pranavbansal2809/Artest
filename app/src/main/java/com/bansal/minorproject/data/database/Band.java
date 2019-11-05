package com.bansal.minorproject.data.database;

import android.graphics.Bitmap;

public class Band {
    int _bID;
    String bName;
    String currentLocation;
    String address;     //location where the band is based out of
    String phNo;
    String eMail;
    String socialMedia1;
    String socialMedia2;
    Bitmap profilePicture;
    Bitmap backPicture;
    int rating;

    int[] musicians;     // ID's of musicians part of band

    public Band(int _bID, String bName, String currentLocation, String address, String phNo, String eMail, String socialMedia1, String socialMedia2, Bitmap profilePicture, Bitmap backPicture, int rating, int[] musicians) {
        this._bID = _bID;
        this.bName = bName;
        this.currentLocation = currentLocation;
        this.address = address;
        this.phNo = phNo;
        this.eMail = eMail;
        this.socialMedia1 = socialMedia1;
        this.socialMedia2 = socialMedia2;
        this.profilePicture = profilePicture;
        this.backPicture = backPicture;
        this.rating = rating;
        this.musicians = musicians;
    }

    public int get_bID() {
        return _bID;
    }

    public String getbName() {
        return bName;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public String getAddress() {
        return address;
    }

    public String getPhNo() {
        return phNo;
    }

    public String geteMail() {
        return eMail;
    }

    public String getSocialMedia1() {
        return socialMedia1;
    }

    public String getSocialMedia2() {
        return socialMedia2;
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

    public int[] getMusicians() {
        return musicians;
    }
}
