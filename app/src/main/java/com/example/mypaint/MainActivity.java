package com.example.mypaint;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Path;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import com.skydoves.colorpickerview.ColorEnvelope;

import com.skydoves.colorpickerview.ColorPickerDialog;
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener;


public class MainActivity extends AppCompatActivity {
    SimplePaint simplePaint;
    ImageView ivColorPicker;
    ImageView ivSquare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
       simplePaint = findViewById(R.id.simplePaint);
       ivColorPicker = findViewById(R.id.imageViewColorPicker);
       ivSquare = findViewById(R.id.ivChangeToSquare);

       ivColorPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colorPickerSelectColor();
            }
        });

       ivSquare.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               simplePaint.desenhaCirculo = !simplePaint.desenhaCirculo;
           }
       });
    }

    public void colorPickerSelectColor(){
        new ColorPickerDialog.Builder(this)
                .setTitle("ColorPicker Dialog")
                .setPreferenceName("MyColorPickerDialog")
                .setPositiveButton(getString(R.string.confirm),
                        new ColorEnvelopeListener() {
                            @Override
                            public void onColorSelected(ColorEnvelope envelope, boolean fromUser) {
                                setColor(envelope);
                            }
                        })
               .setNegativeButton(getString(R.string.cancel),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                .attachAlphaSlideBar(true) // the default value is true.
                .attachBrightnessSlideBar(true)  // the default value is true.
                .setBottomSpace(12) // set a bottom space between the last slidebar and buttons.
                .show();
    }

    private void setColor(ColorEnvelope envelope) {
        simplePaint.setColor(Color.valueOf(envelope.getColor()));
        ivColorPicker.setColorFilter(Color.valueOf(envelope.getColor()).toArgb());
    }
}