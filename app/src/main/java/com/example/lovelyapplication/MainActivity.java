package com.example.lovelyapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private CustomView vCustomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vCustomView = (CustomView) findViewById(R.id.custView);
    }

    public void buttonClick(View view) {
        String[] array = getResources().getStringArray(R.array.example_name);
        String randomStr = array[new Random().nextInt(array.length)];

        int[] circleColorArray = getResources().getIntArray(R.array.rainbow);
        int randomColor = circleColorArray[new Random().nextInt(circleColorArray.length)];
        vCustomView.setCircleColor(randomColor);
        vCustomView.setLabelColor(Color.WHITE);
        vCustomView.setLabelText(randomStr);
    }
}
