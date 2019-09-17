package com.samluys.devdemo.jetpack.viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import com.samluys.devdemo.R;
import com.samluys.devdemo.databinding.ActivityViewModelActivtyBinding;

public class ViewModelActivity extends AppCompatActivity {

    private MyViewModel myViewModel;
    private ActivityViewModelActivtyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model_activty);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_model_activty);
        myViewModel = ViewModelProviders.of(this,
                new SavedStateViewModelFactory(this.getApplication(), this)).get(MyViewModel.class);

//        if (savedInstanceState != null) {
//            myViewModel.getNumber().setValue(savedInstanceState.getInt("number"));
//        }

        binding.setViewModel(myViewModel);
        binding.setLifecycleOwner(this);
    }

//    @Override
//    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
//        super.onSaveInstanceState(outState, outPersistentState);
//        outState.putInt("number", myViewModel.getNumber().getValue());
//    }
}
