package top.lizhengxian.easypermission;

import android.Manifest;

/**
 * Created by Administrator on 2017/2/22.
 *
 * @author Administrator
 * @date 2017/02/22
 */

public enum Permission {
    /**
     * 读写外存
     */
    STORAGE(R.drawable.dialog_startup_permission_storage,"存储","下载文件到SD卡", Manifest.permission.WRITE_EXTERNAL_STORAGE)
    /**
     * 读取通讯录和设备信息如IMEI
     */
    ,PHONE(R.drawable.dialog_permission_phone,"电话","仅获取IMEI作特征码识别",Manifest.permission.READ_PHONE_STATE)
    /**
     * 定位
     */
    ,LOCATION(R.drawable.dialog_startup_permission_storage, "位置", "获取位置信息更好地为您提供本地推荐",Manifest.permission.ACCESS_FINE_LOCATION)
    ;
    /**
     * Display in item with bold style
     */
    public String title;
    /**
     * Display under title
     */
    public String description;
    /**
     * Display in left
     */
    public int imageResId;
    /**
     * The permission whose name was declaimed in framework
     */

    public String permName;

    private Permission( int imageResId, String title, String description,String permName) {
        this.title = title;
        this.description = description;
        this.imageResId = imageResId;
        this.permName = permName;
    }
}
