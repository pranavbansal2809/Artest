package com.bansal.minorproject.data.database;

import android.util.Log;
import com.google.firebase.firestore.FirebaseFirestore;

import org.jetbrains.annotations.NotNull;

public class FireStoreAccess {
    private static final String TAG = "FireStoreAccess Class";
    FirebaseFirestore db;

    public FirebaseFirestore getDb(){
        if(db==null){
            db= FirebaseFirestore.getInstance();
        }
        return db;
    }


    public void storeMusician(@NotNull Musician musician){
        db.collection("musician").document(""+musician.get_mID()).set(musician)
                .addOnSuccessListener(aVoid -> Log.d(TAG, "onSuccess: storeMusician"))
            .addOnFailureListener(e -> Log.d(TAG, "onFailure: storeMusician"));
    }

    public void storeBand(@NotNull Band band){
        db.collection("band").document(""+band.get_bID()).set(band)
                .addOnSuccessListener(aVoid -> Log.d(TAG, "onSuccess: storeBand"))
                .addOnFailureListener(e -> Log.d(TAG, "onFailure: storeBand"));
    }

    public void storeEstablishment(@NotNull Establishment establishment){
        db.collection("establishment").document(""+establishment.get_eID()).set(establishment)
                .addOnSuccessListener(aVoid -> Log.d(TAG, "onSuccess: storeEstablishment"))
                .addOnFailureListener(e -> Log.d(TAG, "onFailure: storeEstablishment"));
    }

    public void storeBandEstb(BandEstablishment bandEstablishment){
        db.collection("band").document(""+bandEstablishment.get_bId())
            .collection("bandMusician").document(""+bandEstablishment.get_eId())
            .set(bandEstablishment)
                .addOnSuccessListener(aVoid -> Log.d(TAG, "onSuccess: storeBandEstb"))
                .addOnFailureListener(e -> Log.d(TAG, "onFailure: storeBandEstb"));
    }

    public void storeEstbManager(EstablishmentManager establishmentManager){
        db.collection("establishment").document(""+establishmentManager.get_eID())
                .collection("establishmentManager").document(""+establishmentManager.get_mID())
                .set(establishmentManager)
                .addOnSuccessListener(aVoid -> Log.d(TAG, "onSuccess: storeEstbManager"))
                .addOnFailureListener(e -> Log.d(TAG, "onFailure: storeEstbManager"));
    }

    public void storeMusicianEstb(MusicianEstablishment musicianEstablishment){
        db.collection("musician").document(""+musicianEstablishment.get_mID())
                .collection("musicianEstablishment").document(""+musicianEstablishment.get_eID())
                .set(musicianEstablishment)
                .addOnSuccessListener(aVoid -> Log.d(TAG, "onSuccess: storeMusicianEstb"))
                .addOnFailureListener(e -> Log.d(TAG, "onFailure: storeMusicianEstb"));
    }

}
