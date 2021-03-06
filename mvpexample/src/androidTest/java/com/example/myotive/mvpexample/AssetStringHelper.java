package com.example.myotive.mvpexample;

import android.support.test.InstrumentationRegistry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by michaelyotive_hr on 1/1/17.
 */

public class AssetStringHelper {
    public static String readAssetString(String fileName) throws IOException {

        StringBuilder buf=new StringBuilder();
        InputStream json = InstrumentationRegistry.getContext().getAssets().open(fileName);

        BufferedReader in=
                new BufferedReader(new InputStreamReader(json, "UTF-8"));
        String str;

        while ((str=in.readLine()) != null) {
            buf.append(str);
        }

        in.close();

        return buf.toString();
    }
}
