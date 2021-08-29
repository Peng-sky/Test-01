package com.peng.viewstate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.ClipData;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "ffan";

    Button stateButton;
    CheckBox mCheckBox;
    TextView mTextView;
    ViewStub mViewStub;
    ConstraintLayout mConstraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stateButton = findViewById(R.id.btn_view_state);
        mCheckBox = findViewById(R.id.checkbox);
        mTextView = findViewById(R.id.textView);
        mViewStub = findViewById(R.id.view_stub);
        mConstraintLayout = findViewById(R.id.drag_layout);
        mConstraintLayout.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                Log.d(TAG, "onDrag: " + v);
                return true;
            }
        });

        View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(stateButton);
        mCheckBox.startDragAndDrop(null, shadowBuilder,null,  View.DRAG_FLAG_GLOBAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.d("ffan", "onWindowFocusChanged: " + hasFocus);
    }

    public void focused(View view) {
        stateButton.setFocusable(!stateButton.hasFocus());
    }


    public void pressed(View view) {
        stateButton.setPressed(!stateButton.isPressed());
    }

    public void checked(View view) {
        mCheckBox.setChecked(!mCheckBox.isChecked());
    }

    public void enabled(View view) {
        stateButton.setEnabled(!stateButton.isEnabled());
    }

    public void selected(View view) {
        mTextView.setSelected(!mTextView.isSelected());
    }

    public void inflateViewStub(View view) {
        mViewStub.inflate();
    }
}