package com.example.fragmentdemo;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SecondFragment extends Fragment {
    Button btnSubmit2;
    public MyClickListener li;
    public SecondFragment() {
        // Required empty public constructor
    }
    public SecondFragment(MyClickListener listener)
    {
        this.li = listener;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_second, container, false);
        btnSubmit2 = (Button)v.findViewById(R.id.btnSubmit2);
        //btnSubmit2 = (Button)container.findViewById(R.id.btnSubmit2);
        btnSubmit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                li.myOnClick(10);
                Log.i("Fragment onClick","Fragment2");

            }
        });
        return v;
        //return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void mySetListener(MyClickListener li)
    {
        this.li  = li;
    }

}
