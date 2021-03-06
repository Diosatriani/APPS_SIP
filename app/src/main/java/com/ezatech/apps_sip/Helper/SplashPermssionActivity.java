package com.ezatech.apps_sip.Helper;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ezatech.apps_sip.MainActivity;
import com.ezatech.apps_sip.R;
import com.ezatech.apps_sip.logRes.LoginActivity;

public class SplashPermssionActivity extends AppCompatActivity {

    private PermissionHelper permissionHelper;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_permssion);

        permissionHelper = new PermissionHelper(this);

        checkAndRequestPermission();
    }

    private boolean checkAndRequestPermission() {

        permissionHelper.permissionListener(new PermissionHelper.PermissionListener() {
            @Override
            public void onPermissionCheckDone() {
                intent = new Intent(SplashPermssionActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        permissionHelper.checkAndRequestPermissions();

        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        permissionHelper.onRequestCallBack(requestCode, permissions, grantResults);
    }
}
