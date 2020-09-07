package com.example.colorpicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import yuku.ambilwarna.AmbilWarnaDialog;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    EditText editText;
    int mDefaultColor;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.layout);
        button = findViewById(R.id.ColorpickerID);
        editText = findViewById(R.id.editID);

        mDefaultColor = ContextCompat.getColor(this,R.color.colorPrimary);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openColor();
            }
        });
    }

    private void openColor() {
        AmbilWarnaDialog picColor = new AmbilWarnaDialog(this, mDefaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {


                mDefaultColor = color;
                editText.setBackgroundColor(mDefaultColor);
            }
        });

        picColor.show();
    }
}