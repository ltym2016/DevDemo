package com.samluys.devdemo.day1127;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.samluys.devdemo.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerViewMoveActivity extends AppCompatActivity {

    RecyclerView rv_content;
    Button btn_click;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_move);

        rv_content = findViewById(R.id.rv_content);

        final List<String> list = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            list.add(i+"");
        }

        final MoveAdapter moveAdapter = new MoveAdapter(this,list);
        rv_content.setLayoutManager(new LinearLayoutManager(this));
        rv_content.setAdapter(moveAdapter);


        btn_click = findViewById(R.id.btn_click);

        final int fromPosition = 9;
        final int toPosition = 0;

        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i = fromPosition; i > toPosition; i--) {
                    Collections.swap(list, i, i - 1);
                }
                moveAdapter.notifyItemMoved(fromPosition, toPosition);
                moveAdapter.notifyItemChanged(toPosition);
                moveAdapter.notifyItemRangeChanged(0,moveAdapter.getItemCount());
                rv_content.scrollToPosition(0);
            }
        });

    }
}
