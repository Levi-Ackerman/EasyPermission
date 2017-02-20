package top.lizhengxian.easypermission;

/**
 * Created by Administrator on 2017/2/22.
 *
 * @author Administrator
 * @date 2017/02/22
 */

public class Permission {
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

    public String[] permName;

    public Permission(String title, String description, int imageResId, String[] permNames) {
        this.title = title;
        this.description = description;
        this.imageResId = imageResId;
        this.permName = permNames;
    }
}
