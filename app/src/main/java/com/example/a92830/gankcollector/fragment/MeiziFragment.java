package com.example.a92830.gankcollector.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.a92830.gankcollector.Adapter.MeiziAdapter;
import com.example.a92830.gankcollector.R;
import com.example.a92830.gankcollector.Util.HttpUtil;
import com.example.a92830.gankcollector.Util.Utility;
import com.example.a92830.gankcollector.config.MyApplication;
import com.example.a92830.gankcollector.db.Meizi;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import org.litepal.crud.DataSupport;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MeiziFragment extends Fragment {
    public static List<Meizi> meiziList;
    private FloatingActionButton fab;
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
        view = inflater.inflate(R.layout.fragment_meizi, container, false);
        fab= view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPullLoadMoreRecyclerView.scrollToTop();
            }
        });
        mPullLoadMoreRecyclerView = view.findViewById(R.id.pullLoadMoreRecyclerView);
        meiziList = DataSupport.findAll(Meizi.class);
        meiziAdapter = new MeiziAdapter(meiziList);
        mPullLoadMoreRecyclerView.setAdapter(meiziAdapter);
        mPullLoadMoreRecyclerView.setStaggeredGridLayout(2);//参数为列
        mPullLoadMoreRecyclerView.setPullRefreshEnable(false);
        CheckDatabase();
        mPullLoadMoreRecyclerView.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
            @Override
            public void onRefresh() {
            }
            @Override
            public void onLoadMore() {
                LoadImageFromInternet();
            }
        });
        return view;
    }

    public void LoadImageFromInternet() {
        HttpUtil.sendOkhttpRequest("http://gank.io/api/data/福利/10/" + (DataSupport.findAll(Meizi.class).size() / 10 + 1), new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MyApplication.getContext(),"加载失败",Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseText = response.body().string();
                Utility.handleMeiziResponse(responseText);
            }
        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                meiziAdapter.notifyDataSetChanged();
                mPullLoadMoreRecyclerView.setPullLoadMoreCompleted();
            }
        },1000);
    }

    public void CheckDatabase() {
        if (DataSupport.findAll(Meizi.class).size() == 0) {
            HttpUtil.sendOkhttpRequest("http://gank.io/api/data/福利/10/1", new Callback() {
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
                    final String responseText = response.body().string();
                    Utility.handleMeiziResponse(responseText);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            meiziAdapter.notifyDataSetChanged();
                        }
                    });
                }
            });
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
