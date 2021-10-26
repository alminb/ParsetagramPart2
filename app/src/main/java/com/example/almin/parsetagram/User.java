package com.example.almin.parsetagram;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;


@ParseClassName("User")
public class User extends ParseObject {

    public static final String KEY_IMAGE = "profileImg";
    public static final String KEY_USER = "username";
    public static final String KEY_CREATED_KEY = "createdAt";

    public ParseFile getProfileImage() {
        return getParseFile(KEY_IMAGE);
    }
    public void setProfileImage(ParseFile parseFile) {
        put(KEY_IMAGE,parseFile);
    }
    public ParseUser getUserName() {
        return getParseUser(KEY_USER);
    }
    public void setUserName(ParseUser user) {
        put(KEY_USER,user);
    }
}
