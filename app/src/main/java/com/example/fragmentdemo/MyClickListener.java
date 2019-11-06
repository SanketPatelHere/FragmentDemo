package com.example.fragmentdemo;
import android.view.View;
public interface MyClickListener {
    public void myOnClick(int position);
    public void myLongOnClick(View v, int position);
}
