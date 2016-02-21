package com.russelarms.digitdrawable;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    DigitDrawable mDrawable;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_cart_white);
        mDrawable = new DigitDrawable(bitmap);

        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab);
        fab2.setImageDrawable(mDrawable);
        fab2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mDrawable.setCounter(++count % 30);
    }
}
