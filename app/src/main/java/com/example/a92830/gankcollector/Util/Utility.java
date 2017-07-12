package com.example.a92830.gankcollector.Util;

import android.text.TextUtils;
import android.util.Log;

import com.example.a92830.gankcollector.Gson.MeiziImage;
import com.example.a92830.gankcollector.db.Meizi;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by 92830 on 2017/7/11.
 */

public class Utility {
    private static final String TAG = "Utility";

    public static void handleMeiziResponse(String respnse) {
        if (!TextUtils.isEmpty(respnse)) {
            try {
                Gson gson = new Gson();
                MeiziImage meiziImage = gson.fromJson(respnse,MeiziImage.class);
                for (MeiziImage.ResultsBean result : meiziImage.getResults()) {
                    Meizi meizi = new Meizi();
                    meizi.setUrl(result.getUrl());
                    meizi.save();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
