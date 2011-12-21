package com.bobboau.December6;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class ColorPickerDialog extends Dialog {
	
	int rgb[] = new int[3];
	int last_rgb[] = new int[3];
	private OnColorListener onColorListener;

	public ColorPickerDialog(Context context, OnColorListener _onColorListener) {
		super(context);
		setContentView(R.layout.color_picker);
		onColorListener = _onColorListener;
	}	
    
	public int get_color()
	{
		return Color.rgb(rgb[0], rgb[1], rgb[2]);
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color_picker);
        
        final ColorPickerDialog me = this;
        
		OnSeekBarChangeListener color_listener = new OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				rgb[((ColorSeekBar)seekBar).getColorIndex()] = progress;
				me.findViewById(R.id.color_background).setBackgroundColor(me.get_color());
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar){
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar){
			}
		};
		
        ((ColorSeekBar)findViewById(R.id.color_red_bar)).setOnSeekBarChangeListener(color_listener);
        ((ColorSeekBar)findViewById(R.id.color_green_bar)).setOnSeekBarChangeListener(color_listener);
        ((ColorSeekBar)findViewById(R.id.color_blue_bar)).setOnSeekBarChangeListener(color_listener);
        
        ((Button)findViewById(R.id.color_ok)).setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View unused) {
				me.onColorListener.ColorEvent(me.get_color());
				last_rgb = rgb;
				me.dismiss();
			}
        });
        
        ((Button)findViewById(R.id.color_cancel)).setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View unused) {
				rgb = last_rgb;
		        ((ColorSeekBar)me.findViewById(R.id.color_red_bar)).setProgress(rgb[0]);
		        ((ColorSeekBar)me.findViewById(R.id.color_green_bar)).setProgress(rgb[1]);
		        ((ColorSeekBar)me.findViewById(R.id.color_blue_bar)).setProgress(rgb[2]);
				me.findViewById(R.id.color_background).setBackgroundColor(me.get_color());
				me.dismiss();
			}
        });
        
   }
}
