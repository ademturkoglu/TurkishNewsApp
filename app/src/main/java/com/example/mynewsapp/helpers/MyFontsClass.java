package com.example.mynewsapp.helpers;


import android.app.Activity;
import android.graphics.Typeface;
import android.widget.TextView;

    /*

        This class contains fonts used all over the project.

     */

public class MyFontsClass {

    Activity activity;

    public MyFontsClass(Activity activity) {
        this.activity = activity;
    }

    public Typeface getFont900() {
        return Typeface.createFromAsset(activity.getAssets(), "fonts/rawline-900.ttf");
    }
    public Typeface getFont800() {
        return Typeface.createFromAsset(activity.getAssets(), "fonts/rawline-800.ttf");
    }
    public Typeface getFont700() {
        return Typeface.createFromAsset(activity.getAssets(), "fonts/rawline-700.ttf");
    }
    public Typeface getFont600() {
        return Typeface.createFromAsset(activity.getAssets(), "fonts/rawline-600.ttf");
    }
    public Typeface getFont500() {
        return Typeface.createFromAsset(activity.getAssets(), "fonts/rawline-500.ttf");
    }
    public Typeface getFont400() {
        return Typeface.createFromAsset(activity.getAssets(), "fonts/rawline-400.ttf");
    }
    public Typeface getFont300() {
        return Typeface.createFromAsset(activity.getAssets(), "fonts/rawline-300.ttf");
    }
    public Typeface getFont200() {
        return Typeface.createFromAsset(activity.getAssets(), "fonts/rawline-200.ttf");
    }
    public Typeface getFont100() {
        return Typeface.createFromAsset(activity.getAssets(), "fonts/rawline-100.ttf");
    }
    public Typeface getFont900i() {
        return Typeface.createFromAsset(activity.getAssets(), "fonts/rawline-900i.ttf");
    }
    public Typeface getFont800i() {
        return Typeface.createFromAsset(activity.getAssets(), "fonts/rawline-800i.ttf");
    }
    public Typeface getFont700i() {
        return Typeface.createFromAsset(activity.getAssets(), "fonts/rawline-700i.ttf");
    }
    public Typeface getFont600i() {
        return Typeface.createFromAsset(activity.getAssets(), "fonts/rawline-600i.ttf");
    }
    public Typeface getFont500i() {
        return Typeface.createFromAsset(activity.getAssets(), "fonts/rawline-500i.ttf");
    }
    public Typeface getFont400i() {
        return Typeface.createFromAsset(activity.getAssets(), "fonts/rawline-400i.ttf");
    }
    public Typeface getFont300i() {
        return Typeface.createFromAsset(activity.getAssets(), "fonts/rawline-300i.ttf");
    }
    public Typeface getFont200i() {
        return Typeface.createFromAsset(activity.getAssets(), "fonts/rawline-200i.ttf");
    }
    public Typeface getFont100i() {
        return Typeface.createFromAsset(activity.getAssets(), "fonts/rawline-100i.ttf");
    }
    public void setTextViewFont (Typeface font, TextView... textViews) {
        for (int i = 0; i < textViews.length; i++)
            textViews[i].setTypeface(font);
    }

}
