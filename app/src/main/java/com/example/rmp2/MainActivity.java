package com.example.rmp2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "SUN";
    public final String KEY = "key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, secondActivity.class);
                intent.putExtra(KEY, "hehe");
                mStartForResult.launch(intent);
            }
        });
    }

    public void logClick(View view){
        Log.i(TAG, "Вывод log по нажатию");
    }

    /*public void onClick(View view){
        Intent intent = new Intent(this, secondActivity.class);
        startActivity(intent);
    }*/
    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == AppCompatActivity.RESULT_OK) {
                        Intent data = result.getData();
                        String returnedData = data.getStringExtra("key");
                        Log.i(TAG, "Returned data from SecondActivity: " + returnedData);
                    }
                    else {
                        Log.i(TAG, "No data returned from SecondActivity");
                    }
                }
            }
    );
}