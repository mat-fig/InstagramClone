package com.example.instagramclone;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Register your parse models
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("dYZUyMkfXHYVgjoenfTeBcADgvpykSDlcItwxU8X")
                .clientKey("Xmo1U4YOxsq9tPLIEgoQxNAuf0wlP2KHSkKK4Q1N")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
