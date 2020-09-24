package com.example.demo12_touch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConstraintLayout rootLayout = findViewById(R.id.rootLayout);
        rootLayout.setOnTouchListener(this);
        textView = findViewById(R.id.textView1);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        String coordinate = String.format("@[%.1f,%.1f]", motionEvent.getX(), motionEvent.getY());
        switch (motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                textView.setBackgroundColor(Color.RED);

                textView.setText("Click down at:" + coordinate);
                textView.setTextColor(Color.WHITE);

                break;
            case MotionEvent.ACTION_MOVE:
                textView.setBackgroundColor(Color.GREEN);
                textView.setTextColor(Color.WHITE);
                textView.setText("move at:" + coordinate);
                break;

            case MotionEvent.ACTION_UP:
                textView.setBackgroundColor(Color.BLUE);
                textView.setTextColor(Color.WHITE);
                textView.setText("Release up at:" + coordinate);
                break;
        }
        if(motionEvent.getY() > 1000){
            return false;//
        }
        return true; //
        //true means you consumed the event and want the rest of the events in the gesture - other listeners/views will not receive the events. false means let someone else handle the event. It's actually a bit more specific than that though
    }
}