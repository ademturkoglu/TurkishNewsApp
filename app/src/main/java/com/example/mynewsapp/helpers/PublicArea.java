package com.example.mynewsapp.helpers;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.widget.EditText;

import com.example.mynewsapp.R;

public class PublicArea {
    static Activity activity;
    public PublicArea(Activity activity) {
        this.activity = activity;

    }
    public void editTextNormalTint(EditText editText) {
        editText.clearFocus();
        editText.setBackgroundTintList(ColorStateList.valueOf(activity.getResources().getColor(R.color.colorFocusEditText)));
        editText.requestFocus();
    }

    public void editTextAttentionTint(EditText editText) {
        editText.clearFocus();
        editText.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(245, 166, 35)));
        editText.requestFocus();
        editText.requestFocus();
    }

    public void editTextAlertTint(EditText editText) {
        editText.clearFocus();
        editText.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(208, 2, 27)));
        editText.requestFocus();
        editText.requestFocus();
    }

}
