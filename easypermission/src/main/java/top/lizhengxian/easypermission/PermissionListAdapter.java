package top.lizhengxian.easypermission;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2017/2/22.
 *
 * @author Administrator
 * @date 2017/02/22
 */

public class PermissionListAdapter extends BaseAdapter {

    private final Context mContext;
    private List<Permission> mPermissions = Collections.emptyList();

    public PermissionListAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mPermissions.size();
    }

    @Override
    public Permission getItem(int position) {
        return mPermissions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.dialog_permission_tips_item, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Permission permission = getItem(position);
        holder.mIconImageView.setImageResource(permission.imageResId);
        holder.mTitleTextView.setText(permission.title);
        holder.mDescriptionTextView.setText(permission.description);
        return convertView;
    }

    public void setPermissions(List<Permission> permissions) {
        mPermissions = permissions;
    }

    class ViewHolder {
        public ImageView mIconImageView;
        public TextView mTitleTextView;
        public TextView mDescriptionTextView;

        public ViewHolder(View rootView) {
            mIconImageView = (ImageView) rootView.findViewById(R.id.permission_dialog_tips_icon);
            mTitleTextView = (TextView) rootView.findViewById(R.id.permission_dialog_tips_title);
            mDescriptionTextView = (TextView) rootView.findViewById(R.id.permission_dialog_tips_description);
        }
    }
}
