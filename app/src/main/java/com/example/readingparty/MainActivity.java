package com.example.readingparty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
        finish();
    }
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event)
//    {
//        startActivity(new Intent(MainActivity.this, HelloActivity.class));
//        Toast.makeText(this,"onBackPressed", Toast.LENGTH_SHORT).show();
//
//        if(keyCode== KeyEvent.KEYCODE_BACK)   {
//
//            finish();
//        }
//        return true;
//    }
}