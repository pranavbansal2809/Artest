package com.bansal.minorproject.data.database;

public class EstablishmentManager {
    int _mID;
    int _eID;
    String managerName;
    String mPhNo;
    String mEMail;

    public EstablishmentManager(int _mID, int _eID, String managerName, String mPhNo, String mEMail) {
        this._mID = _mID;
        this._eID = _eID;
        this.managerName = managerName;
        this.mPhNo = mPhNo;
        this.mEMail = mEMail;
    }

    public int get_mID() {
        return _mID;
    }

    public int get_eID() {
        return _eID;
    }

    public String getManagerName() {
        return managerName;
    }

    public String getmPhNo() {
        return mPhNo;
    }

    public String getmEMail() {
        return mEMail;
    }
}
