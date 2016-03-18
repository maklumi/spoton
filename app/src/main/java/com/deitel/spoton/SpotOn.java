package com.deitel.spoton;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class SpotOn extends Activity {
    private SpotOnView view; // displays and manages the game

    // called when this Activity is first created
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spot_on);

        // create a new SpotOnView and add it to the RelativeLayout
        RelativeLayout layout =
                (RelativeLayout) findViewById(R.id.relativeLayout);
        view = new SpotOnView(this, getPreferences(Context.MODE_PRIVATE),
                layout);
        layout.addView(view, 0); // add view to the layout
    }//onCreate(Bundle savedInstanceState)

    // called when this Activity moves to the background
    @Override
    public void onPause() {
        super.onPause();
        view.pause(); // release resources held by the View
    }//onPause()

    // called when this Activity is brought to the foreground
    @Override
    public void onResume() {
        super.onResume();
        view.resume(this); // re-initialize resources released in onPause
    }//onResume()
}//class

/*
* Modified from source code provided by Deitel & Associates, Inc. and
* Pearson Education, Inc.
*/

