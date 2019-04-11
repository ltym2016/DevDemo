package com.samluys.devdemo.day1127;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.samluys.devdemo.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author luys
 * @describe
 * @date 2018/11/27
 * @email samluys@foxmail.com
 */
public class MoveAdapter extends RecyclerView.Adapter {

    private List<String> mList;
    private Context mContext;


    public MoveAdapter(Context context, List<String> mList) {
        this.mList = mList;
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.tv_content.setText(mList.get(position));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, mList.get(position)+"", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView tv_content;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_content = itemView.findViewById(R.id.tv_content);
        }
    }
}
