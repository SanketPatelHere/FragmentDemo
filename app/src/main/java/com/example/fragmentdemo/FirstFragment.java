package com.example.fragmentdemo;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FirstFragment extends Fragment {
    Button btnSubmit1;
    public MyClickListener li;
    public FirstFragment(MyClickListener listener) {
        // Required empty public constructor
        this.li = listener;
    }
    public FirstFragment() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_first, container, false);
        btnSubmit1 = (Button)v.findViewById(R.id.btnSubmit1);
        //btnSubmit1 = (Button)container.findViewById(R.id.btnSubmit1);
        btnSubmit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                li.myOnClick(10);
            }
        });
        return v;
        //return inflater.inflate(R.layout.fragment_first, container, false);
    }

}
