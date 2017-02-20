package top.lizhengxian.easypermission.sample;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;

import top.lizhengxian.easypermission.EasyPermissionDialog;

public class MainActivity extends Activity {
    AlertDialog mDialog;
    private final static String[] LOCATION_PERMISSIONS = {Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION};
    private final static String[] STORAGE_PERMISSIONS = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
    private final static String[] PHONE_PERMISSIONS = {Manifest.permission.READ_PHONE_STATE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDialog = new EasyPermissionDialog.Builder(this)
                .setMessage("* 同意授权让我们更好的为您服务")
                .addPermission(R.drawable.dialog_startup_permission_storage,STORAGE_PERMISSIONS,"存储","下载文件到SD卡")
                .addPermission(R.drawable.dialog_permission_phone, PHONE_PERMISSIONS,"电话","仅获取IMEI作特征码识别")
                .addPermission(R.drawable.dialog_startup_permission_storage, LOCATION_PERMISSIONS, "位置", "获取位置信息更好地为您提供本地推荐")
                .create();
        mDialog.show();
    }
}
