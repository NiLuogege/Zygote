package com.tmholter.pediatrics.xhjdemo.other;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.tmholter.pediatrics.xhjdemo.R;
import com.tmholter.pediatrics.xhjdemo.common.view.view.BetterRecyclerView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {

    @Bind(R.id.indicator)
    SimpleViewPagerIndicator mIndicator;

    private static final int RC_CAMERA_AND_WIFI = 0x01;//这个就是RequestCode
    private BetterRecyclerView rv;
    private MainActivity context;
    private String[] mTitles = new String[]{"简介", "评价", "相关"};
    private LinearLayoutManager mLinearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        this.context = this;

        rv = (BetterRecyclerView) findViewById((R.id.rv));

        RvAdapter rvAdapter = new RvAdapter(context);
        rv.setAdapter(rvAdapter);
        mLinearLayoutManager = new LinearLayoutManager(context);
        rv.setLayoutManager(mLinearLayoutManager);
        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
//                View childAt = rv.getChildAt(3);
                View childAt = mLinearLayoutManager.findViewByPosition(3);

//                Log.e("RecycleViewpollActivity", "childAt:" + childAt+" viewByPosition="+viewByPosition);
                if (childAt != null) {
                    int top = childAt.getTop() + 80;//这里的80是因为在item_type_3中 全部商品这个textVie的高度设置为了80,如果真的要使用的话需要用dp 或者动态获取
                    Log.e("RecycleViewpollActivity", "top:" + top);
                    if (top <= 0) {
                        mIndicator.setVisibility(View.VISIBLE);
                    } else {
                        mIndicator.setVisibility(View.GONE);
                    }
                }
            }
        });


        mIndicator.setTitles(mTitles);

        requestCallPhonePermission();


    }

    @AfterPermissionGranted(RC_CAMERA_AND_WIFI)
    private void requestCallPhonePermission() {
        String[] perms = {Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION};
        if (EasyPermissions.hasPermissions(this, perms)) {//已经拥有
            Log.e("RecycleViewpollActivity", "有权限");
        } else {
            Log.e("RecycleViewpollActivity", "没有权限");
            EasyPermissions.requestPermissions(this, "拍照需要摄像头权限", RC_CAMERA_AND_WIFI, perms);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    /**
     * 同意
     *
     * @param requestCode
     * @param perms
     */
    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        Log.e("RecycleViewpollActivity", "onPermissionsGranted " + perms);
    }

    /**
     * 不同意
     *
     * @param requestCode
     * @param perms
     */
    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        Log.e("RecycleViewpollActivity", "onPermissionsDenied " + perms);

        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this)
                    .setTitle("提示")
                    .setPositiveButton("去设置")
                    .setNegativeButton("取消")
                    .setRationale("球球你去开启权限吧")
                    .setRequestCode(RC_CAMERA_AND_WIFI)
                    .build()
                    .show();
        }
    }
}
