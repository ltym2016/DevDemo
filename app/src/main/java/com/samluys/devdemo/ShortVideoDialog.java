package com.samluys.devdemo;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

/**
 * @author luys
 * @describe 短视频拍摄选择Dialog
 * @date 2019/5/9
 * @email ltym_lys@126.com
 */
public class ShortVideoDialog extends DialogFragment implements View.OnClickListener {

    private TextView mTVVideo;
    private ImageView mIVClose;
    private TextView mTVEditer;
    private TextView mTVPicture;
    private int mFrom;
    private FragmentManager manager;

    public static ShortVideoDialog newInstance(int from) {
        ShortVideoDialog dialog = new ShortVideoDialog();
        Bundle bundle = new Bundle();
        bundle.putInt("VIDEO_DIALOG_FROM", from);
        dialog.setArguments(bundle);
        return dialog;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Dialog dialog = new Dialog(getActivity(), R.style.BottomDialog);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_short_video);
        dialog.setCanceledOnTouchOutside(true);

        mTVVideo = dialog.findViewById(R.id.tv_record);
        mTVEditer = dialog.findViewById(R.id.tv_editer);
        mTVPicture = dialog.findViewById(R.id.tv_picture);
        mIVClose = dialog.findViewById(R.id.iv_close);

        mTVVideo.setOnClickListener(this);
        mTVEditer.setOnClickListener(this);
        mTVPicture.setOnClickListener(this);
        mIVClose.setOnClickListener(this);

        return dialog;
    }

    @Override
    public void onStart() {
        super.onStart();


        try {
            // 设置宽度为屏宽, 靠近屏幕底部。
            Window window = getDialog().getWindow();
            WindowManager.LayoutParams lp = window.getAttributes();
            lp.gravity = Gravity.BOTTOM;
            lp.width = WindowManager.LayoutParams.MATCH_PARENT; // 宽度持平
            window.setAttributes(lp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_record:
                dismissDialog();
                break;
            case R.id.tv_editer:
                dismissDialog();
                break;
            case R.id.tv_picture:
                dismissDialog();
                break;
            case R.id.iv_close:
                dismissDialog();
                break;
        }
    }

    public void showDialog(FragmentManager fragmentManager, String tag) {
        manager = fragmentManager;
        if (!isAdded()) {
            show(fragmentManager, tag);
        }

    }

    public void dismissDialog() {
//        if (ShortVideoDialog.this.isAdded()) {
//            ShortVideoDialog.this.dismiss();
//            if (getDialog() != null) {
//                getDialog().dismiss();
//            }
//        }
        dismiss();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        manager = null;
        if (getDialog() != null) {
            getDialog().dismiss();
        }
    }
}
