package com.example.fragmentdemo;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyClickListener{
    Button btn1, btn2;
    MyClickListener listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentLoad(new FirstFragment(listener));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecondFragment s = new SecondFragment();
                s.mySetListener(MainActivity.this);
                fragmentLoad(s);
            }
        });


        listener = new MyClickListener() {
            @Override
            public void myOnClick(int position) {
                Toast.makeText(getApplicationContext(), "MyOnClick", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void myLongOnClick(View v, int position) {
                Toast.makeText(MainActivity.this, "MyLongOnClick", Toast.LENGTH_SHORT).show();
            }
        };

    }
    public void fragmentLoad(Fragment f)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        //Fragment fragment = new Fragment();
        //ft.add(R.id.fm, f);
        ft.replace(R.id.fm, f);
        //ft.addToBackStack(R.id.fm, f);
        //ft.commit();
        ft.commitAllowingStateLoss();
        //ft.commitNow();
        //ft.addToBackStack("aa");
    }

    @Override
    public void myOnClick(int position) {
        Toast.makeText(getApplicationContext(), "Implemented MyOnClick", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void myLongOnClick(View v, int position) {
        Toast.makeText(getApplicationContext(), "Implemented MyLongOnClick", Toast.LENGTH_SHORT).show();
    }
}
