package com.example.rmp2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class secondActivity extends AppCompatActivity {
    public final String KEY = "key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        getArgs();
    }

    private void getArgs(){
        Bundle arg = getIntent().getExtras();
        assert arg != null;
        String name = Objects.requireNonNull(arg.get("key")).toString();
        Log.i(MainActivity.TAG, name);
    }

    public void onClick1(View view) {
        Intent intent = new Intent();
        intent.putExtra(KEY, "hehe");
        setResult(RESULT_OK, intent);
        finish();
    }
}