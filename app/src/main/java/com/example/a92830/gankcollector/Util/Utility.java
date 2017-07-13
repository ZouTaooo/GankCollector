package com.example.a92830.gankcollector.Util;

import android.text.TextUtils;

import com.example.a92830.gankcollector.Gson.MeiziImage;
import com.example.a92830.gankcollector.db.Meizi;
import com.example.a92830.gankcollector.fragment.MeiziFragment;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 92830 on 2017/7/11.
 */

public class Utility {
    private static final String TAG = "Utility";
    private static List<Meizi> list = new ArrayList<>();

    public static void handleMeiziResponse(String respnse) {
        if (!TextUtils.isEmpty(respnse)) {
            try {
                Gson gson = new Gson();
                MeiziImage meiziImage = gson.fromJson(respnse,MeiziImage.class);
                for (MeiziImage.ResultsBean result : meiziImage.getResults()) {
                    Meizi meizi = new Meizi();
                    meizi.setUrl(result.getUrl());
                    meizi.save();
                    MeiziFragment.meiziList.add(meizi);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
