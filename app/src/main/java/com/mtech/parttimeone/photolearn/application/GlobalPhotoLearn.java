package com.mtech.parttimeone.photolearn.application;

import android.app.Application;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.firebase.auth.FirebaseAuth;
import com.mtech.parttimeone.photolearn.bo.AccountBO;
import com.mtech.parttimeone.photolearn.enumeration.UserType;

/**
 * Created by kunal on 19/3/2018.
 */

public class GlobalPhotoLearn extends Application {

    private FirebaseAuth mAuth;
    private GoogleSignInClient mGoogleSignInClient;
    private UserType mUserType;
    private AccountBO accountBO;

    public UserType getmUserType() {
        return mUserType;
    }

    public void setmUserType(UserType mUserType) {
        this.mUserType = mUserType;
    }

    public void setmAuth(FirebaseAuth mAuth) {
        this.mAuth = mAuth;
    }

    public FirebaseAuth getmAuth() {
        return mAuth;
    }

    public void setmGoogleSignInClient(GoogleSignInClient mGoogleSignInClient) {
        this.mGoogleSignInClient = mGoogleSignInClient;
    }

    public GoogleSignInClient getmGoogleSignInClient() {
        return mGoogleSignInClient;
    }

    public AccountBO getAccountBO() {
        return accountBO;
    }

    public void setAccountBO(AccountBO accountBO) {
        this.accountBO = accountBO;
    }
}
