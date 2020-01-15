package com.samluys.devdemo.widgt;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.samluys.devdemo.R;

/**
 * @author luys
 * @describe 回复dialog
 * @date 2019-11-25
 * @email samluys@foxmail.com
 */
public class ReplyViewDialog extends DialogFragment {

    private Context mContext;
    private EditText etInput;
    private ImageView iv_send;
    private Activity mActivity;
    private Handler handler = new Handler();
    private Runnable runnableShowKeyboard = new Runnable() {
        @Override
        public void run() {
            showSoftInput(etInput);
        }
    };

    public static ReplyViewDialog newInstance() {
        ReplyViewDialog dialog = new ReplyViewDialog();
        Bundle args = new Bundle();
        dialog.setArguments(args);
        return dialog;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
        mActivity = (Activity)mContext;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setStyle(STYLE_NO_TITLE, R.style.BottomDialog);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog_reply, container, false);
        etInput = view.findViewById(R.id.et_reply);
        iv_send = view.findViewById(R.id.iv_send);
        etInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideSoftInput();
                } else {
                    showSoftInput(etInput);
                }
            }
        });

        iv_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideSoftInput();
            }
        });
        return view;
    }

    /**
     * 显示回复用户回复框
     *
     * @param fragmentManager
     */
    public void showReplyView(FragmentManager fragmentManager) {
        if (!isAdded()) {
            //这里不直接show而是使用commitAllowingStateLoss是因为如果直接用show可能会因为已经调用了onSaveInstanceState而报IllegalStateException
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.add(this, "Reply");
            ft.commitAllowingStateLoss();
            handler.postDelayed(runnableShowKeyboard, 200);
        }
    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {


        hideSoftInput(etInput);

        super.onDismiss(dialog);
    }

    @Override
    public void onResume() {
        super.onResume();
        if(getDialog() != null) {
            // 设置宽度为屏宽, 靠近屏幕底部。
            Window window = getDialog().getWindow();
            WindowManager.LayoutParams lp = window.getAttributes();
            lp.gravity = Gravity.BOTTOM;
            lp.width = WindowManager.LayoutParams.MATCH_PARENT; // 宽度持平
            window.setAttributes(lp);
            window.setBackgroundDrawable(new ColorDrawable(0xff000000));
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    private void hideSoftInput() {
        hideSoftInput(etInput);
    }


    public void showSoftInput(@NonNull final View view) {
        InputMethodManager imm =
                (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm == null) {
            return;
        }
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        imm.showSoftInput(view, 0, new ResultReceiver(new Handler()) {
            @Override
            protected void onReceiveResult(int resultCode, Bundle resultData) {
                if (resultCode == InputMethodManager.RESULT_UNCHANGED_HIDDEN
                        || resultCode == InputMethodManager.RESULT_HIDDEN) {
                    toggleSoftInput();
                }
            }
        });
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    public void toggleSoftInput() {
        InputMethodManager imm =
                (InputMethodManager) mActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm == null) return;
        imm.toggleSoftInput(0, 0);
    }

    public  void hideSoftInput(@NonNull final View view) {
        InputMethodManager imm =
                (InputMethodManager) mActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm == null) {
            return;
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}
