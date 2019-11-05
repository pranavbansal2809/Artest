package com.bansal.minorproject.data.database;

import android.graphics.Bitmap;

public class Establishment {
    int _eID;
    String eName;
    String address;
    String phNo;
    String eMail;
    String socialMedia1;
    String socialMedia2;
    Bitmap profilePicture;
    Bitmap backPicture;
    int rating;
    String[] requirement;   //types of musician/band preferred

    public Establishment(int _eID, String eName, String address, String phNo, String eMail, String socialMedia1, String socialMedia2, Bitmap profilePicture, Bitmap backPicture, int rating, String[] requirement) {
        this._eID = _eID;
        this.eName = eName;
        this.address = address;
        this.phNo = phNo;
        this.eMail = eMail;
        this.socialMedia1 = socialMedia1;
        this.socialMedia2 = socialMedia2;
        this.profilePicture = profilePicture;
        this.backPicture = backPicture;
        this.rating = rating;
        this.requirement = requirement;
    }

    public int get_eID() {
        return _eID;
    }

    public String geteName() {
        return eName;
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

    public String[] getRequirement() {
        return requirement;
    }
}
