package com.example.assignment;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.assignment.R;

public class SharedPreferenceConfig {

    private Context context;
    SharedPreferences sharedPreferences;

    public SharedPreferenceConfig(Context context){

        this.context = context;
        sharedPreferences = context.getSharedPreferences(context.getResources().getString(R.string
                .app_name),Context.MODE_PRIVATE);
    }
    public void writeLoginStatus (boolean status){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(context.getResources().getString(R.string.app_name),status);
        editor.commit();
    }
    public boolean readLoginStatus() {

        boolean status = false;
        status = sharedPreferences.getBoolean(context.getResources().getString(R.string.app_name), false);
        return status;
    }
}



