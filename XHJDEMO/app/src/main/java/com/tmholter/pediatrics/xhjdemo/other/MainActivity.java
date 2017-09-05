package com.tmholter.pediatrics.xhjdemo.other;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.tmholter.pediatrics.xhjdemo.R;

import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {

    private static final int RC_CAMERA_AND_WIFI = 0x01;//这个就是RequestCode
    private RecyclerView rv;
    private MainActivity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.context = this;

        rv = (RecyclerView) findViewById((R.id.rv));

        RvAdapter rvAdapter = new RvAdapter(context);
        rv.setAdapter(rvAdapter);
        rv.setLayoutManager(new LinearLayoutManager(context));

        requestCallPhonePermission();


    }

    @AfterPermissionGranted(RC_CAMERA_AND_WIFI)
    private void requestCallPhonePermission() {
        String[] perms = {Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION};
        if (EasyPermissions.hasPermissions(this, perms)) {//已经拥有
            Log.e("MainActivity", "有权限");
        } else {
            Log.e("MainActivity", "没有权限");
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
        Log.e("MainActivity", "onPermissionsGranted " + perms);
    }

    /**
     * 不同意
     *
     * @param requestCode
     * @param perms
     */
    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        Log.e("MainActivity", "onPermissionsDenied " + perms);

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
