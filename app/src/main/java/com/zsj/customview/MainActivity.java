package com.zsj.customview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.zsj.customview.practice1.Practice1Activity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "zsj-login";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onDrawOne(View view) {
        Intent intent = new Intent(MainActivity.this, Practice1Activity.class);
        startActivity(intent);
    }

}
