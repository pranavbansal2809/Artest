package com.bansal.minorproject.data.database;

import java.util.Date;

public class BandEstablishment {
    int _bId;
    int _eId;
    Date date;
    Date bookingDate;

    public BandEstablishment(int _bId, int _eId, Date date, Date bookingDate) {
        this._bId = _bId;
        this._eId = _eId;
        this.date = date;
        this.bookingDate = bookingDate;
    }

    public int get_bId() {
        return _bId;
    }

    public int get_eId() {
        return _eId;
    }

    public Date getDate() {
        return date;
    }

    public Date getBookingDate() {
        return bookingDate;
    }
}
