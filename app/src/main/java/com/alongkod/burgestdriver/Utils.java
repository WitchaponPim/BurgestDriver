package com.alongkod.burgestdriver;

import android.content.Context;
import android.widget.Toast;

public class Utils {

    public static String ipHost = "http://burgest.apidech.com/inc/";

//    public static String ipPic = "http://192.168.1.33/hamburger/img/";



    public static void toast(Context context, String string) {
        Toast toast = Toast.makeText(context, string, Toast.LENGTH_SHORT);

        toast.show();

    }
}