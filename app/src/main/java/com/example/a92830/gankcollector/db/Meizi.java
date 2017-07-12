package com.example.a92830.gankcollector.db;

import org.litepal.crud.DataSupport;

/**
 * Created by 92830 on 2017/7/11.
 */

public class Meizi extends DataSupport {
    int id;
    String url;

    public void setId(int id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }
}
