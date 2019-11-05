package com.bansal.minorproject.data.database;

import java.util.Date;

public class MusicianEstablishment {
    int _mID;
    int _eID;
    Date date;
    Date bookedDate;

    public MusicianEstablishment(int _mID, int _eID, Date date, Date bookedDate) {
        this._mID = _mID;
        this._eID = _eID;
        this.date = date;
        this.bookedDate = bookedDate;
    }

    public int get_mID() {
        return _mID;
    }

    public int get_eID() {
        return _eID;
    }

    public Date getDate() {
        return date;
    }

    public Date getBookedDate() {
        return bookedDate;
    }
}
