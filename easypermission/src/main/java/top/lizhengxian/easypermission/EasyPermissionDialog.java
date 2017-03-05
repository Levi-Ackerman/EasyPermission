package top.lizhengxian.easypermission;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/20.
 */

public class EasyPermissionDialog extends AlertDialog {
    private Context mContext;
    private View mTipsDialogView;
    private TextView mTitle;
    private TextView mContentText;
    private TextView mNextButton;
    private ListView mPermListView;
    private TextView mExitButton;
    private List<Permission> mPermissions;

    protected EasyPermissionDialog(final Context context) {
        super(context);
        this.mContext = context;
        mTipsDialogView = LayoutInflater.from(context).inflate(R.layout.dialog_permission_tips, null);
        setView(mTipsDialogView,0,0,0,0);
        mTitle = (TextView) mTipsDialogView.findViewById(R.id.permission_dialog_tips_title);
        mContentText = (TextView) mTipsDialogView.findViewById(R.id.permission_dialog_tips_harm_text);
        mNextButton = (TextView) mTipsDialogView.findViewById(R.id.permission_dialog_tips_next_button);
        mPermListView = (ListView) mTipsDialogView.findViewById(R.id.permission_dialog_list);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    String[] permissionStrs = new String[mPermissions.size()];
                    for (int i = 0; i < mPermissions.size(); i++) {
                        permissionStrs[i] = mPermissions.get(i).permName;
                    }
                    ((Activity)context).requestPermissions(permissionStrs,0);
                }
            }
        });
    }

    private void setPermissionList(List<Permission> permissions) {
        this.mPermissions = permissions;
        PermissionListAdapter adapter = new PermissionListAdapter(this.mContext);
        adapter.setPermissions(permissions);
        mPermListView.setAdapter(adapter);
    }

    private void setNextButton(String text, final OnClickListener onClickListener) {
        mNextButton.setText(text);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onClick(EasyPermissionDialog.this, DialogInterface.BUTTON_POSITIVE);
            }
        });
    }

    private void setExitButton(String text, final OnClickListener onClickListener) {
        mExitButton.setText(text);
        mExitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onClick(EasyPermissionDialog.this, DialogInterface.BUTTON_NEGATIVE);
            }
        });
    }
    @Override
    public void setTitle(CharSequence title) {
        mTitle.setText(title);
    }

    @Override
    public void setMessage(CharSequence message) {
        mContentText.setText(message);
    }

    public static class Builder {
        private EasyPermissionDialog mDialog;
        private List<Permission> mPermissions;

        public Builder(Context context) {
            mDialog = new EasyPermissionDialog(context);
            mPermissions = new ArrayList<Permission>();
        }

        public Builder setTitle(String title) {
            mDialog.setTitle(title);
            return this;
        }

        public Builder setNextButton(String text, DialogInterface.OnClickListener onClickListener) {
            mDialog.setNextButton(text, onClickListener);
            return this;
        }

        public Builder setMessage(String message) {
            mDialog.setMessage(message);
            return this;
        }

        public Builder addPermission(Permission permission){
            mPermissions.add(permission);
            return this;
        }

        public Builder setExitButtion(String text, DialogInterface.OnClickListener onClickListener) {
            mDialog.setExitButton(text, onClickListener);
            return this;
        }

        public EasyPermissionDialog create() {
            if (BuildConfig.DEBUG && mPermissions.size() == 0) {
                throw new AssertionError("You must add one permission item at least!");
            }
            mDialog.setPermissionList(mPermissions);
            return mDialog;
        }

        public EasyPermissionDialog show() {
            mDialog = create();
            mDialog.show();
            return mDialog;
        }
    }

}
