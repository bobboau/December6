package com.bobboau.December6;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class December6Activity extends Activity {

	static final int COLOR_PICKER_DIALOG_ID = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        findViewById(R.id.background).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				showDialog(COLOR_PICKER_DIALOG_ID);
			}
		});
         
        Toast.makeText(this, "tap to change color", 3000).show();
        
    }
    
	@Override
	protected Dialog onCreateDialog(int id) {
		final December6Activity me = this;
		switch (id) {
			case COLOR_PICKER_DIALOG_ID:
				return new ColorPickerDialog(this, new OnColorListener(){
					public void ColorEvent(int color)
					{
						me.findViewById(R.id.background).setBackgroundColor(color);
					}
				});
		}
		
		//error
		return null;
	}
}