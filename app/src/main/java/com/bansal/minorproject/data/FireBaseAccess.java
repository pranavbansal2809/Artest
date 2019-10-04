package com.bansal.minorproject.data;


import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.bansal.minorproject.R;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class FireBaseAccess {

    private FirebaseAuth mAuth;
    private static final String TAG = "MainActivity";
    private GoogleApiClient googleApiClient;
    private String name, email;
    private String idToken;
    private FirebaseAuth.AuthStateListener authStateListener;
    public Navigate navigate;

    public interface Navigate {
        public void onNavigate();
    }

    private FireBaseAccess fireBaseAccess;

    public FireBaseAccess getFireBaseAccess(){
        if(fireBaseAccess==null){
            return new FireBaseAccess();
        }
        return fireBaseAccess;
    }

    public FirebaseAuth.AuthStateListener getAuthStateListener(){
        mAuth = com.google.firebase.auth.FirebaseAuth.getInstance();
        //this is where we start the Auth state Listener to listen for whether the user is signed in or not
        authStateListener = new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                // Get signedIn user
                FirebaseUser user = firebaseAuth.getCurrentUser();

                //if user is signed in, we call a helper method to save the user details to Firebase
                if (user != null) {
                    // User is signed in
                    // you could place other firebase code
                    //logic to save the user details to Firebase
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
            }
        };

        return authStateListener;
    }

    public GoogleApiClient getGoogleApiClient(Context context) {
        GoogleSignInOptions gso =  new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("448928085324-82e8soj2stintlp884jtelel0hhgejh9.apps.googleusercontent.com")//you can also use R.string.default_web_client_id
                .requestEmail()
                .build();
        googleApiClient=new GoogleApiClient.Builder(context)
                .enableAutoManage((FragmentActivity) context, new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                        Log.d(TAG, "onConnectionFailed: connection failed");
                    }
                })
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();

        return googleApiClient;
    }

    public void handleSignInResult(GoogleSignInResult result, Context context){
        if(result.isSuccess()){
            GoogleSignInAccount account = result.getSignInAccount();
            idToken = account.getIdToken();
            name = account.getDisplayName();
            email = account.getEmail();
            // you can store user data to SharedPreference
            AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
            firebaseAuthWithGoogle(credential, context);
        }else{
            // Google Sign In failed, update UI appropriately
            Log.e(TAG, "Login Unsuccessful. "+result);
            Toast.makeText(context, "Login Unsuccessful", Toast.LENGTH_SHORT).show();
        }
    }

    private void firebaseAuthWithGoogle(AuthCredential credential, Context context){
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener((Activity)context, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInWithCredential:onComplete:" + task.isSuccessful());
                        if(task.isSuccessful()){
                            Toast.makeText(context, "Login successful", Toast.LENGTH_SHORT).show();
                            if(navigate != null)
                                navigate.onNavigate();
                        }else{
                            Log.w(TAG, "signInWithCredential" + task.getException().getMessage());
                            task.getException().printStackTrace();
                            Toast.makeText(context, "Authentication failed.", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }

    // for login through email

    public void registerUser(Context context, String[] array){
        mAuth.createUserWithEmailAndPassword(array[0], array[1])
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(context, "Registration successful", Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(context, "Registration failed", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    public boolean loginUser(Context context, String[] array){
        mAuth.signInWithEmailAndPassword(array[0], array[1])
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            if(navigate != null)
                                navigate.onNavigate();
                        } else {
                            Toast.makeText(context, "Sign In Unsuccessful", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        return false;
    }

}
