package top.lizhengxian.easypermission;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import top.lizhengxian.easypermission.EasyPermissionDialog;
import top.lizhengxian.easypermission.Permission;

public class PermissionActivity extends Activity {
    AlertDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View root = new View(this);
        root.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        root.setBackgroundResource(R.color.transparent);
        setContentView(root);
        mDialog = new EasyPermissionDialog.Builder(this)
                .setMessage("* 同意授权让我们更好的为您服务")
                .addPermission(Permission.PHONE)
                .addPermission(Permission.LOCATION)
                .create();
        mDialog.show();
    }
}
