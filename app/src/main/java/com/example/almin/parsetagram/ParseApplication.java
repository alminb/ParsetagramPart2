package com.example.almin.parsetagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("7CzZKf5pnkYtTUam0x6r0xUtOUgdQ6ezCQ8xQchI") // should correspond to Application Id env variable
                .clientKey("7WZXL0BeOSN2AA1eT3E3yk17QD3IpUtVhMioX3hU")  // should correspond to Client key env variable
                .server("https://parseapi.back4app.com").build());
    }
}
