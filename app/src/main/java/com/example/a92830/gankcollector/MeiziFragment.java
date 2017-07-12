package com.example.a92830.gankcollector;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a92830.gankcollector.Util.HttpUtil;
import com.example.a92830.gankcollector.Util.Utility;
import com.example.a92830.gankcollector.db.Meizi;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import org.litepal.crud.DataSupport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MeiziFragment extends Fragment {
    private List<Meizi> meiziList;
    private View view;
    private MeiziAdapter meiziAdapter;
    private PullLoadMoreRecyclerView mPullLoadMoreRecyclerView;

    private static final String TAG = "MeiziFragment";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        meiziList = DataSupport.findAll(Meizi.class);
        if (meiziList.size() > 0) {
            meiziList.clear();
            HttpUtil.sendOkhttpRequest("http://gank.io/api/data/福利/20/1",
                    new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(MyApplication.getContext(), "加载失败", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            Log.d(TAG, "result: yes");
                            String responseText = response.body().string();
                            Log.d(TAG, responseText);
                            Utility.handleMeiziResponse(responseText);
                        }
                    });
        }
        meiziList = DataSupport.findAll(Meizi.class);
        Log.d(TAG, "size:" +meiziList.size());
        view = inflater.inflate(R.layout.fragment_meizi, container, false);
        mPullLoadMoreRecyclerView = view.findViewById(R.id.pullLoadMoreRecyclerView);
        meiziAdapter = new MeiziAdapter(meiziList);
        mPullLoadMoreRecyclerView.setAdapter(meiziAdapter);
        mPullLoadMoreRecyclerView.setGridLayout(2);//参数为列
        return view;
    }
}
