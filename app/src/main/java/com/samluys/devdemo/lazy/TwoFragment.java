package com.samluys.devdemo.lazy;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.samluys.devdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TwoFragment extends Fragment {


    public TwoFragment() {
        // Required empty public constructor
    }


    private static final String TAG = TwoFragment.class.getCanonicalName();
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        Log.e(TAG, "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.e(TAG, "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        Log.e(TAG, "onCreateView");
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        Log.e(TAG, "onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {

        Log.e(TAG, "onStart");
        super.onStart();
    }

    @Override
    public void onResume() {

        Log.e(TAG, "onResume");
        super.onResume();
    }

    @Override
    public void onPause() {

        Log.e(TAG, "onPause");
        super.onPause();
    }

    @Override
    public void onStop() {

        Log.e(TAG, "onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {

        Log.e(TAG, "onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {

        Log.e(TAG, "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.e(TAG, "onDetach");
        super.onDetach();
    }

}
