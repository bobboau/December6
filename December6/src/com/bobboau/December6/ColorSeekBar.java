package com.bobboau.December6;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.SeekBar;

public class ColorSeekBar extends SeekBar {
	
	private int color_index;

	public ColorSeekBar(Context context, int _color_index) {
		super(context);
		
		color_index = _color_index;
	}
	
	public int getColorIndex()
	{
		return color_index;
	}
	
	public ColorSeekBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		TypedArray a=getContext().obtainStyledAttributes(attrs,R.styleable.ColorSeekBar);
		color_index = a.getInt(R.styleable.ColorSeekBar_color_index, 0);
        a.recycle();		
	}
	
}
